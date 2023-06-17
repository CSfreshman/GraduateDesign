package com.graduateDesign.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.SelectedTopic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.req.SelectedTopicReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.vo.SelectedTopicVo;

import java.util.List;

/**
 * <p>
 * 选题信息表 服务类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
public interface SelectedTopicService extends IService<SelectedTopic> {

    ResponseUtil<IPage<SelectedTopicVo>> getSelectedTopics(PageReq pageReq);

    ResponseUtil<String> addSelectedTopic(SelectedTopicReq entity);

    ResponseUtil<String> deleteSelectedTopic(SelectedTopic entity);

    ResponseUtil<String> updateSelectedTopic(SelectedTopic entity);

    ResponseUtil<SelectedTopicVo> getOne(SelectedTopic entity);

    ResponseUtil<List<SelectedTopicVo>> getAll();

    ResponseUtil<List<SelectedTopicVo>> getByCondition(SelectedTopicReq req);
}
