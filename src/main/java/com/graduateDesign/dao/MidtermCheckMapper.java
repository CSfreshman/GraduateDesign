package com.graduateDesign.dao;

import com.graduateDesign.entity.MidtermCheck;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduateDesign.resp.ResponseUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 中期检查表 Mapper 接口
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Mapper
public interface MidtermCheckMapper extends BaseMapper<MidtermCheck> {

    MidtermCheck getByStuId(@Param("stuId") Long stuId);
}
