package com.graduateDesign.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class StudentVo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 登录密码
     * 默认值为：123456
     */
    private String password;

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

    /**
     * 选题编号
     */
    private Long selectedTopicId;

    /**
     * 选题名称
     */
    private String topicName;

    /**
     * 题目类型类型
     */
    private String topicTypeDesc;

    /**
     * 指导老师名称
     */
    private String teacherName;

    /**
     * 选题类型id
     */
    private Integer topicType;

    /**
     * 选题进度描述
     */
    private String progressDesc;

    /**
     * 选题进度
     */
    private Integer progress;
}

