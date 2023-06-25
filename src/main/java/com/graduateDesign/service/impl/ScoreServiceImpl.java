package com.graduateDesign.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.constant.TeacherType;
import com.graduateDesign.dao.MidtermCheckMapper;
import com.graduateDesign.entity.Score;
import com.graduateDesign.dao.ScoreMapper;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.req.SelectedTopicReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.ScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.graduateDesign.service.SelectedTopicService;
import com.graduateDesign.vo.ScoreVo;
import com.graduateDesign.vo.SelectedTopicVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 成绩表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Service
@Slf4j
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {

    @Resource
    private ScoreMapper mapper;
    @Resource
    private SelectedTopicService selectedTopicService;

    @Override
    public ResponseUtil<IPage<Score>> getScores(PageReq pageReq) {
        // TODO: 完成成绩信息
        return null;
    }

    @Override
    public ResponseUtil<Score> getOne(Score entity) {
        // TODO：完成成绩信息
        return null;
    }

    @Override
    public ResponseUtil<String> addScore(Score entity) {
        boolean save = save(entity);
        if(save){
            return ResponseUtil.success("保存成功");
        }
        return ResponseUtil.error("保存失败");
    }

    @Override
    public ResponseUtil<String> deleteScore(Score entity) {
        boolean b = removeById(entity);
        if(b){
            return ResponseUtil.success("删除成功");
        }
        return ResponseUtil.error("删除失败");
    }

    @Override
    public ResponseUtil<String> updateScore(Score entity) {
        boolean b = updateById(entity);
        if(b){
            return ResponseUtil.success("修改成功");
        }
        return ResponseUtil.error("修改失败");
    }

    // 查询成绩列表
    @Override
    public ResponseUtil<List<ScoreVo>> getAll() {
        List<Score> scores = mapper.selectList(new QueryWrapper<>());
        List<ScoreVo> resVo = new ArrayList<>();
        for (Score score : scores) {
            ScoreVo vo = new ScoreVo();
            BeanUtil.copyProperties(score, vo);
            SelectedTopicReq req = new SelectedTopicReq();
            req.setId(score.getSelectedTopicId());
            List<SelectedTopicVo> data = selectedTopicService.getByCondition(req).getData();
            log.info("改buging：{}",data);
            SelectedTopicVo selectedTopicVo = data.get(0);
            log.info(selectedTopicVo.toString());
            vo.setStuNo(selectedTopicVo.getStudentVo().getStuNo());
            vo.setStuName(selectedTopicVo.getStudentVo().getStuName());
            vo.setTopicName(selectedTopicVo.getTopicVo().getTopicName());
            vo.setTopicType(TeacherType.getTeacherType(selectedTopicVo.getTopicVo().getType()).getValue());
            vo.setTeacherName(selectedTopicVo.getTeacherVo().getTeacherName());
            resVo.add(vo);
        }
        return ResponseUtil.success(resVo);
    }

    @Override
    public ResponseUtil<Score> getByStuId(Long stuId) {
        return ResponseUtil.success(mapper.getByStuId(stuId));
    }
}
