package com.ccsu.shuziyingxin.service;

import com.ccsu.shuziyingxin.common.ResultInfo;

import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-06-06 16:36
 */
public interface IVoiceService {
    List<String> parse(String str,boolean secondConfirm);
}
