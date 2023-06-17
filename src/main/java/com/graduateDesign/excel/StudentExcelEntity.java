package com.graduateDesign.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class StudentExcelEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty(index = 0)
    private String stuNo;

    @ExcelProperty(index = 1)
    private String stuName;

    @ExcelProperty(index = 2)
    private String majorDesc;

    private Integer major;
}
