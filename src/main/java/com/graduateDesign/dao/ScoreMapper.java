package com.graduateDesign.dao;

import com.graduateDesign.entity.Score;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 成绩表 Mapper 接口
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Mapper
public interface ScoreMapper extends BaseMapper<Score> {

    Score getByStuId(@Param("stuId") Long stuId);

    Score getByStuNo(@Param("stuNo") String stuNo);
}
