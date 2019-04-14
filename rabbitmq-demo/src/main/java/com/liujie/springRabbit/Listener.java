package com.liujie.springRabbit;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @RabbitListener(bindings = @QueueBinding(    //@QueueBinding:队列的绑定关系
            value = @Queue(value = "spring.test.queue",durable = "true"),//声明队列名称，并且指定了序列化
            exchange = @Exchange(//声明交换机类型和名称
                    value = "spring.test.exchange",
                    type = ExchangeTypes.TOPIC
            ),
            key = {"#.#"}))//监听的路由：全部都监听
    public void listen1(String msg){
        System.out.println(msg);
    }


    @RabbitListener(bindings = @QueueBinding(    //@QueueBinding:队列的绑定关系
            value = @Queue(value = "spring.test.queue",durable = "true"),//声明队列名称，并且指定了序列化
            exchange = @Exchange(//声明交换机类型和名称
                    value = "spring.test.exchange",
                    type = ExchangeTypes.FANOUT
            ),
            key = {"spring_test"}))//监听的路由：全部都监听
    public void listen2(String msg){
        System.out.println(msg);
    }
}
