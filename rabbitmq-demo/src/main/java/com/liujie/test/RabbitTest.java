package com.liujie.test;

import com.liujie.RabbitMqApp;
import com.rabbitmq.client.AMQP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqApp.class)
public class RabbitTest {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void test1() throws InterruptedException {
        String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Topic：#.#";
        List<String> list = new ArrayList();
        list.add(msg);
        this.amqpTemplate.convertAndSend("spring.test.exchange","a.b",list);
        Thread.sleep(10000);
    }

    @Test
    public void test2() throws InterruptedException {
        String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Fanout";
        List<String> list = new ArrayList();
        list.add(msg);
        this.amqpTemplate.convertAndSend("spring.test.exchange","spring_test",list);
        Thread.sleep(10000);
    }
}
