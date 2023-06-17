package com.graduateDesign.excel;

import lombok.Data;

@Data
public class TeacherExcel {

    /**
     * 工号
     */
    private String teacherNo;

    /**
     * 姓名
     */
    private String teacherName;

    /**
     * 指导课题类型
     */
    private String typeDesc;

    /**
     * 指导学生余额
     */
    private String stock;

}
