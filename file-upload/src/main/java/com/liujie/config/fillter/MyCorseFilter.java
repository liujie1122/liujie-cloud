package com.liujie.config.fillter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  设置response用来解决前后端跨域问题
 */
//@Configuration
@Order(value = 1)
@Component
public class MyCorseFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MyCorseFilter.class);

    /**
     * Servlet过滤器，这里用来处理跨域请求HEADER问题
     *
     * @param req
     * @param res
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        // 记录发送过来的request情况
        logger.info("RequestURI = {}", request.getRequestURI());
        logger.info("contentType = {}", request.getContentType());
        request.getParameterMap().forEach((key, value) -> logger.info("Map -> key = {} , value = {}", key, value));
        // 设置响应头的权限信息 request.getHeader("Origin")
        String origin = request.getHeader("Origin");
        if (StringUtils.isEmpty(origin)){
            response.setHeader("Access-Control-Allow-Origin", "*");
        }else {
            response.setHeader("Access-Control-Allow-Origin", origin);
        }
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //允许的请求方式
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, PATCH, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        //允许的请求头信息
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void destroy() {}
}

