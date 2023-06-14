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
 * 中期检查表
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("midterm_check")
public class MidtermCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 选题编号
     */
    @TableField("select_topic_id")
    private Long selectTopicId;

    /**
     * 中期检查日期
     */
    @TableField("date")
    private LocalDateTime date;

    /**
     * 中期检查意见
     */
    @TableField("opinion")
    private String opinion;

    /**
     * 中期检查地点
     */
    @TableField("location")
    private String location;

}
