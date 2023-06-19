package com.graduateDesign.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MidtermCheckVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 选题编号
     */
    private Long selectedTopicId;

    /**
     * 中期检查日期
     */
    private LocalDateTime date;

    /**
     * 中期检查意见
     */
    private String opinion;

    /**
     * 中期检查地点
     */
    private String location;

    /**
     * 学号
     */
    private String stuNo;

    /**
     * 姓名
     */
    private String stuName;

    /**
     * 选题名称
     */
    private String topicName;

    /**
     * 进度
     */
    private Integer progress;

    /**
     * 进度描述
     */
    private String progressDesc;

    /**
     * 指导老师名称
     */
    private String teacherName;
}
