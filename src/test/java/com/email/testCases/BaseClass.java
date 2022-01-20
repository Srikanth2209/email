package com.email.testCases;

import com.opencsv.CSVWriter;
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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseClass {
    public static WebDriver driver;
    public static Logger logger;

    public List<String> name1=new ArrayList<>();
    public List<String> subject1 =new ArrayList<>();
    public List<String> time1 =new ArrayList<>();
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
        for (int i = 0; i < name.size(); i++) {
            WebElement ele1 = name.get(i);
            String names = ele1.getText();
            System.out.println(names);

            name1.add(names);
        }
    }
    public void getSubjects(String xpath) {
        List<WebElement> subject = driver.findElements(By.xpath(xpath));
        int size = subject.size();
        for (int i = 0; i < subject.size(); i++) {
            WebElement ele1 = subject.get(i);
            String subjects = ele1.getText();
            System.out.println(subjects);
            subject1.add(subjects);
        }
    }
    public void getTime(String xpath) {
        List<WebElement> times = driver.findElements(By.xpath(xpath));
        int size = times.size();
        for (int i = 0; i < times.size(); i++) {
            WebElement ele1 = times.get(i);
            String time = ele1.getText();
            System.out.println(time);
            time1.add(time);
        }
    }
    public void Write_Into_Csv() {
        String userDirectory = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        String filePaths = userDirectory + pathSeparator + "Configuration" + pathSeparator + "email";
        String filePath = filePaths + "." + "csv";

        {
            try {
                File file=new File(filePath);
                FileWriter writer=new FileWriter(file);
                CSVWriter write = new CSVWriter(writer);
                String set1[] = {"from", "Subject", "Time"};
                write.writeNext(set1);
                for (int i = 0; i< name1.size(); i++)
                {
                    String set[] = {name1.get(i),subject1.get(i),time1.get(i)};
                    write.writeNext(set);
                }
                write.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
