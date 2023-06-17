package com.graduateDesign.util;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.graduateDesign.constant.MajorEnum;
import com.graduateDesign.dao.StudentInfoMapper;
import com.graduateDesign.entity.StudentInfo;
import com.graduateDesign.excel.StudentExcelEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;

/**
 * 读取学生信息的监听器
 */
@Slf4j
public class StudentDataListener implements ReadListener<StudentExcelEntity> {
    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;

    /**
     * 缓存的数据
     */
    private List<StudentExcelEntity> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    /**
     * 学生信息的mapper
     */
    private StudentInfoMapper mapper;

    public StudentDataListener(StudentInfoMapper mapper) {
        this.mapper = mapper;
    }
    public StudentDataListener() {
    }

    @Override
    public void invoke(StudentExcelEntity studentExcelEntity, AnalysisContext analysisContext) {
        log.info("解析到一条数据{}", JSONUtil.toJsonStr(studentExcelEntity));
        studentExcelEntity.setMajor(MajorEnum.getMajorEnum(studentExcelEntity.getMajorDesc()).getKey());
        cachedDataList.add(studentExcelEntity);
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
        //mapper.saveBatch(cachedDataList);
        for (StudentExcelEntity excelEntity : cachedDataList) {
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setStuName(excelEntity.getStuName());
            studentInfo.setStuNo(excelEntity.getStuNo());
            studentInfo.setMajor(excelEntity.getMajor());
            mapper.insert(studentInfo);
        }
        log.info("存储数据库成功！");
    }
}
