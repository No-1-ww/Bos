package com.xr.bos.controller;

import com.xr.bos.model.SorStorageDetails;
import com.xr.bos.service.SorStorageDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SorStorageDetailsController {

    @Autowired
    private SorStorageDetailsService sorStorageDetailsService;
    //自动装配订单详情的service

    /**
     * 查看入库明细
     * @return
     */
    @GetMapping("/storage_list")
    public ModelAndView queryStorAgelist(Integer stoID){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("/sortingManagement/storage_list");
        List<Map<String,Object>> list = new ArrayList<>();
        //定义一个中文状态
        String state2 = "";
        List<SorStorageDetails> sorStorageDetails = sorStorageDetailsService.queryByID(stoID);
        for (SorStorageDetails sorStorageDetail : sorStorageDetails) {
            int state = sorStorageDetail.getState();
            if(state==0){
                state2 = "初始入库";
            }else if (state==1){
                state2 = "中转入库";
            }else if (state==2){
                state2 = "二次入库";
            }else{
                state2 = "有货无单";
            }
            //由于绑定到前台的数据状态不能为0，1，2，3并且不宜修改数据库，故用该方法来绑定值
            Map<String,Object> map = new HashMap<>();
            map.put("SID",sorStorageDetail.getID());
            if(sorStorageDetail.getPackageID().equals("")||sorStorageDetail.getPackageID()==null){
                map.put("packageID","无");
            }else{
                map.put("packageID",sorStorageDetail.getPackageID());
            }
            map.put("weiGht",sorStorageDetail.getWeiGht());
            String abc = sorStorageDetail.getOutBoundID();
            System.out.println(abc.equals(""));
            if(sorStorageDetail.getOutBoundID().equals("")||sorStorageDetail.getOutBoundID()==null){
                map.put("outBoundID","无");
            }else{
                map.put("outBoundID",sorStorageDetail.getOutBoundID());
            }

            map.put("state",state2);
            list.add(map);

        }
        mv.addObject("sorStorageDetails",list);
        return mv;
    }

}
