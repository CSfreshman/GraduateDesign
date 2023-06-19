package com.graduateDesign.dao;

import com.graduateDesign.entity.LoginUser;
import com.graduateDesign.entity.TeacherInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduateDesign.vo.TeacherVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 教师信息表 Mapper 接口
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Mapper
public interface TeacherInfoMapper extends BaseMapper<TeacherInfo> {

    Integer login(@Param("loginUser") LoginUser loginUser);

    TeacherVo getInfo(@Param("teacherNo") String teacherNo);
}
