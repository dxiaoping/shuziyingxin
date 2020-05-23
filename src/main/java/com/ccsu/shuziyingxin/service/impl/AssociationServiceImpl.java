package com.ccsu.shuziyingxin.service.impl;

import com.ccsu.shuziyingxin.dao.AssociationDao;
import com.ccsu.shuziyingxin.pojo.Association;
import com.ccsu.shuziyingxin.service.IAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-18 15:40
 */
@Service
public class AssociationServiceImpl implements IAssociationService {

    @Autowired
    AssociationDao associationDao;

    @Override
    public boolean add(Association association) {
        associationDao.insertOne(association);
        return false;
    }

    @Override
    public boolean modify(Association association) {
        associationDao.update(association);
        return false;
    }

    @Override
    public Association queryOne(int associationId) {
        Association association = associationDao.queryOne(associationId);
        return association;
    }

    @Override
    public List<Association> queryAll(String organization) {
        List<Association> associationList = new ArrayList<>();
        if (organization == null || "".equals(organization) || organization.equals("全部")) {
            associationList = associationDao.queryAll();
        }else {
            associationList = associationDao.queryByOrganization(organization);
        }
        return associationList;
    }
}
