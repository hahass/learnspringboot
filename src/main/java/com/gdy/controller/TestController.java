package com.gdy.controller;

import com.gdy.bean.ExcelBean;
import com.gdy.util.excel.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
public class TestController {

    @RequestMapping("/readexcel")
    public Object hello(@RequestParam("file") MultipartFile file) {
        List<Object> objects = ExcelUtil.readExcel(file, new ExcelBean());

        for(Object o :objects){
            ExcelBean excelBean = (ExcelBean)o;
            System.out.println(excelBean.getAge());
        }
        return objects;
    }





}
