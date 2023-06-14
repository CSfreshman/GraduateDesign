package com.graduateDesign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 选题信息表
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("selected_topic")
public class SelectedTopic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（选题信息）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学生id
     */
    @TableField("stu_id")
    private Long stuId;

    /**
     * 课题id
     */
    @TableField("topic_id")
    private Long topicId;

    /**
     * 指导教师id
     */
    @TableField("teacher_id")
    private Long teacherId;

    /**
     * 进度
     */
    @TableField("progress")
    private Integer progress;


}
