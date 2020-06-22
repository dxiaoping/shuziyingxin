package com.ccsu.shuziyingxin.service.impl;

import com.ccsu.shuziyingxin.common.ResultInfo;
import com.ccsu.shuziyingxin.common.ResultMsg;
import com.ccsu.shuziyingxin.dao.SearchDao;
import com.ccsu.shuziyingxin.pojo.Search;
import com.ccsu.shuziyingxin.service.IBaseService;
import com.ccsu.shuziyingxin.service.IVoiceService;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-06-06 16:36
 */
@Service
public class VoiceServiceImpl implements IVoiceService {

    @Autowired
    IBaseService baseService;

    @Autowired
    SearchDao searchDao;

    @Override
    public List<Search> parse(String str,boolean secondConfirm) {

        List<Search> searchList = new ArrayList<>();
        Suggester suggester = new Suggester();
        List<String> searchStrList = searchDao.queryKeyName();
        for (String s : searchStrList) {
            suggester.addSentence(s);
        }
        List<String> keyList = suggester.suggest(str, 3);
        for (String s :keyList) {
            searchList.add(searchDao.querySearch(s));
        }

        System.out.println(keyList);   // 语义

        return searchList;
    }
}
