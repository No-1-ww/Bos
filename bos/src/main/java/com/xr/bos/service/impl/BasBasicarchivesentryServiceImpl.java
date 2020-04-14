package com.xr.bos.service.impl;

import com.xr.bos.model.BasBasicarchivesentry;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.xr.bos.dao.BasBasicarchivesentryMapper;
import com.xr.bos.service.BasBasicarchivesentryService;

import java.util.List;
import java.util.Map;

@Service
public class BasBasicarchivesentryServiceImpl implements BasBasicarchivesentryService{

    @Resource
    private BasBasicarchivesentryMapper basBasicarchivesentryMapper;



    /**
     * 查询详情信息
     * @param id
     * @return
     */
    @Override
    public List<Map<String, Object>> findBasicarchivesentryAll(Integer id) {
        return basBasicarchivesentryMapper.findBasicarchivesentryAll(id);
    }

    /**
     * 根据登录的id查询登录人的单位名称
     *
     * @param
     * @return
     */
    @Override
    public List<Map<String, Object>> findEmpNameAndUntisNameByID(Integer ID) {
        return basBasicarchivesentryMapper.findEmpNameAndUntisNameByID(ID);
    }

    /**
     * 添加条目信息
     * @param basicarchivesentry
     * @return
     */
    @Override
    public int addBasicarchivesentry(BasBasicarchivesentry basicarchivesentry) {
        return basBasicarchivesentryMapper.addBasicarchivesentry(basicarchivesentry);
    }
}
