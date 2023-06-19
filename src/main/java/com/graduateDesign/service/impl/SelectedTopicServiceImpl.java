package com.graduateDesign.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.graduateDesign.constant.ProgressConstant;
import com.graduateDesign.entity.*;
import com.graduateDesign.dao.SelectedTopicMapper;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.req.SelectedTopicReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduateDesign.vo.SelectedTopicVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
    @Resource
    private MidtermCheckService midtermCheckService;
    @Resource
    private DefenseService defenseService;
    @Resource
    private ScoreService scoreService;

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
    public ResponseUtil<String> updateSelectedTopic(SelectedTopicReq req) {
        if(req.getProgress() != req.getOriginalProgress() + 1){
            return ResponseUtil.error("更新状态非法");
        }
        int progress = req.getProgress();
        UpdateWrapper<SelectedTopic> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",req.getId())
                .set("progress",progress);
        boolean update = update(updateWrapper);
        //DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if(!update){
            return ResponseUtil.error("更新失败");
        }
        if(progress == 12){
            // 更新为等待开题报告
            // do-nothing
        }else if(progress == 13){
            // 更新为等待中期检查
            MidtermCheck midtermCheck = new MidtermCheck();
            // 获得中期检查时间
            midtermCheck.setDate(req.getMidCheckDate());
            // 获得中期检查地点
            midtermCheck.setLocation(req.getMidCheckLocation());
            // 选题编号
            midtermCheck.setSelectedTopicId(req.getId());
            midtermCheckService.save(midtermCheck);
        }else if(progress == 14){
            // 更新为等待答辩
            // 先填写中期检察意见
            if(StringUtils.isNotBlank(req.getMidCheckOpinion())){
                midtermCheckService.update(new UpdateWrapper<MidtermCheck>().eq("selected_topic_id",req.getId()).set("opinion",req.getMidCheckOpinion()));
            }
            Defense defense = new Defense();
            // 获得时间
            //defense.setDate(LocalDateTime.parse(req.getMidCheckDate(),df));
            defense.setDate(req.getDefenseDate());
            // 获得地点
            defense.setLocation(req.getMidCheckLocation());
            // 选题编号
            defense.setSelectedTopicId(req.getId());
            defenseService.save(defense);

        }else if(progress == 15){
            // 更新为完成状态
            // 先填写
            if(StringUtils.isNotBlank(req.getDefenseRecord())){
                defenseService.update(new UpdateWrapper<Defense>().eq("selected_topic_id",req.getId()).set("record",req.getDefenseRecord()));
            }
            // 获得各种成绩
            Score score = new Score();
            score.setAdvisorScore(req.getAdvisorScore());
            score.setReviewerScore(req.getReviewScore());
            score.setCommitteeScore(req.getCommitteeScore());
            score.setFinalScore(req.getFinalScore());
            scoreService.save(score);
        }
        return ResponseUtil.success("111");
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
