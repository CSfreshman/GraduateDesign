package com.graduateDesign.util;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.graduateDesign.constant.MajorEnum;
import com.graduateDesign.constant.TeacherType;
import com.graduateDesign.dao.StudentInfoMapper;
import com.graduateDesign.dao.TeacherInfoMapper;
import com.graduateDesign.entity.StudentInfo;
import com.graduateDesign.entity.TeacherInfo;
import com.graduateDesign.excel.StudentExcelEntity;
import com.graduateDesign.excel.TeacherExcel;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 读取老师信息的监听器
 */
@Slf4j
public class TeacherDataListener implements ReadListener<TeacherExcel> {
    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;

    /**
     * 缓存的数据
     */
    private List<TeacherExcel> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    /**
     * 信息的mapper
     */
    private TeacherInfoMapper mapper;

    public TeacherDataListener(TeacherInfoMapper mapper) {
        this.mapper = mapper;
    }
    public TeacherDataListener() {
    }

    @Override
    public void invoke(TeacherExcel teacherExcel, AnalysisContext analysisContext) {
        log.info("解析到一条数据{}", JSONUtil.toJsonStr(teacherExcel));
        teacherExcel.setType(TeacherType.getTeacherType(teacherExcel.getTypeDesc()).key);
        cachedDataList.add(teacherExcel);
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
        for (TeacherExcel teacherExcel : cachedDataList) {
            TeacherInfo teacherInfo = new TeacherInfo();
            teacherInfo.setTeacherNo(teacherExcel.getTeacherNo());
            teacherInfo.setTeacherName(teacherExcel.getTeacherName());
            teacherInfo.setType(teacherExcel.getType());
            teacherInfo.setStock(teacherExcel.getStock());
            mapper.insert(teacherInfo);
        }
        log.info("存储数据库成功！");
    }
}
