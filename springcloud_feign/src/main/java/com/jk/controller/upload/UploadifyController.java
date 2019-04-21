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

import com.aliyun.oss.OSSClient;
import com.jk.utils.AliyunOSSClientUtil;
import com.jk.utils.OSSClientConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
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

    /*@RequestMapping("uploadify")
    @ResponseBody
    public String uploadify(String url){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String onlyFileName=sdf.format(new Date());
        File file2 = new File(url+"\\"+onlyFileName);
        System.out.println(url+"--------------");
        System.out.println(file2+"+++++++");
        //初始化OSSClient
        OSSClient ossClient= AliyunOSSClientUtil.getOSSClient();
        AliyunOSSClientUtil.uploadObject2OSS(ossClient, file2, OSSClientConstants.BACKET_NAME, OSSClientConstants.FOLDER);
        String urls = "https://three-group.oss-cn-beijing.aliyuncs.com/three_project_img/"+onlyFileName;
        return urls;


    }*/

}
