package com.graduateDesign.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.graduateDesign.constant.TeacherType;
import com.graduateDesign.controller.TopicInfoController;
import com.graduateDesign.dao.TeacherInfoMapper;
import com.graduateDesign.entity.TeacherInfo;
import com.graduateDesign.entity.TopicInfo;
import com.graduateDesign.dao.TopicInfoMapper;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.TeacherInfoService;
import com.graduateDesign.service.TopicInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduateDesign.vo.TeacherVo;
import com.graduateDesign.vo.TopicVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课题信息表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Service
public class TopicInfoServiceImpl extends ServiceImpl<TopicInfoMapper, TopicInfo> implements TopicInfoService {
    @Resource
    private TopicInfoMapper mapper;
    @Resource
    private TeacherInfoMapper teacherInfoMapper;

    @Override
    public ResponseUtil<IPage<TopicVo>> getTopics(PageReq pageReq) {
        Page<TopicInfo> page = new Page<>(pageReq.getCurPage(), pageReq.getPageSize());
        IPage<TopicInfo> resPage = mapper.selectPage(page,new QueryWrapper<>());
        List<TopicInfo> records = resPage.getRecords();
        List<TopicVo> voList = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            TopicVo vo = new TopicVo();
            copyBean(records.get(i), vo);
            voList.add(vo);
        }
        Page<TopicVo> res = new Page<>();
//        res.setRecords(voList);
//        res.setTotal(studentInfoIPage.getTotal());
//        res.setSize(studentInfoIPage.getSize());
//        res.set;
        BeanUtil.copyProperties(resPage,res);
        res.setRecords(voList);
        return ResponseUtil.success(res);
    }

    @Override
    public ResponseUtil<String> addTopicInfo(TopicInfo topicInfo) {
        boolean save = save(topicInfo);
        if(save){
            return ResponseUtil.success("保存成功");
        }
        return ResponseUtil.error("保存失败");
    }

    @Override
    public ResponseUtil<String> deleteTopicInfo(TopicInfo topicInfo) {
        boolean b = removeById(topicInfo);
        if(b){
            return ResponseUtil.success("删除成功");
        }
        return ResponseUtil.error("删除失败");
    }

    @Override
    public ResponseUtil<String> updateTopicInfo(TopicInfo topicInfo) {
        boolean b = updateById(topicInfo);
        if(b){
            return ResponseUtil.success("修改成功");
        }
        return ResponseUtil.error("修改失败");
    }

    @Override
    public ResponseUtil<TopicVo> getOne(TopicInfo topicInfo) {
        TopicInfo byId = getById(topicInfo.getId());
        TopicVo vo = new TopicVo();
        copyBean(byId,vo);
        return ResponseUtil.success(vo);
    }

    @Override
    public ResponseUtil<List<TopicVo>> getAll() {
        List<TopicInfo> topicInfos = mapper.selectList(new QueryWrapper<>());
        List<TopicVo> res = new ArrayList<>();
        for (TopicInfo info : topicInfos) {
            TopicVo vo = new TopicVo();
            copyBean(info, vo);
            res.add(vo);
        }
        return ResponseUtil.success(res);
    }

    @Override
    public ResponseUtil<List<TeacherInfo>> getTeacherCanSelect(TopicInfo topicInfo) {
        Integer type = topicInfo.getType();
        QueryWrapper<TeacherInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        // 余量大于等于1
        wrapper.ge("stock",1);
        List<TeacherInfo> list = teacherInfoMapper.selectList(wrapper);
        return ResponseUtil.success(list);
    }

    public void copyBean(TopicInfo info, TopicVo vo){
        BeanUtil.copyProperties(info,vo);
        vo.setTypeDesc(TeacherType.getTeacherType(info.getType()).value);
    }
}
