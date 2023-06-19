package com.graduateDesign.req;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SelectedTopicReq {
    /**
     * 选题编号
     */
    private Long id;
    /**
     * 课题id
     */
    private Long topicId;

    /**
     * 指导教师工号
     */
    private String teacherNo;

    /**
     * 指导教师id
     */
    private Long teacherId;

    /**
     * 学生学号
     */
    private String stuNo;

    /**
     * 原来的进度
     */
    private Integer originalProgress;

    /**
     * 更新为什么进度
     */
    private Integer progress;

    /**
     * 中期检查时间
     */
    private LocalDateTime midCheckDate;

    /**
     * 中期检查地点
     */
    private String midCheckLocation;

    /**
     * 中期检查意见
     */
    private String midCheckOpinion;

    /**
     * 答辩时间
     */
    private LocalDateTime defenseDate;

    /**
     * 答辩地点
     */
    private String defenseLocation;

    /**
     * 答辩记录
     */
    private String defenseRecord;

    /**
     * 指导教师成绩
     */
    private Double advisorScore;


    /**
     * 评阅教师成绩
     */
    private Double reviewerScore;

    /**
     * 答辩小组成绩
     */
    private Double committeeScore;

    /**
     * 最终成绩
     */
    private Double finalScore;
}
