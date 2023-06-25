package com.graduateDesign.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.relational.core.sql.In;

@Getter
@AllArgsConstructor
public enum AuthEnum {
    STUDENT(1,"学生"),
    TEACHER(2,"老师"),
    ADMIN(3,"管理员");
    private Integer key;
    private String value;
}
