package com.graduateDesign.dao;

import com.graduateDesign.entity.Defense;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 答辩表 Mapper 接口
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Mapper
public interface DefenseMapper extends BaseMapper<Defense> {

    Defense getByStuId(Long stuId);

    Defense getByStuNo(@Param("stuNo") String stuNo);
}
