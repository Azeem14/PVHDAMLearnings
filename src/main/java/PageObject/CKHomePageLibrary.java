package PageObject;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CKHomePageLibrary {
    public WebDriver wd;
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


}
