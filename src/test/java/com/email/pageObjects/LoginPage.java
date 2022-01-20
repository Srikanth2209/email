package com.email.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"login-username\"]")
    WebElement UserName;

    @FindBy(xpath = "//*[@id=\"login-signin\"]")
    WebElement UserNameNextButton;

    @FindBy(xpath = "//*[@id=\"login-passwd\"]")
    WebElement Password;

    @FindBy(xpath = "//*[@id=\"login-signin\"]")
    WebElement PasswordPageNextButton;

    @FindBy(xpath = "//*[@id=\"ysignout\"]/div[1]")
    WebElement profile;

    @FindBy(xpath = "//*[@id=\"ybarDialpadMenuBody\"]/ul/li[2]/a")
    WebElement mailBox;

    public boolean isElementsPresent( WebElement element)
    {
        if(element.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
    public void setUserName(String uname) {
        if (isElementsPresent(UserName)) {
            UserName.sendKeys(uname);
        } else {
            System.out.println("no element");
        }
    }
    public  void clickNextButton()
    {
        UserNameNextButton.click();
    }
    public void setPassword(String pwd){
            Password.sendKeys(pwd);
    }
    public  void clickPasswordNextButton()
    {
        PasswordPageNextButton.click();
    }
    public void clickProfile()
    {
        profile.click();
    }
    public void  clickOnMail(){
    mailBox.click();
    }


}
