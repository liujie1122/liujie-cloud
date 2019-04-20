package com.zjty.threem.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class GetResourceUtils {

    
    /**
     * 获取用户头像地址前缀
     * USER_IMAGE_URL
     * @return
     */
    public static String getUserImageUrl(){
    	Properties prop = new Properties(); 
    	InputStream in = GetResourceUtils.class.getClassLoader().getResourceAsStream("properties/url.properties");
    	try {  
	    	prop.load(in); 
	        String USER_IMAGE_URL = prop.getProperty("USER_IMAGE_URL").trim();
	        in.close();
            return USER_IMAGE_URL; 
        } catch (IOException e) {   
            e.printStackTrace();   
            try {
                in.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null; 
        }
    }
    
    /**
     * 获取三员管理系统用户类型
     * @return
     */
    public static Integer getUserType(){
    	Properties prop = new Properties(); 
    	InputStream in = GetResourceUtils.class.getClassLoader().getResourceAsStream("properties/userProperties.properties");
    	try {
    		prop.load(in); 
    		Integer User_Type = Integer.valueOf(prop.getProperty("User_Type").trim());
            return User_Type; 
        } catch (IOException e) {   
            e.printStackTrace();   
            try {
                in.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null; 
        }
    }
    
    /**
     * 获取三员管理系统用户密码过期时间
     * @return
     */
    public static Integer getPasswordOutTime(){
    	Properties prop = new Properties(); 
    	InputStream in = GetResourceUtils.class.getClassLoader().getResourceAsStream("properties/userProperties.properties");
    	try {
    		prop.load(in);
    		Integer Password_OutTime = Integer.valueOf(prop.getProperty("Password_OutTime").trim());
            return Password_OutTime; 
        } catch (IOException e) {   
            e.printStackTrace();   
            try {
                in.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null; 
        }
    }
    
    /**
     * 获取三员管理系统用户初始化状态
     * @return
     */
    public static Integer getStation(){
    	Properties prop = new Properties(); 
    	InputStream in = GetResourceUtils.class.getClassLoader().getResourceAsStream("properties/userProperties.properties");
    	try {
    		prop.load(in); 
    		Integer Station = Integer.valueOf(prop.getProperty("Station").trim());
            return Station; 
        } catch (IOException e) {   
            e.printStackTrace();   
            try {
                in.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null; 
        }
    }
    
    /**
     * 获取三员管理系统用户初始化状态
     * @return
     */
    public static Integer getIsNewUser(){
    	Properties prop = new Properties(); 
    	InputStream in = GetResourceUtils.class.getClassLoader().getResourceAsStream("properties/userProperties.properties");
    	try {
    		prop.load(in); 
    		Integer Is_New_User = Integer.valueOf(prop.getProperty("Is_New_User").trim());
            return Is_New_User; 
        } catch (IOException e) {   
            e.printStackTrace();   
            try {
                in.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null; 
        }
    }
    
    /**
     * 获取人员管理ip地址url
     * @return
     */
    public static String getHRManagerBrowerUrl(){
    	Properties prop = new Properties(); 
    	InputStream in = GetResourceUtils.class.getClassLoader().getResourceAsStream("properties/url.properties");
    	try {   
            prop.load(in); 
            String HRMANAGER_BROWER_URL = prop.getProperty("HRMANAGER_BROWER_URL").trim();
            in.close();
            return HRMANAGER_BROWER_URL; 
        } catch (IOException e) {   
            e.printStackTrace();   
            try {
                in.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null; 
        }
    }
    
    /**
     * 获取Redis服务主机地址
     * @return
     */
    public static String getRedisHost(){
    	Properties prop = new Properties(); 
    	InputStream in = GetResourceUtils.class.getClassLoader().getResourceAsStream("properties/redis.properties");
    	try {
    		prop.load(in);
    		String redisHost = prop.getProperty("redis.host").trim();
            return redisHost; 
        } catch (IOException e) {   
            e.printStackTrace();   
            try {
                in.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null; 
        }
    }
    /**
     * 获取Redis服务主机端口号
     * @return
     */
    public static Integer getRedisPort(){
    	Properties prop = new Properties(); 
    	InputStream in = GetResourceUtils.class.getClassLoader().getResourceAsStream("properties/redis.properties");
    	try {
    		prop.load(in);
    		Integer redisPort = Integer.valueOf(prop.getProperty("redis.port").trim());
            return redisPort; 
        } catch (IOException e) {   
            e.printStackTrace();   
            try {
                in.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null; 
        }
    }
    
    
    /**
     * 获取Redis服务主机端口号
     * @return
     */
    public static String getNetworkStatus(){
    	Properties prop = new Properties(); 
    	///WEB-INF/classes/com/vivian/demo/servletContext/dbconn_resources.properties";
    	//WEB-INF/classescom/taiyuan/threemember/utils/properties.properties
    	InputStream in = GetResourceUtils.class.getClassLoader().getResourceAsStream("com/taiyuan/threemember/properties.properties");
    	try {
    		System.out.println(in);
    		prop.load(in);
    		String redisPort = prop.getProperty("networkStatus").trim();
            return redisPort; 
        } catch (IOException e) {   
            e.printStackTrace();   
            try {
                in.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return null; 
        }
    }
}


