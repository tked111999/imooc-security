package com.imooc.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        httpServletRequest.setAttribute("startTime", new Date().getTime());
        System.out.println("拦截器 preHandle");
        // 拦截的类名和方法名
        System.out.println("类名：" + ((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println("方法名：" + ((HandlerMethod) handler).getMethod().getName());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("执行时间：" + (new Date().getTime() - (Long) httpServletRequest.getAttribute("startTime")));
        System.out.println("拦截器 postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("拦截器 afterCompletion");
    }
}
