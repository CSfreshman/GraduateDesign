package com.graduateDesign.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeacherType {
    WEB(1,"web"),
    OS(2,"操作系统"),
    DEEPLEARN(3,"深度学习"),
    ALGORITHM(4,"算法")
    ;

    public final Integer key;
    public final String value;

    public static TeacherType getTeacherType(Integer key) {
        for (TeacherType teacherType : values()) {
            if (teacherType.getKey().intValue() == key.intValue()) {
                return teacherType;
            }
        }
        return null;
    }
}
