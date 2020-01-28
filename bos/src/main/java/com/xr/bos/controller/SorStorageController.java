package com.xr.bos.controller;

import com.xr.bos.model.SorStorage;
import com.xr.bos.model.SyEmp;
import com.xr.bos.model.SyUnits;
import com.xr.bos.service.SorStorageService;
import com.xr.bos.service.SyEmpService;
import com.xr.bos.service.SyUnitsService;
import com.xr.bos.util.DateFormat;
import com.xr.bos.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class SorStorageController {

    @Autowired
    private SyUnitsService syUnitsService;

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
        /*
        java.net.ConnectException: Connection refused: no further information
        连接异常
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
        }*/
        /*String key = "com.xr.bos.controller.SorStorageController.queryAll";
        Object list = redisTemplateUtil.getList(key);*/
        ModelAndView mv = new ModelAndView();
        List<Map<String,Object>>  sorStorages =  sorStorageService.queryAll();
        List<Map<String, Object>> acceptDate = DateFormat.formatMap(sorStorages, "acceptDate");
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
        //收货人：当前登录用户
        mv.addObject("shouHuo",syEmp.getEmpName());

        //查询出当前登录的用户的所在公司编号来查询

        SyUnits syUnits = syUnitsService.findID(syEmp.getEmpUnit());
        //再获得公司的名字，绑定至前台
        mv.addObject("SyUnitsName",syUnits.getName());

        String now = DateFormat.getNow();

        //当前的系统时间
        mv.addObject("now",now);

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
    public ModelAndView addStorage(SorStorage sorStorage,HttpSession session){
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssss"+sorStorage);
        SyEmp syEmp = (SyEmp) session.getAttribute("SyEmp");
        //得到当前登录的用户来设置收货人id
        Integer id = syEmp.getID();
        sorStorage.setDeliveryPerson(id);
        ModelAndView mv = queryAll();
        return mv;
    }

    /**
     * 根据值改变去数据库取得对应的公司名称
     */
    @RequestMapping(value = "/queryUnitsName",produces = "text/String;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String queryUnitsName(Integer EmpUnitID){
        //传进来的
        if(EmpUnitID==null){
            return "";
        }
        /*
            redis
          java.net.ConnectException: Connection refused: no further information

        String key = "com.xr.bos.controller.SorStorageController.queryUnitsName"+EmpUnitID;
        Object str = redisTemplateUtil.getString(key);
        if(str==null||str==""){
            //跟据单位ID查询
            SyUnits syUnits = syUnitsService.findID(EmpUnitID);
            String name = syUnits.getName();
            redisTemplateUtil.setString(key,str);
            return name;
        }else{
            return str.toString();
        }*/
        SyUnits syUnits = syUnitsService.findID(EmpUnitID);
        String name = syUnits.getName();
        return name;
    }


}
