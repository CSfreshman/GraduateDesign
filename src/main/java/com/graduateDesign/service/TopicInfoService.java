package com.graduateDesign.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.TeacherInfo;
import com.graduateDesign.entity.TopicInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.vo.TopicVo;

import java.util.List;

/**
 * <p>
 * 课题信息表 服务类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
public interface TopicInfoService extends IService<TopicInfo> {

    ResponseUtil<IPage<TopicVo>> getTopics(PageReq pageReq);

    ResponseUtil<String> addTopicInfo(TopicInfo topicInfo);

    ResponseUtil<String> deleteTopicInfo(TopicInfo topicInfo);

    ResponseUtil<String> updateTopicInfo(TopicInfo topicInfo);

    ResponseUtil<TopicVo> getOne(TopicInfo topicInfo);

    ResponseUtil<List<TopicVo>> getAll();

    ResponseUtil<List<TeacherInfo>> getTeacherCanSelect(TopicInfo topicInfo);

    ResponseUtil<String> readExcel();
}
