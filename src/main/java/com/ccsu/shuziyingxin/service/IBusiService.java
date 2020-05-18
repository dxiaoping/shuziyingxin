package com.ccsu.shuziyingxin.service;

import com.ccsu.shuziyingxin.pojo.Business;
import com.ccsu.shuziyingxin.pojo.request.BusiParam;
import com.ccsu.shuziyingxin.pojo.response.BusiEditPage;
import com.ccsu.shuziyingxin.pojo.response.BusinessPage;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-22 16:59
 */
public interface IBusiService {
    boolean deleteBusiness(int busiId);
    Business saveBusiness(BusiParam busiParam);
    BusinessPage queryBusiness(int busiId);
    BusinessPage queryBusiness(String busiName);
    Business queryBusi(String busiName);
    BusiEditPage getOperatPage(Integer busiId);
    List<Business> queryBusinessByClass(int classId);
    List<Business> queryAllBusi();
}
