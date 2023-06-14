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
}
