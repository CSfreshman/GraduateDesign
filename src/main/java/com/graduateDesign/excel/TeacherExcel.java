package com.graduateDesign.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class TeacherExcel {

    /**
     * 工号
     */
    @ExcelProperty(index = 0)
    private String teacherNo;

    /**
     * 姓名
     */
    @ExcelProperty(index = 1)
    private String teacherName;

    /**
     * 指导课题类型
     */
    @ExcelProperty(index = 2)
    private String typeDesc;

    /**
     * 指导课题类型id
     */
    private Integer type;

    /**
     * 指导学生余额
     */
    @ExcelProperty(index = 3)
    private Integer stock;

}
