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
 * 成绩表
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("score")
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 选题id
     */
    @TableField("selected_topic_id")
    private Long selectedTopicId;

    /**
     * 指导教师
     */
    @TableField("advisor_score")
    private Double advisorScore;

    /**
     * 评阅教师成绩
     */
    @TableField("reviewer_score")
    private Double reviewerScore;

    /**
     * 答辩小组成绩
     */
    @TableField("committee_score")
    private Double committeeScore;

    /**
     * 最终成绩
     */
    @TableField("final_score")
    private Double finalScore;


}
