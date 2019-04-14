package com.liujie.topic;

import com.liujie.utils.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    private final static String EXCHANGE_NAME = "topic_exchange_test";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //通过连接工具类获取一个连接
        Connection connection = ConnectionUtil.getConnection();
        //从连接中创建一个通道
        Channel channel = connection.createChannel();
        //声明一个交换类型
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        // 消息内容
        String message = "删除了一个商品";
        // 发布消息到Exchange
        channel.basicPublish(EXCHANGE_NAME,"item.ins",null,message.getBytes());
        System.out.println(" [商品服务] Sent '" + message + "'");

        //关闭通道和连接
        channel.close();
        connection.close();
    }

}
