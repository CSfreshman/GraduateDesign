package com.graduateDesign.dao;

import com.graduateDesign.entity.SelectedTopic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.graduateDesign.req.SelectedTopicReq;
import com.graduateDesign.vo.SelectedTopicVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    List<SelectedTopic> getByCondition(@Param("req") SelectedTopicReq req);

    List<SelectedTopicVo> getSelectedStuListByTeacherNo(@Param("teacherNo") String teacherNo);

    List<SelectedTopicVo> getSelectingStuListByTeacherNo(String teacherNo);
}
