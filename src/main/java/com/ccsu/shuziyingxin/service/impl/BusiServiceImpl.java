package com.ccsu.shuziyingxin.service.impl;

import com.ccsu.shuziyingxin.dao.BusiClassDao;
import com.ccsu.shuziyingxin.dao.BusiDao;
import com.ccsu.shuziyingxin.pojo.BusiClass;
import com.ccsu.shuziyingxin.pojo.Business;
import com.ccsu.shuziyingxin.pojo.Address;
import com.ccsu.shuziyingxin.pojo.response.BusiEditPage;
import com.ccsu.shuziyingxin.pojo.response.BusinessPage;
import com.ccsu.shuziyingxin.service.IBusiService;
import com.ccsu.shuziyingxin.pojo.request.BusiParam;
import com.ccsu.shuziyingxin.service.IAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-22 17:17
 */
@Service
public class BusiServiceImpl implements IBusiService {

    @Autowired
    BusiDao busiDao;

    @Autowired
    BusiClassDao classDao;

    @Autowired
    IAddrService addrService;

    @Override
    public boolean deleteBusiness(int busiId) {
        return busiDao.deleteBusi(busiId);
    }

    @Override
    public Business saveBusiness(BusiParam busiParam) {
        addrService.deleteRelation(busiParam.getBusiness().getBusiId());
        busiDao.deleteBusiRelation(busiParam.getBusiness().getBusiId());
        updateBusiness(busiParam);
        return busiParam.getBusiness();
    }

    @Transactional
    public boolean updateBusiness(BusiParam busiParam) {
        Business business = busiParam.getBusiness();
        if ("modify".equals(busiParam.getOptionType())) {
            busiDao.modifyBusi(business);
        } else {
            busiDao.createBusi(business);
        }
        updateRelationBusi(business.getBusiId(), busiParam.getRelationBusi());
        updateRelationAddr(business.getBusiId(), busiParam.getRelationAddr());
        return false;
    }

    @Override
    public BusinessPage queryBusiness(int busiId) {
        BusinessPage businessPage = new BusinessPage();
        List<Business> busiList = busiDao.queryBusiRela(busiId);
        Business business = busiDao.queryBusi(busiId);
        List<Address> addressList = addrService.queryAddrListByBusi(busiId);
        businessPage.setBusiness(business);
        businessPage.setAddressList(addressList);
        businessPage.setBusiList(busiList);
        return businessPage;
    }

    @Override
    public BusinessPage queryBusiness(String busiName) {
        BusinessPage businessPage = new BusinessPage();
        Business business = busiDao.queryBusiByName(busiName);
        int busiId = business.getBusiId();
        List<Business> busiList = busiDao.queryBusiRela(busiId);
        List<Address> addressList = addrService.queryAddrListByBusi(busiId);
        businessPage.setBusiness(business);
        businessPage.setAddressList(addressList);
        businessPage.setBusiList(busiList);
        return businessPage;
    }

    @Override
    public Business queryBusi(String busiName) {
        Business business = busiDao.queryBusiByName(busiName);
        return business;
    }

    @Override
    public BusiEditPage getOperatPage(Integer busiId) {
        BusiEditPage busiEditPage = new BusiEditPage();
        if (busiId != null) {
            List<Business> busiRefBean = busiDao.queryBusiRela(busiId);
            Business business = busiDao.queryBusi(busiId);
            List<Address> addrRefBean = addrService.queryAddrListByBusi(busiId);
            List<Integer> busiRefIdList = new ArrayList<>();
            List<Integer> addrRefIdList = new ArrayList<>();
            for (Business busi : busiRefBean) {
                busiRefIdList.add(busi.getBusiId());
            }
            for (Address addr : addrRefBean) {
                addrRefIdList.add(addr.getAddrId());
            }
            busiEditPage.setBusiness(business);
            busiEditPage.setAddrRefBean(addrRefBean);
            busiEditPage.setBusiRefBean(busiRefBean);
            busiEditPage.setAddrRefIdList(addrRefIdList);
            busiEditPage.setBusiRefIdList(busiRefIdList);
        }
        List<Business> businessList = busiDao.queryAllBusi();
        List<Address> addressList = addrService.queryAllAddr();
        List<BusiClass> classList = classDao.queryAllClass();

        busiEditPage.setBusinessList(businessList);
        busiEditPage.setAddressList(addressList);
        busiEditPage.setClassList(classList);
        return busiEditPage;
    }

    @Override
    public List<Business> queryBusinessByClass(int classId) {
        List<Business> businessList = busiDao.queryBusiByClass(classId);
        return businessList;
    }

    @Override
    public List<Business> queryAllBusi() {
        List<Business> businessList = busiDao.queryAllBusi();
        return businessList;
    }

    //    @Transactional
    public int updateRelationBusi(int busiId, List<Integer> list) {
        for (Integer busiId2 : list) {
            busiDao.addRelation(busiId, busiId2);
        }
        return 0;
    }

    //    @Transactional
    public int updateRelationAddr(int busiId, List<Integer> list) {

        for (Integer addrId : list) {
            addrService.addRelation(busiId, addrId);
        }
        return 0;
    }
}
