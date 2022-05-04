package PageObject;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    public WebDriver wd;
    public WelcomePage(){
        wd= Driver.getWebDriver();
        PageFactory.initElements(wd,this);
    }
    @FindBy(xpath="//div[@class=\"idItem\"]/a")
    public WebElement singleSignOn;
    @FindBy(xpath="//div[@id=\"existing\"]")
    public WebElement loginUserNameAndPass;
    @FindBy(xpath="//a[@class=\"anchor_message\"]")
    public WebElement registerUser;
    @FindBy(xpath="//input[@id=\"username\"]")
    public WebElement txtUsername;
    @FindBy(xpath="//input[@id=\"password\"]")
    public WebElement txtPassword;
    @FindBy(xpath = "//input[@name=\"Submit\"]")
    public WebElement btnLogin;

public void verifyWelcomePage(){
    System.out.println(wd.getTitle());
}
    public void clickOnLoginWithUsername(){
        loginUserNameAndPass.click();
    }
    public void enterUserNamePassword(){
        txtUsername.sendKeys("CK_Consumer");
        txtPassword.sendKeys("welcome2pvh");
        btnLogin.click();

    }


}
