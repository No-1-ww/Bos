package com.xr.bos.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileUpload {
    public static String upload(MultipartFile file, HttpServletRequest req) throws IOException {
        // 判断文件是否为空，空则返回失败页面
        if (file.isEmpty()) {
            return "isNull";
        }
        // 获取文件存储路径（绝对路径）
        String path = req.getServletContext().getRealPath("upload");
        // 获取原文件名
        String fileName = String.valueOf(new Date().getTime() + "_" + file.getOriginalFilename());

        // 创建文件实例
        File filePath = new File(path, fileName);
        // 如果文件目录不存在，创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录" + filePath);
        }
        file.transferTo(filePath);
        return filePath.toString();
    }
    public static String getPath(HttpServletRequest req) throws IOException {
        return req.getServletContext().getRealPath("upload");
    }


}
