package com.liujie.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
        //定义一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置ip
        factory.setHost("192.168.60.110");
        //设置端口  http://192.168.60.110:15672/
        factory.setPort(5672);
        //设置连接账户信息
        factory.setVirtualHost("/");
        factory.setUsername("root");
        factory.setPassword("root");
        //获取一个连接
        Connection connection = factory.newConnection();
        return connection;

    }
}
