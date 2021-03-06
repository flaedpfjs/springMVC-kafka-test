package com.hhcf.crotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhcf.service.KafkaProducerServer;

/**
 * 
 * @ClassName: ConsumerCrotroller
 * @Description:
 * @author: zhaotf
 * @date: 2017年2月19日 下午2:34:30
 */
@Controller
@RequestMapping("/consumerCrotroller")
public class ConsumerCrotroller {

	@Autowired
	private KafkaProducerServer kafkaProducerServer;

	/**
	 * 通过kafka改善消息
	 * 
	 * @return Object
	 */
	@RequestMapping("/sndMesForTemplate")
	@ResponseBody
	public Object sndMesForTemplate() {
		String topic = "ztfTopic";
		String value = "test,kafka 生产端测试，工工aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String ifPartition = "1";// 是否使用分区 0是\1不是
		Integer partitionNum = 3;
		String role = "test";// 用来生成key
		return kafkaProducerServer.sndMesForTemplate(topic, value, ifPartition, partitionNum, role);
	}

	/**
	 * 模拟kafka官方示例：生产端
	 * 
	 * @return Object
	 */
	@RequestMapping("/sndMsg")
	@ResponseBody
	public Object sndMsg() {
		kafkaProducerServer.sendMessage("hhcfTopic", "keyztf", "test,kafka 生产端测试，工工aaaaaaaaaaaaaa");
		return "aaa";
	}

	@RequestMapping("/getDubboServerData")
	@ResponseBody
	public String getDubboServerData() {
		// String hello = testRegistryService.hello("dubbo 消费端-1");
		// System.out.println(hello);
		String hello = "消息中间件 kafka 生产端-1";
		return hello;
	}

	/**
	 * kafka 分组消费
	 * @return String
	 */
	@RequestMapping("/goIndex")
	@ResponseBody
	public String sendConsumerGroups(String name) {
		return "goIndex中文 测试";
	}

}











