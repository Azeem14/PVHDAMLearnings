package PageObject;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class HomePageLibrary {
    public WebDriver wd;
    public HomePageLibrary(){
        wd= Driver.getWebDriver();
        PageFactory.initElements(wd,this);
    }
    @FindBy(xpath="//div[@class=\"brand desktop-view\"]/a[@class=\"brand__link\"]")
    public List<WebElement> lnkbrandBanner;
    @FindBy(xpath = "//div[@class=\"external-brand__inner\"]/a[@class=\"brand_subscribe_overlay\"]")
    public WebElement lnkGroups;

    public void selectBrandBanner(String brand){
        HashMap<String,WebElement> brandbanners=new HashMap<>();
        for(WebElement brands:lnkbrandBanner){
            System.out.println("brand name");
            String b= brands.getAttribute("href");
            brandbanners.put(b.substring(54),brands);
        }
        brandbanners.get(brand).click();

    }



}
