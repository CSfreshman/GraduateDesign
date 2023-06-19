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
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class TestUtil {

    public static void main(String[] args) {
        // 测试excel
//        String fileName = "C:\\Users\\wzw\\Desktop\\studentInfo.xlsx";
//        try{
//            EasyExcel.read(fileName, StudentExcelEntity.class,new StudentDataListener()).sheet().doRead();
//        }catch (Exception e){
//            e.printStackTrace();
//            log.info("出错了:{}",e.getMessage());
//        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.parse("2023-06-30 08:00:00", df));
    }
}
