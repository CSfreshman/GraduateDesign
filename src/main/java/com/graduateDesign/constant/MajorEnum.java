package com.graduateDesign.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MajorEnum {
    COMPUTER_SCIENCE_AND_TECHNOLOGY(100001,"计算机科学与技术"),
    SOFTWARE_ENGINEERING(100002,"软件工程"),
    ELECTRONIC_INFORMATION_SCIENCE_AND_TECHNOLOGY(100003,"电子信息科学与技术"),
    INTERNET_OF_THINGS_ENGINEERING(100004,"物联网工程");
    private final Integer key;
    private final String value;

    public static MajorEnum getMajorEnum(Integer key){
        for (MajorEnum item : values()){
            if(item.key.equals(key)){
                return item;
            }
        }
        return null;
    }

}
