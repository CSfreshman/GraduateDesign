package com.graduateDesign.config;

import com.graduateDesign.interceptor.StudentAuthInterceptor;
import com.graduateDesign.interceptor.TeacherAuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private StudentAuthInterceptor studentAuthInterceptor;
    @Resource
    private TeacherAuthInterceptor teacherAuthInterceptor;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有接口
                .allowCredentials(true) // 是否发送 Cookie
                .allowedOriginPatterns("*") // 支持域
                .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"}) // 支持方法
                .allowedHeaders("*")
                .exposedHeaders("*");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(studentAuthInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/admin/login"
                );

        registry.addInterceptor(teacherAuthInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/admin/login",             // 登录
                        "/studentInfo/getInfo/**",  // 个人信息
                        "/teacherInfo/getAll",     // 老师列表
                        "topicInfo/getTeacherCanSelect", // 查询可以选择的老师
                        "/topicInfo/getAll",        // 选题列表
                        "/selectedTopic/add"        // 选题
                );
    }


}
