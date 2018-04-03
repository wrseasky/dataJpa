package com.baidu.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author 作者 wr:
 * @version 创建时间：2018年2月2日 下午3:31:15 类说明
 */
@RestController
public class Rabbitmqcontroller {
	@RequestMapping("/zzz")
	public void gg() {

		String exchangeName = "confirmExchange";
		ConnectionFactory factory = new ConnectionFactory();
//		factory.setHost("127.0.0.1");
		factory.setHost("192.168.190.133");

		try {
			Connection connection = factory.newConnection();
			final Channel channel = connection.createChannel();
			channel.exchangeDeclare(exchangeName, "direct");
			channel.confirmSelect();

			// 发送持久化消息
			for (int i = 0; i < 5; i++) {
				channel.basicPublish(exchangeName, "", null, ("第" + (i + 1) + "条消息").getBytes());
			}
			channel.addConfirmListener(new ConfirmListener() {

				public void handleNack(long deliveryTag, boolean multiple) throws IOException {
					System.out.println("nack: deliveryTag = " + deliveryTag + " multiple: " + multiple);
				}

				public void handleAck(long deliveryTag, boolean multiple) throws IOException {
					System.out.println("ack: deliveryTag = " + deliveryTag + " multiple: " + multiple);
				}
			});
			channel.close();
		} catch (Exception e) {

		}

	}
}
