package com.dranawhite.xmlamqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liangyq
 * @version [1.0, 2018/4/11 19:49]
 */
public class Receiver implements MessageListener {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Override
	public void onMessage(Message message) {
		long count = 0;
		String msg = null;
		List<Map<String, Object>> deathList = null;
		try {
			msg = new String(message.getBody(), "UTF-8");
			Map<String, Object> map = message.getMessageProperties().getHeaders();
			deathList = (List) map.get("x-death");
			if (deathList == null || deathList.size() == 0) {
				count = 0;
			} else {
				count = (long) deathList.get(0).get("count");
			}
			System.out.println("=====================================");
			System.out.println("Receive" + msg + "Date:" + new Date());
			throw new IllegalArgumentException("私信队列");
		} catch (Exception e) {
			if (count < 5) {
				System.out.println("Receive 重发 " + count);
				System.out.println("Receive 重发 " + deathList);
				rabbitTemplate.send("TEST_RETRY_EXCHANGE", "TEST_RETRY_ROUTE_KEY", message);
			} else {
				throw new IllegalArgumentException("重发");
			}
		}
	}
}
