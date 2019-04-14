package com.liujie.rabbit;

import com.liujie.enums.MyExchange;
import com.liujie.enums.MyQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {
    private final Logger logger = LoggerFactory.getLogger(ConsumerListener.class);
//    private final String QUEUE_LIUJIE_USER = MyQueue.QUEUE_LIUJIE_USER;

//    @RabbitListener(bindings = @QueueBinding(    //@QueueBinding:队列的绑定关系
//            value = @Queue(value = "spring.test.queue",durable = "true"),//声明队列名称，并且指定了序列化
//            exchange = @Exchange(//声明交换机类型和名称
//                    value = "spring.test.exchange",
//                    type = ExchangeTypes.TOPIC
//            ),
//            key = {"#.#"}))//监听的路由：全部都监听
//    public void listen1(String msg){
//        System.out.println(msg);
//    }
//
//    @RabbitListener(bindings = @QueueBinding(    //@QueueBinding:队列的绑定关系
//            value = @Queue(value = "spring.test.queue",durable = "true"),//声明队列名称，并且指定了序列化
//            exchange = @Exchange(//声明交换机类型和名称
//                    value = "spring.test.exchange",
//                    type = ExchangeTypes.TOPIC
//            ),
//            key = {"#.#"}))//监听的路由：全部都监听
//    public void listen3(String msg){
//        System.out.println(msg);
//    }


    @RabbitListener(bindings = @QueueBinding(    //@QueueBinding:队列的绑定关系
//            value = @Queue(value = "queue.liujie.user",durable = "true"),//声明队列名称，并且指定了序列化
            value = @Queue(value = MyQueue.QUEUE_LIUJIE_USER,durable = "true"),//声明队列名称，并且指定了序列化
            exchange = @Exchange(//声明交换机类型和名称
//                    value = "exchange.liujie.user",
                    value = MyExchange.EXCHANGE_LIUJIE_USER,
                    type = ExchangeTypes.FANOUT
            ),
            key = {""}))//监听的路由：全部都监听
    public void listen2(String msg){
        logger.info("我是消费者，我收到一条新的消息:"+msg);
    }
}
