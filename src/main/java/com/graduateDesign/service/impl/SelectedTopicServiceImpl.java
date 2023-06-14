package com.graduateDesign.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.constant.ProgressConstant;
import com.graduateDesign.constant.TeacherType;
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
import com.graduateDesign.vo.TopicVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    private SelectedTopicMapper selectedTopicMapper;
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
    // TODO: 这里可以尝试使用触发器，新加了一个选题信息之后，选择的题目的数量以及老师指导的数量都要相应-1
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

    public void copyBean(SelectedTopic info, SelectedTopicVo vo){
        BeanUtil.copyProperties(info,vo);
        vo.setStudentInfo(studentInfoService.getById(vo.getStuId()));

        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setId(vo.getTeacherId());
        vo.setTeacherVo(teacherInfoService.getOne(teacherInfo).getData());

        TopicInfo topicInfo = new TopicInfo();
        topicInfo.setId(vo.getTopicId());
        vo.setTopicVo(topicInfoService.getOne(topicInfo).getData());

        // TODO:添加选题进度描述
    }
}
