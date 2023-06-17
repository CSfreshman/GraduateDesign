package com.graduateDesign.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.graduateDesign.entity.StudentInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectedTopicVo {
    /**
     * 主键（选题信息）
     */
    private Long id;

    /**
     * 学生id
     */
    private Long stuId;

    private StudentVo studentVo;

    /**
     * 课题id
     */
    private Long topicId;

    private TopicVo topicVo;

    /**
     * 指导教师id
     */
    private Long teacherId;

    private TeacherVo teacherVo;

    /**
     * 进度
     */
    private Integer progress;

    /**
     * 进度描述
     */
    private String progressDesc;
}
