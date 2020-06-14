package com.ccsu.shuziyingxin.util;

import com.ccsu.shuziyingxin.pojo.Jxjh;
import com.ccsu.shuziyingxin.pojo.request.LoginParam;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-03-07 17:42
 */
public class ReptileJxjh {

    public List<List<Jxjh>> getJxjhFromJwc(String cookie) throws Exception {
        String url = "http://jwcxxcx.ccsu.cn/jwxt/xsdPyfa.do?method=toJxjh";
        PhantomJSDriver newDriver = getDriver(cookie);
        List<List<Jxjh>> lists = new ArrayList<>();
//        为了测试方便只爬取两个学期的
        for (Integer term = 1; term <= 8; term++) {
//        for (Integer term = 1; term <= 8; term++) {
            newDriver.get(url);
            /**设置筛选条件并查询，对应于页面中的下拉选框和输入框*/
            WebElement search = newDriver.findElement(By.xpath("/html/body/div[3]/form/div/table/tbody/tr/td/input[3]"));
            WebElement field1 = newDriver.findElement(By.name("Field1"));//检索对象
            WebElement hh1 = newDriver.findElement(By.name("HH1"));//检索范围（>或<或=）
            WebElement svalue1 = newDriver.findElement(By.name("SValue1"));//检索对象值
            Select select = new Select(field1);
            select.selectByValue("kkxq");
            Select select1 = new Select(hh1);
            select1.selectByValue("=");
            svalue1.sendKeys(term.toString());
            search.click();
            Thread.sleep(1000l);
            lists.add(parseHtmlToList(newDriver));
            newDriver.navigate().refresh();
        }
        return lists;
//        System.out.println(newDriver.getPageSource());
    }

    public static PhantomJSDriver getDriver(String cookie) throws Exception {

        DesiredCapabilities dcaps = new DesiredCapabilities();
        //ssl证书支持
        dcaps.setCapability("acceptSslCerts", true);
        //截屏支持
        dcaps.setCapability("takesScreenshot", true);
        //css搜索支持
        dcaps.setCapability("cssSelectorsEnabled", true);
        dcaps.setCapability("phantomjs.page.settings.XSSAuditingEnabled", true);
        dcaps.setCapability("phantomjs.page.settings.webSecurityEnabled", false);
        dcaps.setCapability("phantomjs.page.settings.localToRemoteUrlAccessEnabled", true);
        dcaps.setCapability("phantomjs.page.settings.XSSAuditingEnabled", true);

        dcaps.setCapability("phantomjs.page.customHeaders.Cookie", cookie);
        dcaps.setCapability("phantomjs.page.settings.loadImages", false);
        //js支持
        dcaps.setJavascriptEnabled(true);
        //驱动支持
//        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY));
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\phantomjs.exe");
        //不显示驱动器日志
        String[] phantomArgs = new String[]{"--webdriver-loglevel=NONE"};
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
        //创建无界面浏览器对象
        PhantomJSDriver driver = new PhantomJSDriver(dcaps);
        Thread.sleep(2000l);
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);

        //设置说说详情数据页面的加载时间并跳转
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //获取要抓取的元素,并设置等待时间,超出抛异常
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //设置设置线程休眠时间等待页面加载完成
        Thread.sleep(2000L);
        return driver;
    }

    private List<Jxjh> parseHtmlToList(PhantomJSDriver driver) {
        List<WebElement> tr = driver.findElements(By.className("smartTr"));
        List<Jxjh> jxjhs = new ArrayList<>();
        for (int i = 0; i < tr.size(); i++) {
            List<WebElement> tds = tr.get(i).findElements(By.cssSelector("td"));
            for (WebElement td : tds) {
                System.out.print(td.getText() + " | ");
            }
            System.out.println();
            Jxjh jxjh = new Jxjh();
            String s = "";
            jxjh.setStartYear(Integer.valueOf("".equals(s = tds.get(1).getText().trim()) ? "0" : s));
            jxjh.setSpecialityName(tds.get(2).getText());
            jxjh.setSpecialityDirection(tds.get(3).getText());
            jxjh.setStartTerm(Integer.valueOf("".equals(s = tds.get(4).getText().trim()) ? "0" : s));
            jxjh.setCourseNo(tds.get(5).getText());
            jxjh.setCourseName(tds.get(6).getText());
            jxjh.setCourseNature(tds.get(7).getText());
            jxjh.setCourseAttr(tds.get(8).getText());
            jxjh.setCheckMode(tds.get(9).getText());
            jxjh.setCredit(Float.valueOf("".equals(s = tds.get(10).getText().trim()) ? "0" : s));
            jxjh.setTimeClass(Integer.valueOf("".equals(s = tds.get(11).getText().trim()) ? "0" : s));
            jxjh.setTime_week(Integer.valueOf("".equals(s = tds.get(12).getText().trim()) ? "0" : s));
            jxjh.setTimeClassTheory(Integer.valueOf("".equals(s = tds.get(13).getText().trim()) ? "0" : s));
            jxjh.setTimeClassPractice(Integer.valueOf("".equals(s = tds.get(14).getText().trim()) ? "0" : s));
            jxjh.setTimeClassLecture(Integer.valueOf("".equals(s = tds.get(15).getText().trim()) ? "0" : s));
            jxjh.setUnit(tds.get(16).getText());
            jxjh.setCourseClass(tds.get(17).getText());
            jxjhs.add(jxjh);
        }
        return jxjhs;
    }
}
