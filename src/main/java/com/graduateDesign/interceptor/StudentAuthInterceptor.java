package com.graduateDesign.interceptor;

import com.graduateDesign.annotion.Log;
import com.graduateDesign.constant.AuthEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
@Slf4j
public class StudentAuthInterceptor implements HandlerInterceptor {


    // 添加前置处理，获得请求头的中权限信息
    @Log
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if("OPTIONS".equals(request.getMethod())){
            return true;
        }

        Integer authorization = Integer.valueOf(request.getHeader("authorization"));

        log.info("==== student拦截器 ==== 当前用户的角色信息为:{}",authorization);

        // 权限为空，直接拦截
        if(authorization == null || authorization == 0){
            log.info("==== student拦截器 ==== 用户无权访问接口");
            return false;
        }
        // 如果权限小于学生，拦截
        if(authorization < AuthEnum.STUDENT.getKey()){
            log.info("==== student拦截器 ==== 用户无权访问接口");
            return false;
        }
        log.info("==== student拦截器 ==== 用户验证通过");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
