package com.graduateDesign.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.StudentInfo;
import com.graduateDesign.entity.TeacherInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.vo.TeacherVo;

import java.util.List;

/**
 * <p>
 * 教师信息表 服务类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
public interface TeacherInfoService extends IService<TeacherInfo> {

    ResponseUtil<String> updateTeacherInfo(TeacherInfo teacherInfo);

    ResponseUtil<String> deleteTeacherInfo(TeacherInfo teacherInfo);

    ResponseUtil<String> addTeacherInfo(TeacherInfo teacherInfo);

    ResponseUtil<IPage<TeacherVo>> getTeachers(PageReq pageReq);

    ResponseUtil<TeacherVo> getOne(TeacherInfo teacherInfo);

    ResponseUtil<List<TeacherVo>> getAll();
}
