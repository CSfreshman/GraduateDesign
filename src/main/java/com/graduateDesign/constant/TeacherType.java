package com.graduateDesign.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeacherType {
    WEB(1,"web"),
    OS(2,"操作系统"),
    DEEPLEARN(3,"深度学习"),
    ALGORITHM(4,"算法"),
    NETWORK(5,"网络相关"),
    EMBEDDED(6,"嵌入式系统")
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

    public static TeacherType getTeacherType(String value) {
        for (TeacherType teacherType : values()) {
            if (teacherType.getValue().equals(value)) {
                return teacherType;
            }
        }
        return null;
    }
}
