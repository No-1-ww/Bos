package com.xr.bos.util;

import com.alibaba.druid.sql.visitor.functions.Now;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DateFormat {
    public static String format(String column){
        //第一个字段为列名
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = myFmt.format(column);
        return date;
    }
    //格式化Map集合中的事件
    public static Map<String,Object> format(Map<String,Object> map,String key){

        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd");
        String format = myFmt.format(map.get(key));
        map.put(key,format);
        return map;
    }
    public static List<Map<String,Object>> formatMap(List<Map<String,Object>> list,String key){
        //多表联查格式化时间，第二个参数为时间类型的键
        //resultMap中定义的时间列对应的列名字
        for (Map<String, Object> map : list) {
            for (String s : map.keySet()) {
                SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd");
                try{
                    Object o =  map.get(key);
                    //格式化后的时间
                    String format = myFmt.format(o);
                    //把原本的值替换成格式化后的时间
                    map.put(key,format);
                }catch (Exception e){
                    /*
                    如果把注释的代码放出来，还是会报错，但是我找不到原因
                    System.out.println("时间格式不对");
                    e.printStackTrace();*/
                }
            }
        }
        return list;
    }
    public static String getNow(){
        //得到系统当前时间
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd");
        //date为util包，而不是sql包
        String format = myFmt.format(new Date());
        return format;
    }
}
