package com.gdy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@Controller
@Slf4j
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public Object hello() {
        return "hello world";
    }



    @RequestMapping("/down")
    @ResponseBody
    public String down( HttpServletResponse response){
        String fileName = "短信模版.txt";
        OutputStream os = null;
        String sb = "123344";
        try {
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(),"ISO8859-1"));
            byte[] bytes = sb.getBytes(StandardCharsets.UTF_8);

            os = response.getOutputStream();
            // 将字节流传入到响应流里,响应到浏览器
            os.write(bytes);
            os.close();
        } catch (Exception ex) {
            log.error("导出失败:", ex);
            throw new RuntimeException("导出失败");
        }finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException ioEx) {
                log.error("导出失败:", ioEx);
            }
        }

        return sb;
    }


}
