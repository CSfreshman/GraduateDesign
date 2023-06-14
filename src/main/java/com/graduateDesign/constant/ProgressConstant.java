package com.graduateDesign.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProgressConstant {

    WAITING_FOR_TEACHER_CONFIRM(11,"新选题目，等待老师确认"),
    WAITING_FOR_OPENING(12,"等待开题报告"),
    WAITING_FOR_MIDCHECK(13,"等待中期检查"),
    WAITING_FOR_DEFENSE(14,"等待答辩"),
    FINISH(15,"完成");

    private final Integer key;
    private final String value;

    public static ProgressConstant getEnum(Integer key){
        for (ProgressConstant item : values()){
            if(item.key.equals(key)){
                return item;
            }
        }
        return null;
    }

}
