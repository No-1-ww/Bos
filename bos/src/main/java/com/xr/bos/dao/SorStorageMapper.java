package com.xr.bos.dao;

import com.xr.bos.model.SorStorage;
import com.xr.bos.model.SyEmp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SorStorageMapper {

     List<Map<String,Object>> queryAll(Map<String,Integer> map);

     Integer queryCount();

     /**
      * 根据条件查询
      */
     List<Map<String,Object>> queryWhere(Map<String,Object> map);

     /**
      * 根据条件查询总数
      * @param map
      * @return
      */
     Integer queryWhereCount(Map<String,Object> map);

     /**
      * 查询最大ID
      * @return
      */
     String queryMaxID();

     Integer addStorage(SorStorage sorStorage);


     Map<String,Object> queryByIDStorage(Integer ID);


     //修改
     Integer updateStorage(SorStorage sorStorage);


     //删除
     Integer deleteSorStorage(Integer ID);

}
