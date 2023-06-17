package com.graduateDesign.util;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.graduateDesign.dao.StudentInfoMapper;
import com.graduateDesign.excel.StudentExcelEntity;
import com.graduateDesign.resp.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

@Slf4j
public class TestUtil {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\wzw\\Desktop\\studentInfo.xlsx";
        try{
            EasyExcel.read(fileName, StudentExcelEntity.class,new StudentDataListener()).sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
            log.info("出错了:{}",e.getMessage());
        }
    }
}
