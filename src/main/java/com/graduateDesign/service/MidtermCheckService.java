package com.graduateDesign.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.MidtermCheck;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduateDesign.entity.SelectedTopic;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;

/**
 * <p>
 * 中期检查表 服务类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
public interface MidtermCheckService extends IService<MidtermCheck> {

    ResponseUtil<IPage<MidtermCheck>> getMidtermChecks(PageReq pageReq);

    ResponseUtil<String> addMidtermCheck(MidtermCheck entity);

    ResponseUtil<String> deleteMidtermCheck(MidtermCheck entity);

    ResponseUtil<String> updateMidtermCheck(MidtermCheck entity);

    ResponseUtil<MidtermCheck> getOne(MidtermCheck entity);
}
