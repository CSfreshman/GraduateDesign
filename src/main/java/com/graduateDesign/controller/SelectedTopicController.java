package com.graduateDesign.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.SelectedTopic;
import com.graduateDesign.entity.TopicInfo;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.req.SelectedTopicReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.SelectedTopicService;
import com.graduateDesign.service.TopicInfoService;
import com.graduateDesign.vo.SelectedTopicVo;
import com.graduateDesign.vo.TopicVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 选题信息表 前端控制器
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@RestController
@RequestMapping("/selectedTopic")
public class SelectedTopicController {
    @Resource
    private SelectedTopicService service;

    @PostMapping("/getPage")
    public ResponseUtil<IPage<SelectedTopicVo>> getSelectedTopics(@RequestBody PageReq pageReq){
        return service.getSelectedTopics(pageReq);
    }

    @PostMapping("/getOne")
    public ResponseUtil<SelectedTopicVo> getOne(@RequestBody SelectedTopic entity){
        return service.getOne(entity);
    }

    @PostMapping("/add")
    public ResponseUtil<String> addSelectedTopic(@RequestBody SelectedTopicReq entity){
        return service.addSelectedTopic(entity);
    }

    @PostMapping("/delete")
    public ResponseUtil<String> deleteSelectedTopic(@RequestBody SelectedTopic entity){
        return service.deleteSelectedTopic(entity);
    }

    @PostMapping("/update")
    public ResponseUtil<String> updateSelectedTopic(@RequestBody SelectedTopic entity){
        return service.updateSelectedTopic(entity);
    }
}
