package com.graduateDesign.vo;

import lombok.Data;

@Data
public class ScoreVo {
    /**
     * 成绩编号
     */
    private Long id;

    /**
     * 学号
     */
    private String stuNo;

    /**
     * 姓名
     */
    private String stuName;

    /**
     * 课题名称
     */
    private String topicName;

    /**
     * 课题类型/老师指导类型
     */
    private String topicType;

    /**
     * 指导老师名称
     */
    private String teacherName;

    /**
     * 指导老师成绩
     */
    private Double advisorScore;

    /**
     * 评阅老师成绩
     */
    private Double reviewerScore;

    /**
     * 答辩成绩
     */
    private Double committeeScore;

    /**
     * 最终成绩
     */
    private Double finalScore;
}
