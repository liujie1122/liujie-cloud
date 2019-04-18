package com.liujie.config.redis;//package com.liujie.config.redis;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.liujie.config.cookie.CustomerCookiesSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.session.config.annotation.web.http.SpringHttpSessionConfiguration;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
//import java.lang.reflect.Method;
//
////@Configuration
////@EnableRedisHttpSession
//public class RedisConfig {
//
//
//
//    @Value("${spring.redis.host}")
//    private String redisHost;
//    @Value("${spring.redis.port}")
//    private Integer redisPort;
//
////    @Bean
////    public RedisConnectionFactory redisCF(){
////        //如果什么参数都不设置，默认连接本地6379端口
////        JedisConnectionFactory factory = new JedisConnectionFactory();
////        factory.setHostName(redisHost);
////        factory.setPort(redisPort);
////        return factory;
////    }
//
//
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(target.getClass().getName());
//                sb.append(method.getName());
//                for (Object obj : params) {
//                    sb.append(obj.toString());
//                }
//                return sb.toString();
//            }
//        };
//    }
//
////    @SuppressWarnings("rawtypes")
////    @Bean
////    public CacheManager cacheManager(RedisCacheWriter redisTemplate) {
////        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
////        //设置缓存过期时间
////        //rcm.setDefaultExpiration(60);//秒
////        return rcm;
////    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }
//
//
////    @Bean
////    public CookieHttpSessionStrategy cookieHttpSessionStrategy() {
////        CookieHttpSessionStrategy strategy = new CookieHttpSessionStrategy();
////        strategy.setCookieSerializer(new CustomerCookiesSerializer());
////        return strategy;
////    }
//
//    @Bean
//    public SpringHttpSessionConfiguration cookieHttpSessionStrategy() {
//        SpringHttpSessionConfiguration configuration = new SpringHttpSessionConfiguration();
//        configuration.setCookieSerializer(new CustomerCookiesSerializer());
//        return configuration;
//    }
//
//}
