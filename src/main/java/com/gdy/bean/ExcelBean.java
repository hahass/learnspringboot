/*
 * Copyright (c) 2018. SheIn
 * 南京领添信息技术有限公司
 * http://shein.com
 * All rights reserved.
 */
package com.gdy.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @author : gengdeyang
 * @date : 2019/2/14 10:07
 */
@Data
public class ExcelBean extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 1)
    private String age;

    @ExcelProperty(index = 2)
    private String email;

    private String emai11;
}
