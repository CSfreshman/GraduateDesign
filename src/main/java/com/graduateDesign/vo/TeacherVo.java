package com.graduateDesign.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TeacherVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 老师姓名
     */
    private String teacherName;

    /**
     * 老师工号
     */
    private String teacherNo;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 课题类型
     */
    private Integer type;

    /**
     * 课题类型描述
     */
    private String typeDesc;

    /**
     * 选题剩余
     */
    private Integer stock;
}
