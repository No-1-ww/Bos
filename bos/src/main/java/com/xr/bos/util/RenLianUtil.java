package com.xr.bos.util;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class RenLianUtil {
    public static String testRenLian(String img1,String img2){
        String str = "";
        String host = "http://facematch.sinosecu.com.cn";
        String path = "/api/faceliu.do";
        String method = "POST";
        String appcode = "0efd6ebd0a964d8086aae8b626ae1f13";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("img1", img1);
        bodys.put("img2", img2);


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            //System.out.println(response.toString());
            //获取response的body
            str = EntityUtils.toString(response.getEntity());
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    public static void main(String[] args){

        /*String s = Base64Util.GetImageStr("F:/谷歌浏览器下载/imgvideo (1).jpg");
        System.out.println(s);*/

        /*String ss = Base64Util.GetImageStr("F:/WIN_20191204_17_25_57_Pro.jpg");
        String sss= RenLianUtil.testRenLian(s, ss);*/

    }
}
