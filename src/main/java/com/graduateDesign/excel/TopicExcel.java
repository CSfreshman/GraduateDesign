package com.graduateDesign.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class TopicExcel {

    /**
     * 名字
     */
    @ExcelProperty(index = 0)
    private String topicName;

    /**
     * 描述
     */
    @ExcelProperty(index = 1)
    private String topicDesc;

    /**
     * 类型
     */
    @ExcelProperty(index = 2)
    private String typeDesc;

    /**
     * 剩余
     */
    @ExcelProperty(index = 3)
    private Integer stock;

    /**
     * 类型
     */
    private Integer type;
}
