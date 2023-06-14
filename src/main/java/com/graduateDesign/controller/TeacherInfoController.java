package com.graduateDesign.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.StudentInfo;
import com.graduateDesign.entity.TeacherInfo;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.StudentInfoService;
import com.graduateDesign.service.TeacherInfoService;
import com.graduateDesign.vo.TeacherVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 教师信息表 前端控制器
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@RestController
@RequestMapping("/teacherInfo")
public class TeacherInfoController {
    @Resource
    private TeacherInfoService teacherInfoService;

    @PostMapping("/getPage")
    public ResponseUtil<IPage<TeacherVo>> getTeachers(@RequestBody PageReq pageReq){
        return teacherInfoService.getTeachers(pageReq);
    }

    @PostMapping("/getOne")
    public ResponseUtil<TeacherVo> getOne(@RequestBody TeacherInfo teacherInfo){
        return teacherInfoService.getOne(teacherInfo);
    }

    @GetMapping("/getAll")
    public ResponseUtil<List<TeacherVo>> getAll(){
        return teacherInfoService.getAll();
    }

    @PostMapping("/add")
    public ResponseUtil<String> addTeacherInfo(@RequestBody TeacherInfo teacherInfo){
        return teacherInfoService.addTeacherInfo(teacherInfo);
    }

    @PostMapping("/delete")
    public ResponseUtil<String> deleteTeacherInfo(@RequestBody TeacherInfo teacherInfo){
        return teacherInfoService.deleteTeacherInfo(teacherInfo);
    }

    @PostMapping("/update")
    public ResponseUtil<String> updateTeacherInfo(@RequestBody TeacherInfo teacherInfo){
        return teacherInfoService.updateTeacherInfo(teacherInfo);
    }
}
