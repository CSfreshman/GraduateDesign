package com.graduateDesign.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.dao.MidtermCheckMapper;
import com.graduateDesign.entity.Defense;
import com.graduateDesign.dao.DefenseMapper;
import com.graduateDesign.entity.MidtermCheck;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.DefenseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 答辩表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Service
public class DefenseServiceImpl extends ServiceImpl<DefenseMapper, Defense> implements DefenseService {

    @Resource
    private DefenseMapper mapper;

    @Override
    public ResponseUtil<IPage<MidtermCheck>> getMidtermChecks(PageReq pageReq) {
        // TODO: 答辩情况的分页查询
        return null;
    }

    @Override
    public ResponseUtil<MidtermCheck> getOne(Defense entity) {
        // TODO:
        return null;
    }

    @Override
    public ResponseUtil<String> addDefense(Defense entity) {
        boolean save = save(entity);
        if(save){
            return ResponseUtil.success("保存成功");
        }
        return ResponseUtil.error("保存失败");
    }

    @Override
    public ResponseUtil<String> deleteDefense(Defense entity) {
        boolean b = removeById(entity);
        if(b){
            return ResponseUtil.success("删除成功");
        }
        return ResponseUtil.error("删除失败");
    }

    @Override
    public ResponseUtil<String> updateDefense(Defense entity) {
        boolean b = updateById(entity);
        if(b){
            return ResponseUtil.success("修改成功");
        }
        return ResponseUtil.error("修改失败");
    }
}
