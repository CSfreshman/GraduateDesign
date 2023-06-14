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
 * 课题信息表
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("topic_info")
public class TopicInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（课题信息）
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课题描述
     */
    @TableField("topic_desc")
    private String topicDesc;

    /**
     * 课题名字
     */
    @TableField("topic_name")
    private String topicName;

    /**
     * 选题类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 选题剩余
     */
    @TableField("stock")
    private Integer stock;


}
