package com.graduateDesign.controller;

import com.graduateDesign.entity.LoginUser;
import com.graduateDesign.resp.ResponseUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class LoginController {

    @PostMapping("/login")
    public ResponseUtil<String> login(@RequestBody LoginUser loginUser){
        System.out.println(loginUser.toString());
        return ResponseUtil.success(loginUser.toString());
    }
}
