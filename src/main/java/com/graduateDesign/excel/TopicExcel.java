package com.graduateDesign.excel;

import lombok.Data;

@Data
public class TopicExcel {

    /**
     * 名字
     */
    private String topicName;

    /**
     * 描述
     */
    private String topicDesc;

    /**
     * 类型
     */
    private String typeDesc;

    /**
     * 剩余
     */
    private Integer stock;
}
