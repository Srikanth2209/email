package com.email.testCases;

import com.email.pageObjects.LoginPage;
import com.email.utilities.ReadProperties;
import com.opencsv.CSVWriter;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TC_Login_001 extends BaseClass {
    ReadProperties readProperties = new ReadProperties();

    @Test
    public void loginPage() throws InterruptedException {
        driver.get(readProperties.getApplicationUrl());
        logger.info("chrome invoked and navigated to Url");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(readProperties.email());
        logger.info("username entered");
        Thread.sleep(3000);
        loginPage.clickNextButton();
        logger.info("button clicked");
        Thread.sleep(5000);
        loginPage.setPassword(readProperties.password());
        loginPage.clickPasswordNextButton();
        getSenderNames(readProperties.names_path());
        getSubjects(readProperties.subject_path());
        getTime(readProperties.time_path());
        Write_Into_Csv();
    }
}