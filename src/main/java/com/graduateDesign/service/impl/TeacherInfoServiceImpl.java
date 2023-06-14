package com.graduateDesign.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduateDesign.constant.TeacherType;
import com.graduateDesign.dao.StudentInfoMapper;
import com.graduateDesign.entity.StudentInfo;
import com.graduateDesign.entity.TeacherInfo;
import com.graduateDesign.dao.TeacherInfoMapper;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.TeacherInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduateDesign.vo.TeacherVo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 教师信息表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Service
public class TeacherInfoServiceImpl extends ServiceImpl<TeacherInfoMapper, TeacherInfo> implements TeacherInfoService {
    @Resource
    private TeacherInfoMapper mapper;

    @Override
    public ResponseUtil<String> updateTeacherInfo(TeacherInfo teacherInfo) {
        boolean b = updateById(teacherInfo);
        if(b){
            return ResponseUtil.success("修改成功");
        }
        return ResponseUtil.error("修改失败");
    }

    @Override
    public ResponseUtil<String> deleteTeacherInfo(TeacherInfo teacherInfo) {
        boolean b = removeById(teacherInfo);
        if(b){
            return ResponseUtil.success("删除成功");
        }
        return ResponseUtil.error("删除失败");
    }

    @Override
    public ResponseUtil<String> addTeacherInfo(TeacherInfo teacherInfo) {
        boolean save = save(teacherInfo);
        if(save){
            return ResponseUtil.success("保存成功");
        }
        return ResponseUtil.error("保存失败");
    }

    @Override
    public ResponseUtil<IPage<TeacherVo>> getTeachers(PageReq pageReq) {
        Page<TeacherInfo> page = new Page<>(pageReq.getCurPage(), pageReq.getPageSize());
        IPage<TeacherInfo> resPage = mapper.selectPage(page,new QueryWrapper<>());
        List<TeacherInfo> records = resPage.getRecords();
        List<TeacherVo> voList = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            TeacherVo vo = new TeacherVo();
            copyBean(records.get(i), vo);
            voList.add(vo);
        }
        Page<TeacherVo> res = new Page<>();
//        res.setRecords(voList);
//        res.setTotal(studentInfoIPage.getTotal());
//        res.setSize(studentInfoIPage.getSize());
//        res.set;
        BeanUtil.copyProperties(resPage,res);
        res.setRecords(voList);
        return ResponseUtil.success(res);
    }

    @Override
    public ResponseUtil<TeacherVo> getOne(TeacherInfo teacherInfo) {
        TeacherInfo byId = getById(teacherInfo.getId());
        TeacherVo vo = new TeacherVo();
        copyBean(byId,vo);
        return ResponseUtil.success(vo);
    }

    @Override
    public ResponseUtil<List<TeacherVo>> getAll() {
        List<TeacherInfo> list = mapper.selectList(new QueryWrapper<>());
        List<TeacherVo> res = new ArrayList<>();
        for (TeacherInfo info : list) {
            TeacherVo vo = new TeacherVo();
            copyBean(info,vo);
            res.add(vo);
        }
        return ResponseUtil.success(res);
    }

    public void copyBean(TeacherInfo info, TeacherVo vo){
        BeanUtil.copyProperties(info,vo);
        vo.setTypeDesc(Objects.requireNonNull(TeacherType.getTeacherType(info.getType())).value);
    }
}
