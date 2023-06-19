package com.graduateDesign.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginUser {
    // 用户名
    private String username;
    // 密码
    private String password;
    // 角色
    private Integer role;
}
