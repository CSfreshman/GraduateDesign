package com.graduateDesign.util;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.graduateDesign.constant.TeacherType;
import com.graduateDesign.dao.TeacherInfoMapper;
import com.graduateDesign.dao.TopicInfoMapper;
import com.graduateDesign.entity.TeacherInfo;
import com.graduateDesign.entity.TopicInfo;
import com.graduateDesign.excel.TeacherExcel;
import com.graduateDesign.excel.TopicExcel;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 读取选题信息的监听器
 */
@Slf4j
public class TopicDataListener implements ReadListener<TopicExcel> {
    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;

    /**
     * 缓存的数据
     */
    private List<TopicExcel> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    /**
     * 信息的mapper
     */
    private TopicInfoMapper mapper;

    public TopicDataListener(TopicInfoMapper mapper) {
        this.mapper = mapper;
    }
    public TopicDataListener() {
    }

    @Override
    public void invoke(TopicExcel topicExcel, AnalysisContext analysisContext) {
        log.info("解析到一条数据{}", JSONUtil.toJsonStr(topicExcel));
        topicExcel.setType(TeacherType.getTeacherType(topicExcel.getTypeDesc()).key);
        cachedDataList.add(topicExcel);
        if(cachedDataList.size() >= BATCH_COUNT){
            saveData();
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    private void saveData(){
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
        for (TopicExcel topicExcel : cachedDataList) {
            TopicInfo topicInfo = new TopicInfo();
            topicInfo.setTopicName(topicExcel.getTopicName());
            topicInfo.setTopicDesc(topicExcel.getTopicDesc());
            topicInfo.setStock(topicExcel.getStock());
            topicInfo.setType(topicExcel.getType());
            mapper.insert(topicInfo);
        }
        log.info("存储数据库成功！");
    }
}
