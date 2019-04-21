/**
 * Copyright (C), 2015-2019
 * FileName: UploadifyController
 * Author:   Administrator
 * Date:     2019/4/21 14:17
 * Description: tupian
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈tupian〉
 *
 * @author Administrator
 * @create 2019/4/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("upload")
public class UploadifyController {

    @RequestMapping("uploadify")
    @ResponseBody
    public String uploadify(MultipartFile sfile, HttpServletRequest request) throws IOException {
       System.out.println("来了");
        //获取原文件名称
        String fileName = sfile.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String folderPath = request.getSession().getServletContext().getRealPath("/")+
                "upload/";
        File file = new File(folderPath);
        //该目录是否已经存在
        if(!file.exists()){
            //创建文件夹
            file.mkdir();
        }
        String onlyFileName = sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'));
        FileOutputStream fos = new FileOutputStream(folderPath+onlyFileName);
        fos.write(sfile.getBytes());
        fos.flush();
        fos.close();
        System.out.println(file+"-----------------");
        return "asd";
    }

}
