package com.graduateDesign.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.graduateDesign.entity.StudentInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SelectedTopicVo {
    /**
     * 主键（选题信息）
     */
    private Long id;

    /**
     * 学生id
     */
    private Long stuId;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 学号
     */
    private String stuNo;

    /**
     * 专业
     */
    private Integer major;

    /**
     * 专业名称
     */
    private String majorName;

    private StudentVo studentVo;

    /**
     * 课题id
     */
    private Long topicId;

    /**
     * 选题名称
     */
    private String topicName;

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
