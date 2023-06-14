package com.graduateDesign.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.Score;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.ScoreService;
import com.graduateDesign.service.ScoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 成绩表 前端控制器
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@RestController
@RequestMapping("/score")
public class ScoreController {
    @Resource
    private ScoreService service;

    // TODO: 返回的信息改为VO
    @PostMapping("/getPage")
    public ResponseUtil<IPage<Score>> getScores(@RequestBody PageReq pageReq){
        return service.getScores(pageReq);
    }
    // TODO: 返回的信息改为VO
    @PostMapping("/getOne")
    public ResponseUtil<Score> getOne(@RequestBody Score entity){
        return service.getOne(entity);
    }

    @PostMapping("/add")
    public ResponseUtil<String> addScore(@RequestBody Score entity){
        return service.addScore(entity);
    }

    @PostMapping("/delete")
    public ResponseUtil<String> deleteScore(@RequestBody Score entity){
        return service.deleteScore(entity);
    }

    @PostMapping("/update")
    public ResponseUtil<String> updateScore(@RequestBody Score entity){
        return service.updateScore(entity);
    }
}
