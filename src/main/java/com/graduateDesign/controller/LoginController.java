package com.graduateDesign.controller;

import com.graduateDesign.dao.StudentInfoMapper;
import com.graduateDesign.dao.TeacherInfoMapper;
import com.graduateDesign.entity.LoginUser;
import com.graduateDesign.entity.TeacherInfo;
import com.graduateDesign.resp.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private StudentInfoMapper studentInfoMapper;
    @Resource
    private TeacherInfoMapper teacherInfoMapper;

    @PostMapping("/login")
    public ResponseUtil<String> login(@RequestBody LoginUser loginUser) {
        log.info("登录请求信息:{}", loginUser.toString());
        int count = 0;
        if (loginUser.getRole() == 1) {
            count = studentInfoMapper.login(loginUser);
        } else if (loginUser.getRole() == 2) {
            count = teacherInfoMapper.login(loginUser);
        } else {

        }
        return count == 0 ? ResponseUtil.error("用户名或密码错误") : ResponseUtil.success("登录成功");
    }
}
