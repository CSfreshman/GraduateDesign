package com.graduateDesign.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.graduateDesign.dao.MidtermCheckMapper;
import com.graduateDesign.entity.Score;
import com.graduateDesign.dao.ScoreMapper;
import com.graduateDesign.req.PageReq;
import com.graduateDesign.resp.ResponseUtil;
import com.graduateDesign.service.ScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 成绩表 服务实现类
 * </p>
 *
 * @author wuziwen
 * @since 2023年06月13日
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {

    @Resource
    private ScoreMapper mapper;

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
}
