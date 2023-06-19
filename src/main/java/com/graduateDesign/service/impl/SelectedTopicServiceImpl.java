package com.graduateDesign.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.constant.ProgressConstant;
import com.graduateDesign.entity.SelectedTopic;
import com.graduateDesign.dao.SelectedTopicMapper;
import com.graduateDesign.entity.StudentInfo;
import com.graduateDesign.entity.TeacherInfo;
import com.graduateDesign.entity.TopicInfo;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.req.SelectedTopicReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.SelectedTopicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduateDesign.service.StudentInfoService;
import com.graduateDesign.service.TeacherInfoService;
import com.graduateDesign.service.TopicInfoService;
import com.graduateDesign.vo.SelectedTopicVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 选题信息表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Slf4j
@Service
public class SelectedTopicServiceImpl extends ServiceImpl<SelectedTopicMapper, SelectedTopic> implements SelectedTopicService {
    @Resource
    private SelectedTopicMapper mapper;
    @Resource
    private StudentInfoService studentInfoService;
    @Resource
    private TeacherInfoService teacherInfoService;
    @Resource
    private TopicInfoService topicInfoService;

    @Override
    public ResponseUtil<IPage<SelectedTopicVo>> getSelectedTopics(PageReq pageReq) {
        // TODO: 已选题目的分页查询
        return null;
    }

    // 添加选题信息
    @Override
    public ResponseUtil<String> addSelectedTopic(SelectedTopicReq req) {
        StudentInfo studentInfoByNo = studentInfoService.getStudentInfoByNo(req.getStuNo());
        SelectedTopic selectedTopic = new SelectedTopic();
        selectedTopic.setTopicId(req.getTopicId());
        selectedTopic.setTeacherId(req.getTeacherId());
        selectedTopic.setStuId(studentInfoByNo.getId());
        // 等待老师确认状态
        selectedTopic.setProgress(ProgressConstant.WAITING_FOR_TEACHER_CONFIRM.getKey());
        log.info("带保存的选题记录:{}",selectedTopic.toString());
        boolean save = save(selectedTopic);
        if(save){
            return ResponseUtil.success("保存成功");
        }
        return ResponseUtil.error("保存失败");
    }

    @Override
    public ResponseUtil<String> deleteSelectedTopic(SelectedTopic entity) {
        boolean b = removeById(entity);
        if(b){
            return ResponseUtil.success("删除成功");
        }
        return ResponseUtil.error("删除失败");
    }

    @Override
    public ResponseUtil<String> updateSelectedTopic(SelectedTopic entity) {
        boolean b = updateById(entity);
        if(b){
            return ResponseUtil.success("修改成功");
        }
        return ResponseUtil.error("修改失败");
    }

    @Override
    public ResponseUtil<SelectedTopicVo> getOne(SelectedTopic entity) {
        SelectedTopic byId = getById(entity.getId());
        SelectedTopicVo vo = new SelectedTopicVo();
        copyBean(byId,vo);
        return ResponseUtil.success(vo);
    }

    @Override
    public ResponseUtil<List<SelectedTopicVo>> getAll() {
        List<SelectedTopic> selectedTopics = mapper.selectList(new QueryWrapper<>());
        List<SelectedTopicVo> res = new ArrayList<>();
        for (SelectedTopic selectedTopic : selectedTopics) {
            SelectedTopicVo vo = new SelectedTopicVo();
            copyBean(selectedTopic,vo);
            res.add(vo);
        }
        return ResponseUtil.success(res);
    }

    @Override
    public ResponseUtil<List<SelectedTopicVo>> getByCondition(SelectedTopicReq req) {
        log.info("请求参数信息：{}",req.toString());
        List<SelectedTopic> selectedTopics = mapper.getByCondition(req);
        List<SelectedTopicVo> res = new ArrayList<>();
        for (SelectedTopic selectedTopic : selectedTopics) {
            SelectedTopicVo vo = new SelectedTopicVo();
            copyBean(selectedTopic,vo);
            res.add(vo);
        }
        return ResponseUtil.success(res);
    }

    @Override
    public ResponseUtil<List<SelectedTopicVo>> getSelectedStuListByTeacherNo(String teacherNo) {
        List<SelectedTopicVo> list = mapper.getSelectedStuListByTeacherNo(teacherNo);
        for (SelectedTopicVo vo : list) {
            vo.setProgressDesc(ProgressConstant.getEnum(vo.getProgress()).getValue());
        }
        return ResponseUtil.success(list);
    }

    @Override
    public ResponseUtil<List<SelectedTopicVo>> getSelectingStuListByTeacherNo(String teacherNo) {
        List<SelectedTopicVo> list = mapper.getSelectingStuListByTeacherNo(teacherNo);
        for (SelectedTopicVo vo : list) {
            vo.setProgressDesc(ProgressConstant.getEnum(vo.getProgress()).getValue());
        }
        return ResponseUtil.success(list);
    }

    @Override
    public ResponseUtil<String> agree(SelectedTopicReq req) {
        UpdateWrapper<SelectedTopic> wrapper = new UpdateWrapper<>();
        wrapper.eq("id",req.getId())
                .set("progress",ProgressConstant.WAITING_FOR_OPENING.getKey());
        boolean update = update(wrapper);
        return update ? ResponseUtil.success("成功") : ResponseUtil.error("失败");
    }

    @Override
    public ResponseUtil<String> refuse(SelectedTopicReq req) {
        boolean b = removeById(req.getId());
        return b ? ResponseUtil.success("成功") : ResponseUtil.error("失败");
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
