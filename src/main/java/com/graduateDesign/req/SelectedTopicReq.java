package com.graduateDesign.req;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class SelectedTopicReq {
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
     * 进度
     */
    private Integer progress;
}
