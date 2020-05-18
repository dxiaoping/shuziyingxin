package com.ccsu.shuziyingxin.dao;

import com.ccsu.shuziyingxin.pojo.WxInfo;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 10:16
 */
@Repository
public interface WxInfoDao {
    int insert(WxInfo wxInfo);
    int update(WxInfo wxInfo);
    WxInfo selectByOpenid(String openid);
}
