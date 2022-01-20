package com.email.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseClass {
    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void setup() {
        logger = Logger.getLogger("email");
        PropertyConfigurator.configure("Log4j.properties");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File Source = ts.getScreenshotAs(OutputType.FILE);
        File Target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(Source, Target);
        System.out.println("Screenshot taken");
    }

    public void getSenderNames(String xpath) {
        List<WebElement> name = driver.findElements(By.xpath(xpath));
        int size = name.size();
        //System.out.println("list size = " + size);
        for (int i = 0; i < name.size(); i++) {
            WebElement ele1 = name.get(i);
            String name1 = ele1.getText();
            System.out.println(name1);
        }
    }
    public void getSubjects(String xpath) {
        List<WebElement> name = driver.findElements(By.xpath(xpath));
        int size = name.size();
        //System.out.println("list size = " + size);
        for (int i = 0; i < name.size(); i++) {
            WebElement ele1 = name.get(i);
            String name1 = ele1.getText();
            System.out.println(name1);
        }
    }
    public void getTime(String xpath) {
        List<WebElement> name = driver.findElements(By.xpath(xpath));
        int size = name.size();
        System.out.println("list size = " + size);
        for (int i = 0; i < name.size(); i++) {
            WebElement ele1 = name.get(i);
            String name1 = ele1.getText();
            System.out.println(name1);
        }
    }
}
