package com.graduateDesign.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.Defense;
import com.graduateDesign.entity.MidtermCheck;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.DefenseService;
import com.graduateDesign.service.MidtermCheckService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 答辩表 前端控制器
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@RestController
@RequestMapping("/defense")
public class DefenseController {
    @Resource
    private DefenseService service;

    // TODO: 返回的信息改为VO
    @PostMapping("/getPage")
    public ResponseUtil<IPage<MidtermCheck>> getDefenses(@RequestBody PageReq pageReq){
        return service.getMidtermChecks(pageReq);
    }
    // TODO: 返回的信息改为VO
    @PostMapping("/getOne")
    public ResponseUtil<MidtermCheck> getOne(@RequestBody Defense entity){
        return service.getOne(entity);
    }

    @PostMapping("/add")
    public ResponseUtil<String> addDefense(@RequestBody Defense entity){
        return service.addDefense(entity);
    }

    @PostMapping("/delete")
    public ResponseUtil<String> deleteDefense(@RequestBody Defense entity){
        return service.deleteDefense(entity);
    }

    @PostMapping("/update")
    public ResponseUtil<String> updateDefense(@RequestBody Defense entity){
        return service.updateDefense(entity);
    }
}
