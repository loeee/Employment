package com.just.emp.file;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * author ： 徐波
 */
public class FileUploads {

    public String fileUploads(MultipartFile file, HttpServletRequest request) throws IOException {
        //上传图片
        String path = ("/home/uploads");
        // 判断，该路径是否存在
        File fi = new File(path);
        if (!fi.exists()) {
            // 创建该文件夹
            fi.mkdirs();
        }
        String pathurl = null;
        String filename = file.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        if(filename != null && filename != ""){
            String uuid = UUID.randomUUID().toString().replace("-", "");
            filename = uuid+"_"+filename;
            // 完成文件上传
            file.transferTo(new File(path,filename));
            pathurl = "http://10.211.55.9:9204/uploads/"+filename;
        }

        return pathurl;
    }
}
