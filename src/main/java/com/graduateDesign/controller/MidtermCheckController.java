package com.graduateDesign.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.MidtermCheck;
import com.graduateDesign.entity.SelectedTopic;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.MidtermCheckService;
import com.graduateDesign.service.SelectedTopicService;
import com.graduateDesign.vo.MidtermCheckVo;
import com.graduateDesign.vo.SelectedTopicVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 中期检查表 前端控制器
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@RestController
@RequestMapping("/midtermCheck")
public class MidtermCheckController {
    @Resource
    private MidtermCheckService service;

    // TODO: 返回的信息改为VO
    @PostMapping("/getPage")
    public ResponseUtil<IPage<MidtermCheck>> getMidtermChecks(@RequestBody PageReq pageReq){
        return service.getMidtermChecks(pageReq);
    }
    // TODO: 返回的信息改为VO
    @PostMapping("/getOne")
    public ResponseUtil<MidtermCheck> getOne(@RequestBody MidtermCheck entity){
        return service.getOne(entity);
    }

    @PostMapping("/add")
    public ResponseUtil<String> addMidtermCheck(@RequestBody MidtermCheck entity){
        return service.addMidtermCheck(entity);
    }

    @PostMapping("/delete")
    public ResponseUtil<String> deleteMidtermCheck(@RequestBody MidtermCheck entity){
        return service.deleteMidtermCheck(entity);
    }

    @PostMapping("/update")
    public ResponseUtil<String> updateMidtermCheck(@RequestBody MidtermCheck entity){
        return service.updateMidtermCheck(entity);
    }

    @GetMapping("/getAll")
    public ResponseUtil<List<MidtermCheckVo>> getAll(){
        return service.getAll();
    }

    @GetMapping("/getByStuId/{stuId}")
    public ResponseUtil<MidtermCheck> getByStuId(@PathVariable("stuId") Long stuId){
        return service.getByStuId(stuId);
    }
}
