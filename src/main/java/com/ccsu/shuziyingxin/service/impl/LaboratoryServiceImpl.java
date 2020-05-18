package com.ccsu.shuziyingxin.service.impl;

import com.ccsu.shuziyingxin.dao.LaboratoryDao;
import com.ccsu.shuziyingxin.pojo.Laboratory;
import com.ccsu.shuziyingxin.pojo.request.LaboratoryParam;
import com.ccsu.shuziyingxin.service.ILaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-25 21:43
 */
@Service
public class LaboratoryServiceImpl implements ILaboratoryService {

    @Autowired
    LaboratoryDao laboratoryDao;

    @Override
    public List<Laboratory> queryAll() {
        List<Laboratory> laboratoryList = laboratoryDao.queryAll();
        return laboratoryList;
    }

    @Override
    public Laboratory queryOne(int id) {
        Laboratory laboratory = laboratoryDao.queryOne(id);
        return laboratory;
    }

    @Override
    public Laboratory saveLaboratory(LaboratoryParam laboratoryParam) {
        String type = laboratoryParam.getOptionType();
        Laboratory laboratory = laboratoryParam.getLaboratory();
        if ("modify".equals(type)) {
            laboratoryDao.update(laboratory);
        }else {
            laboratoryDao.insert(laboratory);
        }
        return laboratory;
    }
}
