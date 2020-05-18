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
    List<Laboratory> queryAll();
    Laboratory queryOne(int id);
    Laboratory saveLaboratory(LaboratoryParam laboratoryParam);
}
