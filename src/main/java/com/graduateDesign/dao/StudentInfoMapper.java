package com.graduateDesign.dao;

import com.graduateDesign.entity.StudentInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduateDesign.excel.StudentExcelEntity;
import com.graduateDesign.vo.StudentVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 学生信息表 Mapper 接口
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Mapper
public interface StudentInfoMapper extends BaseMapper<StudentInfo> {

    @Select("select stu.id,stu.stu_name,stu.stu_no,stu.password,stu.major,major.name from student_info stu left join major on stu.major = major.id;")
    List<StudentVo> getAllStudent();

    List<StudentInfo> getAllStudent1();

    @Select("select * from student_info where stu_no = '2020218000'")
    StudentInfo test();
}
