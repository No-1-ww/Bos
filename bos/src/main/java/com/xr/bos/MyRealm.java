package com.xr.bos;

import com.xr.bos.model.SyEmp;
import com.xr.bos.service.SyEmpService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SyEmpService syEmpService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        //获取当前登录的用户
        SyEmp syEmp  = (SyEmp)principal.getPrimaryPrincipal();
        //通过SimpleAuthenticationInfo做授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<Map<String, Object>> maps = syEmpService.queryRoles(syEmp);
        for (Map<String, Object> map : maps) {
            for (String s : map.keySet()) {
                Object o = map.get(s);
                System.out.println(o);
                //查询出所有的权限，然后添加权限
                simpleAuthorizationInfo.addRole(o.toString());

            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户输入的账号
        String empNo = (String) authenticationToken.getPrincipal();
        //通过账号进入数据库查找实体
        SyEmp syEmp = syEmpService.logIn(empNo);
        if(syEmp ==null){
            return null;
        }
        //通过SimpleAuthenticationInfo做身份处理
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(syEmp,syEmp.getPwd(),getName());
        if(syEmp.getDisabled().equals("0")){
            throw new AuthenticationException("该账号已经被禁用");
        }
        //返回身份处理对象

        return simpleAuthenticationInfo;
    }
}
