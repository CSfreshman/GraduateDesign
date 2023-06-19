package com.graduateDesign.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 答辩表
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("defense")
public class Defense implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 选题编号
     */
    @TableField("selected_topic_id")
    private Long selectedTopicId;

    /**
     * 答辩日期
     */
    @TableField("date")
    private LocalDateTime date;

    /**
     * 答辩地点
     */
    @TableField("location")
    private String location;

    /**
     * 答辩记录
     */
    @TableField("record")
    private String record;


}
