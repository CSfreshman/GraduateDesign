package com.graduateDesign.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DefenseVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 选题编号
     */
    private Long selectedTopicId;

    /**
     * 答辩日期
     */
    private LocalDateTime date;

    /**
     * 答辩意见
     */
    private String record;

    /**
     * 答辩地点
     */
    private String location;

    /**
     * 学号
     */
    private String stuNo;

    /**
     * 姓名
     */
    private String stuName;

    /**
     * 选题名称
     */
    private String topicName;

    /**
     * 进度
     */
    private Integer progress;

    /**
     * 进度描述
     */
    private String progressDesc;

    /**
     * 指导老师名称
     */
    private String teacherName;
}
