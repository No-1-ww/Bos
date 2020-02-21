package com.xr.bos;

/*import com.github.pagehelper.PageHelper;*/
import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@SpringBootApplication
@MapperScan(value = "com.xr.bos.dao")
@ComponentScan("com.xr")
public class BosApplication {

    public static void main(String[] args) {
        SpringApplication.run(BosApplication.class, args);
    }
    /*
     * 注册MyBatis分页插件PageHelper
     */

}
