package com.graduateDesign.aop;

import com.graduateDesign.resp.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {
    // 定义切点
    @Pointcut("@annotation(com.graduateDesign.annotion.Log)")
    public void log() {}

    // 前置通知
    // 执行前置通知：记录请求内容
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录请求内容
        log.info("==========    URL : " + request.getRequestURL().toString());
        log.info("==========    HTTP_METHOD : " + request.getMethod());
        log.info("==========    IP : " + request.getRemoteAddr());
        log.info("==========    CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("==========    ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    // 后置通知
    // 执行后置通知：记录响应内容
    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Object result) throws Exception {
        result = (ResponseUtil) result;
        // 记录响应内容
        log.info("==========    RESPONSE : " + ((ResponseUtil<?>) result).getData().toString());
    }
}
