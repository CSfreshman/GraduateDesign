package com.graduateDesign.dao;

import com.graduateDesign.entity.SelectedTopic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 选题信息表 Mapper 接口
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Mapper
public interface SelectedTopicMapper extends BaseMapper<SelectedTopic> {


    List<SelectedTopic> getAll();
}
