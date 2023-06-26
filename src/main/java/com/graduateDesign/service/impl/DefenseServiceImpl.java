package com.graduateDesign.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.constant.ProgressConstant;
import com.graduateDesign.dao.MidtermCheckMapper;
import com.graduateDesign.dao.SelectedTopicMapper;
import com.graduateDesign.entity.*;
import com.graduateDesign.dao.DefenseMapper;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.req.SelectedTopicReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.DefenseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduateDesign.service.StudentInfoService;
import com.graduateDesign.service.TeacherInfoService;
import com.graduateDesign.service.TopicInfoService;
import com.graduateDesign.vo.DefenseVo;
import com.graduateDesign.vo.SelectedTopicVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 答辩表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Service
@Slf4j
public class DefenseServiceImpl extends ServiceImpl<DefenseMapper, Defense> implements DefenseService {

    @Resource
    private DefenseMapper mapper;
    @Resource
    private StudentInfoService studentInfoService;
    @Resource
    private TeacherInfoService teacherInfoService;
    @Resource
    private TopicInfoService topicInfoService;
    @Resource
    private SelectedTopicMapper selectedTopicMapper;
    @Override
    public ResponseUtil<IPage<MidtermCheck>> getMidtermChecks(PageReq pageReq) {
        // TODO: 答辩情况的分页查询
        return null;
    }

    @Override
    public ResponseUtil<MidtermCheck> getOne(Defense entity) {
        // TODO:
        return null;
    }

    @Override
    public ResponseUtil<String> addDefense(Defense entity) {
        boolean save = save(entity);
        if(save){
            return ResponseUtil.success("保存成功");
        }
        return ResponseUtil.error("保存失败");
    }

    @Override
    public ResponseUtil<String> deleteDefense(Defense entity) {
        boolean b = removeById(entity);
        if(b){
            return ResponseUtil.success("删除成功");
        }
        return ResponseUtil.error("删除失败");
    }

    @Override
    public ResponseUtil<String> updateDefense(Defense entity) {
        boolean b = updateById(entity);
        if(b){
            return ResponseUtil.success("修改成功");
        }
        return ResponseUtil.error("修改失败");
    }

    @Override
    public ResponseUtil<List<DefenseVo>> getAll() {
        List<Defense> defenses = mapper.selectList(new QueryWrapper<>());
        List<DefenseVo> collect = defenses.stream().map(v -> {
            DefenseVo vo = new DefenseVo();
            BeanUtil.copyProperties(v,vo);
            SelectedTopicReq selectedTopicReq = new SelectedTopicReq();
            selectedTopicReq.setId(v.getSelectedTopicId());
            List<SelectedTopicVo> res = new ArrayList<>();
            List<SelectedTopic> dataList = selectedTopicMapper.getByCondition(selectedTopicReq);
            for (SelectedTopic selectedTopic : dataList) {
                SelectedTopicVo vo1 = new SelectedTopicVo();
                copyBean(selectedTopic,vo1);
                res.add(vo1);
            }
            SelectedTopicVo data = res.get(0);
            log.info("选题信息：{}",data);
            vo.setStuNo(data.getStudentVo().getStuNo());
            vo.setStuName(data.getStudentVo().getStuName());
            vo.setTeacherName(data.getTeacherVo().getTeacherName());
            vo.setTopicName(data.getTopicVo().getTopicName());
            vo.setProgress(data.getProgress());
            vo.setProgressDesc(ProgressConstant.getEnum(data.getProgress()).getValue());
            return vo;
        }).collect(Collectors.toList());
        return ResponseUtil.success(collect);
    }

    @Override
    public ResponseUtil<Defense> getByStuId(Long stuId) {
        return ResponseUtil.success(mapper.getByStuId(stuId));
    }

    @Override
    public ResponseUtil<DefenseVo> getByStuNo(String stuNo) {
        Defense v = mapper.getByStuNo(stuNo);
        DefenseVo vo = new DefenseVo();
        BeanUtil.copyProperties(v,vo);
        SelectedTopicReq selectedTopicReq = new SelectedTopicReq();
        selectedTopicReq.setId(v.getSelectedTopicId());
        List<SelectedTopicVo> res = new ArrayList<>();
        List<SelectedTopic> dataList = selectedTopicMapper.getByCondition(selectedTopicReq);
        for (SelectedTopic selectedTopic : dataList) {
            SelectedTopicVo vo1 = new SelectedTopicVo();
            copyBean(selectedTopic,vo1);
            res.add(vo1);
        }
        SelectedTopicVo data = res.get(0);
        log.info("选题信息：{}",data);
        vo.setStuNo(data.getStudentVo().getStuNo());
        vo.setStuName(data.getStudentVo().getStuName());
        vo.setTeacherName(data.getTeacherVo().getTeacherName());
        vo.setTopicName(data.getTopicVo().getTopicName());
        vo.setProgress(data.getProgress());
        vo.setProgressDesc(ProgressConstant.getEnum(data.getProgress()).getValue());
        return ResponseUtil.success(vo);
    }

    public void copyBean(SelectedTopic info, SelectedTopicVo vo){
        BeanUtil.copyProperties(info,vo);
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(vo.getStuId());
        vo.setStudentVo(studentInfoService.getOneStudentById(studentInfo).getData());

        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setId(vo.getTeacherId());
        vo.setTeacherVo(teacherInfoService.getOne(teacherInfo).getData());

        TopicInfo topicInfo = new TopicInfo();
        topicInfo.setId(vo.getTopicId());
        vo.setTopicVo(topicInfoService.getOne(topicInfo).getData());

        // 添加选题进度描述
        vo.setProgressDesc(ProgressConstant.getEnum(info.getProgress()).getValue());
    }
}
