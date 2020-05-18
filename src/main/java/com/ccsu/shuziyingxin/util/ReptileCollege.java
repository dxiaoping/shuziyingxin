package com.ccsu.shuziyingxin.util;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-30 9:21
 */
public class ReptileCollege {
    public static final String INDEX_URL = "http://www.ccsu.cn/";

    public static Map<String, String> getCollegeUrlList() throws IOException {
        Map<String, String> map = new HashMap<>();
        Document doc = Jsoup.connect(INDEX_URL).get();
        Elements elements = doc.select("body > div.top_bg > div.navbox2 > div.nav2 > ul > li:nth-child(2) > ul > li:nth-child(3) > div > table > tbody > tr > td > a");
//        System.out.println(doc);
        for (Element element : elements) {
            String college = element.text();
            String url = element.attr("href");
            if (college.contains("院") && college.indexOf("研究") == -1)
                map.put(college, url);
//            System.out.print(college);
//            System.out.println(url);
        }
        return map;
    }

    public static Map<String, String> getCollegeDetail() throws IOException {
        Map<String, String> map = getCollegeUrlList();
        Map<String, String> collegeDetail = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Document doc = null;
            try {
                doc = Jsoup.connect(entry.getValue() + "/xygk/xyjj.htm").get();
            } catch (HttpStatusException e) {
                doc = Jsoup.connect(entry.getValue() + "/xygk/xygk.htm").get();
            }
            String collegeName = entry.getKey();
            System.out.println(entry.getKey() + "################");
            Elements elements = doc.select("div[class=main_conRC]," +
                    "div[class=main_right],div[id=vsb_content]," +
                    "span[id=ContentPlaceHolder2_lab_column]," +
                    "div[id=vsb_content_4]");
//            Elements elements = doc.select("p");
//            Elements elements = doc.select("body > div:nth-child(5) > div > div.main_con > div.main_conR > div");
            String detail = elements.text();
            System.out.println(detail);
            collegeDetail.put(collegeName,detail);
            System.out.println();
        }
        return collegeDetail;
    }
}
