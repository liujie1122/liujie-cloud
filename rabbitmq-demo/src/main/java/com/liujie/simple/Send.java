package com.liujie.simple;

import com.liujie.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  消息的发送者
 */
public class Send {
    private final static String QUEUE_NAME = "simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        //通过连接工具类获取一个连接
        Connection connection = ConnectionUtil.getConnection();
        //从连接中创建一个通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message = "Hello World";
        //向指定的队列中发送消息
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("[x] Send '" + message + "’" );
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
