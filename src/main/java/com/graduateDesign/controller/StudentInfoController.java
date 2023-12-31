package com.graduateDesign.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.annotion.Log;
import com.graduateDesign.entity.StudentInfo;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.StudentInfoService;
import com.graduateDesign.vo.StudentVo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 学生信息表 前端控制器
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {
    @Resource
    private StudentInfoService studentInfoService;

    @GetMapping("/getAll")
    public ResponseUtil<List<StudentVo>> getAllStudent(){
        return studentInfoService.getAllStudent();
    }


    @PostMapping("/getPage")
    public ResponseUtil<IPage<StudentInfo>> getStudents(@RequestBody PageReq pageReq){
        return studentInfoService.getStudents(pageReq);
    }

    @PostMapping("/getOne")
    public ResponseUtil<StudentVo> getOneStudent(@RequestBody StudentInfo req){
        return studentInfoService.getOneStudentByNo(req);
    }

    @PostMapping("/add")
    public ResponseUtil<String> addStudentInfo(@RequestBody StudentInfo studentInfo){
        return studentInfoService.addStudentInfo(studentInfo);
    }

    @PostMapping("/delete")
    public ResponseUtil<String> deleteStudentInfo(@RequestBody StudentInfo studentInfo){
        return studentInfoService.deleteStudentInfo(studentInfo);
    }

    @PostMapping("/update")
    public ResponseUtil<String> updateStudentInfo(@RequestBody StudentInfo studentInfo){
        return studentInfoService.updateStudentInfo(studentInfo);
    }

    @PostMapping("/readExcel")
    public ResponseUtil<String> readExcel(){
        return studentInfoService.readExcel();
    }

    @Log
    @GetMapping("/getInfo/{stuNo}")
    public ResponseUtil<StudentVo> getInfo(@PathVariable("stuNo") String stuNo){
        return studentInfoService.getInfo(stuNo);
    }


    @Log
    @PostMapping("/test")
    public ResponseUtil<String> test(){
        return studentInfoService.test();
    }
}
