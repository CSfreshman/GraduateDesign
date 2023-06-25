package com.graduateDesign.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.entity.Score;
import com.baomidou.mybatisplus.extension.service.IService;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.vo.ScoreVo;

import java.util.List;

/**
 * <p>
 * 成绩表 服务类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
public interface ScoreService extends IService<Score> {

    ResponseUtil<IPage<Score>> getScores(PageReq pageReq);

    ResponseUtil<Score> getOne(Score entity);

    ResponseUtil<String> addScore(Score entity);

    ResponseUtil<String> deleteScore(Score entity);

    ResponseUtil<String> updateScore(Score entity);

    ResponseUtil<List<ScoreVo>> getAll();

    ResponseUtil<Score> getByStuId(Long stuId);
}
