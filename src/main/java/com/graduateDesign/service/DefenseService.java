package com.graduateDesign.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.Defense;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduateDesign.entity.MidtermCheck;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;

/**
 * <p>
 * 答辩表 服务类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
public interface DefenseService extends IService<Defense> {

    ResponseUtil<IPage<MidtermCheck>> getMidtermChecks(PageReq pageReq);

    ResponseUtil<MidtermCheck> getOne(Defense entity);

    ResponseUtil<String> addDefense(Defense entity);

    ResponseUtil<String> deleteDefense(Defense entity);

    ResponseUtil<String> updateDefense(Defense entity);
}
