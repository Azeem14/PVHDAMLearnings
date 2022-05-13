package PageObject;

import Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CKHomePageLibrary {
    public WebDriver wd;
    public String filterOption;
//    List<WebElement> radioFilters;
//    public CKHomePageLibrary(String filterOption){
//        wd= Driver.getWebDriver();
//        PageFactory.initElements(wd,this);
//        this.filterOption=filterOption;
//       radioFilters= wd.findElements(By.xpath("//*[@id='main']/div/div[10]/div/div/div[1]/div[3]/div[7]/div/div[1]/span[text()="+filterOption+"]//parent::div//following-sibling::div/div/div/span[1]"));
//    }
    public CKHomePageLibrary(){
        wd= Driver.getWebDriver();
        PageFactory.initElements(wd,this);
    }
    @FindBy(xpath = "//button[@class=\"icon-button toggle-banner\"]")
    public WebElement btnToggleBanner;
    @FindBy(xpath="//button[@class=\"icon-button toggle-collection\"]")
    public WebElement btnToggleGlobalCollection;
    @FindBy(xpath="//input[@id=\"system-fulltext\"]")
    public WebElement txtSearch;
    @FindBy(xpath="//input[@id=\"dam-style\"]")
    public WebElement txtSearchStyleNumber;
    @FindBy(xpath="//div[@class=\"react-datepicker__month-container\"]")
    public WebElement dateContainer;
    @FindBy(xpath="//input[@id=\"toggle-switch\"]")
    public WebElement checkboxToggleExpiredAssets;
    @FindBy(xpath="//div[@class=\"filters__search\"]/input")
    public WebElement txtNarrowDownFilters;
    @FindBy(xpath="//div[@class=\"actions-menu\"]//div[@class=\"checkbox__input\"]")
    public WebElement checkboxSelectAll;
    @FindBy(xpath="//*[@id=\"ck_banner\"]/div[3]/div[3]/ul/li[3]/button")
    public WebElement btnFavorite;
    @FindBy(xpath="//input[@id=\"pvh_product_ColorCode_1\"]")
    public WebElement txtSearchByColor;
    @FindBy(xpath="//span[@id=\"l-view\"]")
    public WebElement lnkListView;
    @FindBy(xpath = "//*[@id=\"document-container\"]/div/div/div/h3/a")
    public List<WebElement> lnkAssetname;
    @FindBy(xpath="//*[@id=\"main\"]/div/div[10]/div/div/div[1]/div[3]/div[7]/div/div[1]/span")
    public List<WebElement> dropdownFilters;
//    @FindBy(xpath="//*[@id=\"main\"]/div/div[10]/div/div/div[1]/div[3]/div[7]/div/div[1]/span[text()=["+filterOption+"]//parent::div//following-sibling::div/div/div/span[1]")
//    public List<WebElement> radioFilters;
    //List<WebElement> radioFilters= wd.findElements(By.xpath("//*[@id='main']/div/div[10]/div/div/div[1]/div[3]/div[7]/div/div[1]/span[text()="+filterOption+"]//parent::div//following-sibling::div/div/div/span[1]"));







    public void showBannerAndHide(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        WebDriverWait wait=new WebDriverWait(wd,10000);
//        wait.until(ExpectedConditions.elementToBeClickable(btnToggleBanner));
        String status=btnToggleBanner.getAttribute("title");
        if(status.contains("SHOW")){
            btnToggleBanner.click();
        }

        btnToggleBanner.click();
       // Assert.assertTrue(btnToggleBanner.getAttribute("title").contains("HIDE"));
    }
    public void toggleGlobalconnection(){
        String status=btnToggleGlobalCollection.getAttribute("title");
        if(status.contains("HIDE")){
            btnToggleGlobalCollection.click();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectALLasset(){
        checkboxSelectAll.click();
    }

    public void selectListView(){
        lnkListView.click();
    }

    public void addtoFavorite(){
        selectALLasset();
        btnFavorite.click();
        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void toggleExpiredAssets(boolean toggle){
        Actions a= new Actions(wd);
        a.moveToElement(checkboxToggleExpiredAssets);
        a.perform();



        if(toggle==true&&!checkboxToggleExpiredAssets.isSelected()){
            checkboxToggleExpiredAssets.click();
        }
        if(toggle==false&&checkboxToggleExpiredAssets.isSelected()){
            checkboxToggleExpiredAssets.click();

        }
    }
    public void selectTheAsssetByName(String assetName){
        HashMap<String,WebElement> assetDetails=new HashMap<>();
        for(WebElement we:lnkAssetname){
            assetDetails.put(we.getText(),we);
        }
        assetDetails.get(assetName).click();
    }

    public void selectFilter(String filtername){
        HashMap<String,WebElement> filter=new HashMap<>();
        for(WebElement we:dropdownFilters)
        {
            filter.put(we.getText(),we);
        }
        Actions action=new Actions(wd);
        action.moveToElement(filter.get(filtername));
        action.perform();
        filter.get(filtername).click();
    }

    public void selectRadioFilterOption(String filterName,String filterOption){
        System.out.println("//*[@id=\"main\"]/div/div[10]/div/div/div[1]/div[3]/div[7]/div/div[1]/span[text()="+filterName+"]//parent::div//following-sibling::div/div/div/span[1]");
      List<WebElement> radioFilter= wd.findElements(By.xpath("//*[@id=\"main\"]/div/div[10]/div/div/div[1]/div[3]/div[7]/div/div[1]/span[text()="+filterName+"]//parent::div//following-sibling::div/div/div/span[1]"));
      HashMap<String,WebElement> radiofiltersoption=new HashMap<>();
      for (WebElement we:radioFilter){
          radiofiltersoption.put(we.getText(),we);
      }
      Actions action=new Actions(wd);
      action.moveToElement(radiofiltersoption.get(filterOption));
      action.perform();
        radiofiltersoption.get(filterOption).click();
      try{
      Thread.sleep(20000);}
      catch (Exception e){
          e.printStackTrace();
      }
    }



}
