package com.xr.bos;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.sun.org.apache.xerces.internal.util.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    @Bean
    public MyRealm getMyRealm(){
        return new MyRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getMyRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean webFilter(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        Map<String,String> filterChainMap = new LinkedHashMap<String,String>();
         //配置退出过滤器logout，由shiro实现
          //注意：改为调用Service层从数据库中获取数据
        filterChainMap.put("/logout","logout");
        //authc:所有url都必须认证通过才可以访问;
        //anon:所有url都都可以匿名访问，先配置anon再配置authc。

        filterChainMap.put("/login","anon");
        filterChainMap.put("/logIn","anon");
        filterChainMap.put("/queryExit","anon");
        filterChainMap.put("/logInDx","anon");

        //配置访问静态资源，由于前端html没有更改路径所以前面不需要加/static
        filterChainMap.put("/css/**","anon");
        filterChainMap.put("/fonts/**","anon");
        filterChainMap.put("/images/**","anon");
        filterChainMap.put("/js/**","anon");
        filterChainMap.put("/scss/**","anon");

        filterChainMap.put("/**", "authc");
        //3.设置默认登录的URL.
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }
}
