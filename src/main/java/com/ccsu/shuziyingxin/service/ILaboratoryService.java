package com.ccsu.shuziyingxin.service;

import com.ccsu.shuziyingxin.pojo.Laboratory;
import com.ccsu.shuziyingxin.pojo.request.LaboratoryParam;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-04-25 21:25
 */
public interface ILaboratoryService {
    List<Laboratory> queryAll(String organization);
    Laboratory queryOne(int id);
    Laboratory queryOne(String id);
    Laboratory saveLaboratory(LaboratoryParam laboratoryParam);
    boolean delete(int id);
}
