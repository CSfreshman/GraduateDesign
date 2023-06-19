package com.graduateDesign.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.TeacherInfo;
import com.graduateDesign.entity.TopicInfo;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.TeacherInfoService;
import com.graduateDesign.service.TopicInfoService;
import com.graduateDesign.vo.TeacherVo;
import com.graduateDesign.vo.TopicVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课题信息表 前端控制器
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@RestController
@RequestMapping("/topicInfo")
public class TopicInfoController {
    @Resource
    private TopicInfoService service;

    @GetMapping("/getAll")
    public ResponseUtil<List<TopicVo>> getAll(){
        return service.getAll();
    }

    @PostMapping("/getPage")
    public ResponseUtil<IPage<TopicVo>> getTeachers(@RequestBody PageReq pageReq){
        return service.getTopics(pageReq);
    }

    @PostMapping("/getOne")
    public ResponseUtil<TopicVo> getOne(@RequestBody TopicInfo topicInfo){
        return service.getOne(topicInfo);
    }

    @PostMapping("/add")
    public ResponseUtil<String> addTopicInfo(@RequestBody TopicInfo topicInfo){
        return service.addTopicInfo(topicInfo);
    }

    @PostMapping("/delete")
    public ResponseUtil<String> deleteTopicInfo(@RequestBody TopicInfo topicInfo){
        return service.deleteTopicInfo(topicInfo);
    }

    @PostMapping("/update")
    public ResponseUtil<String> updateTopicInfo(@RequestBody TopicInfo topicInfo){
        return service.updateTopicInfo(topicInfo);
    }
    @PostMapping("/getTeacherCanSelect")
    public ResponseUtil<List<TeacherInfo>> getTeacherCanSelect(@RequestBody TopicInfo topicInfo){
        return service.getTeacherCanSelect(topicInfo);
    }

    @PostMapping("/readExcel")
    public ResponseUtil<String> readExcel(){
        return service.readExcel();
    }
}
