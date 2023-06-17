package com.graduateDesign.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.StudentInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.vo.StudentVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 学生信息表 服务类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
public interface StudentInfoService extends IService<StudentInfo> {

    ResponseUtil<IPage<StudentInfo>> getStudents(PageReq pageReq);

    ResponseUtil<String> addStudentInfo(StudentInfo studentInfo);

    ResponseUtil<String> deleteStudentInfo(StudentInfo studentInfo);

    ResponseUtil<String> updateStudentInfo(StudentInfo studentInfo);

    ResponseUtil<List<StudentVo>> getAllStudent();

    ResponseUtil<StudentVo> getOneStudent(StudentInfo req);

    StudentInfo getStudentInfoByNo(String stuNo);

    ResponseUtil<String> readExcel();
}
