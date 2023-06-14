package com.graduateDesign.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.graduateDesign.entity.TeacherInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TopicVo {

    /**
     * 主键（课题信息）
     */
    private Long id;

    /**
     * 课题描述
     */
    private String topicDesc;

    /**
     * 课题名字
     */
    private String topicName;

    /**
     * 选题类型
     */
    private Integer type;

    /**
     * 选题剩余
     */
    private Integer stock;

    /**
     * 选题类型描述
     */
    private String typeDesc;

    /**
     * 该选题可选的教师列表
     */
    private List<TeacherInfo> teacherInfoList;
}

