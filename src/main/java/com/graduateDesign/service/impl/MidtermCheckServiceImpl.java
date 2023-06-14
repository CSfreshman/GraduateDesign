package com.graduateDesign.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.MidtermCheck;
import com.graduateDesign.dao.MidtermCheckMapper;
import com.graduateDesign.entity.SelectedTopic;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.MidtermCheckService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 中期检查表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Service
public class MidtermCheckServiceImpl extends ServiceImpl<MidtermCheckMapper, MidtermCheck> implements MidtermCheckService {

    @Resource
    private MidtermCheckMapper mapper;

    @Override
    public ResponseUtil<IPage<MidtermCheck>> getMidtermChecks(PageReq pageReq) {
        // TODO: 完成中期检查信息
        return null;
    }

    @Override
    public ResponseUtil<String> addMidtermCheck(MidtermCheck entity) {
        boolean save = save(entity);
        if(save){
            return ResponseUtil.success("保存成功");
        }
        return ResponseUtil.error("保存失败");
    }

    @Override
    public ResponseUtil<String> deleteMidtermCheck(MidtermCheck entity) {
        boolean b = removeById(entity);
        if(b){
            return ResponseUtil.success("删除成功");
        }
        return ResponseUtil.error("删除失败");
    }

    @Override
    public ResponseUtil<String> updateMidtermCheck(MidtermCheck entity) {
        boolean b = updateById(entity);
        if(b){
            return ResponseUtil.success("修改成功");
        }
        return ResponseUtil.error("修改失败");
    }

    @Override
    public ResponseUtil<MidtermCheck> getOne(MidtermCheck entity) {
        // TODO: 完成中期检查信息
        return null;
    }
}
