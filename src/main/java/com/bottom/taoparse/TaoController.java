package com.bottom.taoparse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@RestController
public class TaoController {

    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/Users/test/chromedriver/chromedriver.exe";

    @GetMapping(value = "/taobao/login")
    public String LoginTaobao() {

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 120);

        String taobaoId = "fail!";
        String loginUrl = "https://login.taobao.com/member/login.jhtml";

        try {
            driver.get(loginUrl);
//            wait.until(presenceOfElementLocated(By.id("fm-login-id")));
//
//            webElement = wait.until(presenceOfElementLocated(By.id("fm-login-id")));
//            webElement.sendKeys("test");
//
//            webElement = wait.until(presenceOfElementLocated(By.id("fm-login-password")));
//            webElement.sendKeys("testpass");

//            webElement = driver.findElement(By.id("fm-login-id"));
//            webElement.sendKeys("test");
//
//            webElement = driver.findElement(By.id("fm-login-password"));
//            webElement.sendKeys("testpass");

//            wait.until(presenceOfElementLocated(By.className("fm-button"))).click();

//            Thread.sleep(10000);

            wait.until(presenceOfElementLocated(By.className("site-nav-user")));

            taobaoId = driver.findElement(By.className("site-nav-user")).findElement(By.tagName("a")).getText();

        } catch (Exception e) {
            e.printStackTrace();;
        } finally {
            driver.close();
        }

        return taobaoId;
    }
}
