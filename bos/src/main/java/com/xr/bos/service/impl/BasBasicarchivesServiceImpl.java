package com.xr.bos.service.impl;

import com.xr.bos.dao.BasBasicarchivesMapper;
import com.xr.bos.model.BasBasicarchives;
import com.xr.bos.model.BasBasicarchivesentry;
import com.xr.bos.model.SyEmp;
import com.xr.bos.service.BasBasicarchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BasBasicarchivesServiceImpl implements BasBasicarchivesService {

    @Autowired
    private BasBasicarchivesMapper basBasicarchivesMapper;

    @Override
    public List<Map<String, Object>> findBasBasicarchivesAll() {
        return basBasicarchivesMapper.findBasBasicarchivesAll();
    }

    /**
     * 多条件查询
     * @return
     */
    @Override
    public List<Map<String, Object>> findBasBasicarchivesByBasicFileNumberAndName(BasBasicarchives basicarchives) {
        return basBasicarchivesMapper.findBasBasicarchivesByBasicFileNumberAndName(basicarchives);
    }

    /**
     * 操作人
     * @return
     */
    @Override
    public List<SyEmp> findOperatorID() {
        return basBasicarchivesMapper.findOperatorID();
    }

    /**
     * 查看有没有详情信息
     * @param basicarchives
     * @return
     */
    @Override
    public  String findBasicarchivesentryByOperatorId(BasBasicarchives basicarchives) {
        return basBasicarchivesMapper.findBasicarchivesentryByOperatorId(basicarchives);
    }

    /**
     * 根据登录的id查询登录人的单位名称
     *
     * @param
     * @return
     */
    @Override
    public List<Map<String, Object>> findEmpNameAndUntisNameByID(Integer ID) {
        return basBasicarchivesMapper.findEmpNameAndUntisNameByID(ID);
    }

    /**
     * 添加基础档案
     * @param basicarchives
     * @return
     */
    @Override
    public int addbasicArchives(BasBasicarchives basicarchives) {
        return basBasicarchivesMapper.addbasicArchives(basicarchives);
    }

    /**
     * 查询最大编号
     * @return
     */
    @Override
    public String findMaxBasicFileNumber() {
        return basBasicarchivesMapper.findMaxBasicFileNumber();
    }

    /**
     *编辑页面查询
     * @return
     */
    @Override
    public List<Map<String, Object>> findBasicarchivesById(Integer id) {
        return basBasicarchivesMapper.findBasicarchivesById(id);
    }

    /**
     * 修改
     * @param basicarchives
     * @return
     */
    @Override
    public int updateBasicarchivesById(BasBasicarchives basicarchives) {
        return basBasicarchivesMapper.updateBasicarchivesById(basicarchives);
    }
}
