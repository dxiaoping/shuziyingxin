package com.ccsu.shuziyingxin.service.impl;

import com.ccsu.shuziyingxin.dao.LaboratoryDao;
import com.ccsu.shuziyingxin.dao.SearchDao;
import com.ccsu.shuziyingxin.pojo.Laboratory;
import com.ccsu.shuziyingxin.pojo.request.LaboratoryParam;
import com.ccsu.shuziyingxin.service.ILaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    SearchDao searchDao;
    @Override
    public List<Laboratory> queryAll(String organization) {
        List<Laboratory> laboratoryList = null;
        if (organization == null || "".equals(organization) || organization.equals("全部")) {
            laboratoryList = laboratoryDao.queryAll();
        }else {
            laboratoryList = laboratoryDao.queryByOrganization(organization);

        }
        return laboratoryList;
    }

    @Override
    public Laboratory queryOne(int id) {
        Laboratory laboratory = laboratoryDao.queryOne(id);
        return laboratory;
    }

    @Override
    public Laboratory queryOne(String name) {
        Laboratory laboratory = laboratoryDao.queryOneByName(name);
        return laboratory;
    }
    @Override
    public Laboratory saveLaboratory(LaboratoryParam laboratoryParam) {
        String type = laboratoryParam.getOptionType();
        Laboratory laboratory = laboratoryParam.getLaboratory();
        if ("modify".equals(type)) {
            laboratoryDao.update(laboratory);
        } else {
            laboratoryDao.insert(laboratory);
            searchDao.addKeyWord(laboratory.getName(),"laboratory");
        }
        return laboratory;
    }

    @Override
    public boolean delete(int id) {
        Laboratory laboratory = laboratoryDao.queryOne(id);
        laboratoryDao.delete(id);
        searchDao.delete(laboratory.getName());
        return false;
    }
}
