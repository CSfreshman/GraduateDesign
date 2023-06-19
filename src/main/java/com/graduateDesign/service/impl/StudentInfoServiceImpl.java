package com.graduateDesign.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduateDesign.constant.MajorEnum;
import com.graduateDesign.constant.ProgressConstant;
import com.graduateDesign.constant.TeacherType;
import com.graduateDesign.controller.TeacherInfoController;
import com.graduateDesign.entity.StudentInfo;
import com.graduateDesign.dao.StudentInfoMapper;
import com.graduateDesign.excel.StudentExcelEntity;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.StudentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduateDesign.util.StudentDataListener;
import com.graduateDesign.util.TestUtil;
import com.graduateDesign.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Service
@Slf4j
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo> implements StudentInfoService {

    @Resource
    private StudentInfoMapper mapper;
    @Value("${studentExcelFileName}")
    private String studentExcelFileName;

    @Override
    public ResponseUtil<IPage<StudentInfo>> getStudents(PageReq pageReq) {
        Page<StudentInfo> page = new Page<>(pageReq.getCurPage(), pageReq.getPageSize());
        IPage<StudentInfo> studentInfoIPage = mapper.selectPage(page,new QueryWrapper<>());
        return ResponseUtil.success(studentInfoIPage);
    }

    @Override
    public ResponseUtil<String> addStudentInfo(StudentInfo studentInfo) {
        boolean save = save(studentInfo);
        if(save){
            return ResponseUtil.success("保存成功");
        }
        return ResponseUtil.error("保存失败");
    }

    @Override
    public ResponseUtil<String> deleteStudentInfo(StudentInfo studentInfo) {
        boolean b = removeById(studentInfo);
        if(b){
            return ResponseUtil.success("删除成功");
        }
        return ResponseUtil.error("删除失败");
    }

    @Override
    public ResponseUtil<String> updateStudentInfo(StudentInfo studentInfo) {
        boolean b = updateById(studentInfo);
        if(b){
            return ResponseUtil.success("修改成功");
        }
        return ResponseUtil.error("修改失败");
    }

    @Override
    public ResponseUtil<List<StudentVo>> getAllStudent() {
        List<StudentVo> list = mapper.getAllStudent();
        for (StudentVo vo : list) {
            vo.setMajorName(Objects.requireNonNull(MajorEnum.getMajorEnum(vo.getMajor())).getValue());
        }
        return ResponseUtil.success(list);
    }

    @Override
    public ResponseUtil<StudentVo> getOneStudentByNo(StudentInfo req) {
        QueryWrapper<StudentInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("stu_no",req.getStuNo());
        StudentInfo studentInfo = mapper.selectOne(wrapper);

        StudentVo vo = new StudentVo();
        BeanUtil.copyProperties(studentInfo,vo);
        vo.setMajorName(Objects.requireNonNull(MajorEnum.getMajorEnum(vo.getMajor())).getValue());
        return ResponseUtil.success(vo);
    }

    @Override
    public ResponseUtil<StudentVo> getOneStudentById(StudentInfo req) {
        QueryWrapper<StudentInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("id",req.getId());
        StudentInfo studentInfo = mapper.selectOne(wrapper);

        StudentVo vo = new StudentVo();
        BeanUtil.copyProperties(studentInfo,vo);
        vo.setMajorName(Objects.requireNonNull(MajorEnum.getMajorEnum(vo.getMajor())).getValue());
        return ResponseUtil.success(vo);
    }

    // 通过学号获得学生信息
    @Override
    public StudentInfo getStudentInfoByNo(String stuNo){
        QueryWrapper<StudentInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("stu_no",stuNo);
        return mapper.selectOne(wrapper);
    }

    @Override
    public ResponseUtil<String> readExcel() {
        String fileName = studentExcelFileName;
        try{
            EasyExcel.read(fileName, StudentExcelEntity.class,new StudentDataListener(mapper)).sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
            log.info("出错了:{}",e.getMessage());
        }
        return ResponseUtil.success("成功");
    }

    @Override
    public ResponseUtil<String> test() {
        return ResponseUtil.success(mapper.getAllStudent1().toString());
    }

    @Override
    public ResponseUtil<StudentVo> getInfo(String stuNo) {
        StudentVo vo = mapper.getInfo(stuNo);
        if(vo.getTopicType() != null){
            vo.setTopicTypeDesc(TeacherType.getTeacherType(vo.getTopicType()).getValue());
        }
        if(vo.getProgress() != null){
            vo.setProgressDesc(ProgressConstant.getEnum(vo.getProgress()).getValue());
        }

        return ResponseUtil.success(vo);
    }


}
