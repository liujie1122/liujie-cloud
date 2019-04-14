package com.liujie.rabbit;

import com.liujie.enums.MyExchange;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Producer {
    @Autowired
    private AmqpTemplate amqpTemplate;
//    private RabbitTemplate rabbitTemplate;
    public void production() {
        String msg = "我在尝试用Spring整合RabbitMq发送消息";
        List<String> list = new ArrayList();
        list.add(msg);
        //制定交换机和路由规则
//        this.rabbitTemplate.convertAndSend("liujie.user","",msg);

//        this.amqpTemplate.convertAndSend("exchange.liujie.user","",msg);
        this.amqpTemplate.convertAndSend(MyExchange.EXCHANGE_LIUJIE_USER,"",msg);
//        Thread.sleep(10000);
    }
}
