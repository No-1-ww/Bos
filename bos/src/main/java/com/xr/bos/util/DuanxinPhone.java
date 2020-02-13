package com.xr.bos.util;


import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class DuanxinPhone {

    public static final Integer code = getCode();

    public static Integer getCode() {
        //得到验证码
        //math：数学类
        int code = (int) (Math.random() * (999999 - 100000 + 1)) + 100000;
        //System.out.println(code);
        return code;
    }


    public static Integer fdx(String phone) {
        //发送短信
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FxRAtByd4qUwwy9K3Bb", "hB7KUx2LAuizKDuFWPe9ysNXXgTGq5");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "WWJTJJ学习平台");
        request.putQueryParameter("TemplateCode", "SMS_181500076");
        request.putQueryParameter("TemplateParam", "{'code':'" + code + "'}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }
}