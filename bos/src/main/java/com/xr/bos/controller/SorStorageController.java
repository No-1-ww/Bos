package com.xr.bos.controller;

import com.xr.bos.model.SorStorage;
import com.xr.bos.model.SyEmp;
import com.xr.bos.service.SorStorageService;
import com.xr.bos.service.SyEmpService;
import com.xr.bos.util.DateFormat;
import com.xr.bos.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class SorStorageController {

    @Autowired
    private SorStorageService sorStorageService;

    @Autowired
    private SyEmpService syEmpService;

    @Autowired
    private  RedisTemplateUtil redisTemplateUtil;
    //自动装配redis工具类
    /**
     * 查询所有入库信息
     * @return
     */
    @RequestMapping("/sortingManagement/storage")
    public ModelAndView queryAll(){
        String key = "com.xr.bos.controller.SorStorageController.queryAll";
        Object list = redisTemplateUtil.getList(key);
        ModelAndView mv = new ModelAndView();
        List<Map<String,Object>> sorStorages = null;
        if(list==null||list.equals("")){
             sorStorages =  sorStorageService.queryAll();
            List<Map<String, Object>> acceptDate = DateFormat.formatMap(sorStorages, "acceptDate");
            redisTemplateUtil.setList(key,acceptDate);
        }else{
             sorStorages = (List)list;
        }
        mv.addObject("sorStorages",sorStorages);
        mv.setViewName("/sortingManagement/storage");
        return  mv;
    }
    /**
     *新增入库页面
     */
    @GetMapping("/storage_add")
    public ModelAndView addstoAge( HttpSession session){
        //业务流程：登录的用户就是默认的收货人并且不能修改，发货人自由选择

        ModelAndView mv =new ModelAndView();
        mv.setViewName("/sortingManagement/storage_add");
        //得到该数据库最大单号+1绑定至前台
        String stoID = sorStorageService.queryMaxID();
        int sto = Integer.parseInt(stoID) + 1;

        //得到当前登录的用户
        SyEmp syEmp = (SyEmp)session.getAttribute("SyEmp");

        //订单号
        mv.addObject("stoID",sto);

        //查询所有的员工
        List<SyEmp> select = syEmpService.querySyEmp(syEmp.getID());
        mv.addObject("SyEmps",select);
        return mv;
    }

    /**
     * 新增入库信息：
     * 如果包裹属于初始入库状态
     * 那么不需要填写合包号以及一些东西
     * @return
     */
    @RequestMapping("/addStorage")
    public ModelAndView addStorage(SorStorage sorStorage){

        ModelAndView mv = queryAll();
        return mv;
    }


}
