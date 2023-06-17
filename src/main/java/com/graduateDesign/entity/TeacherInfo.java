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
 * 教师信息表
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("teacher_info")
public class TeacherInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 老师姓名
     */
    @TableField("teacher_name")
    private String teacherName;

    /**
     * 老师工号
     */
    @TableField("teacher_no")
    private String teacherNo;

    /**
     * 登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 课题类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 剩余可指导学生的数量
     */
    @TableField("stock")
    private Integer stock;


}
