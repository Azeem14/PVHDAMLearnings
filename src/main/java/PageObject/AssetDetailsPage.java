package PageObject;

import Utilities.DataExtracter;
import Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetDetailsPage {
    public WebDriver wd;
    public AssetDetailsPage(){
        wd= Driver.getWebDriver();
        PageFactory.initElements(wd,this);
    }

    @FindBy(xpath = "//div[@class=\"tabs__header\"]/div")
    public WebElement assetPageTab;
    @FindBy(xpath="//div[@class=\"asset-page__details-basic\"]//div[(@class=\"p-0 pr-2 wordBreak col-lg-6 col-md-12\" or @class=\"p-0  pr-2 wordBreak col-lg-6 col-md-12\" )]/div[@class=\"row\"]/div[1]")
    public List<WebElement> assetDetailsHeader;
    @FindBy(xpath = "//div[@class=\"asset-page__details-basic\"]//div[(@class=\"p-0 pr-2 wordBreak col-lg-6 col-md-12\" or @class=\"p-0  pr-2 wordBreak col-lg-6 col-md-12\" )]/div[@class=\"row\"]/div[2]")
    public List<WebElement> assetDetailsValue;
    @FindBy(xpath = "//div[@class=\"tabs__body\"]//div[@class=\"tab__content\"]//table[@class=\"asset-page__formats\"]//th")
    public List<WebElement> downloadFormatHeader;
    @FindBy(xpath = "//div[@class=\"tabs__body\"]//div[@class=\"tab__content\"]//table[@class=\"asset-page__formats\"]//td")
    public List<WebElement> downloadFormatValue;
    @FindBy(xpath="//button[@title=\"Add To Collection\"]")
    public WebElement btnAddToCollection;
    @FindBy(xpath = "//li[@class=\"desktop-download\"]/button[@title=\"Download\"]")
    public WebElement btnDownloadAsset;
    @FindBy(xpath="//button[@title=\"Favorite\"]")
    public WebElement btnFavorite;
    @FindBy(xpath = "//button[@title=\"Share\"]")
    public WebElement btnShare;
    @FindBy(xpath = "//a[@class=\"breadcrumbs__crumb\"]")
    public WebElement lnkBacktoLibararyHome;

    public void validateDetails(){
        HashMap<String,String> assetDetails=new HashMap<>();
        for(int i=0;i<assetDetailsHeader.size();i++){
            assetDetails.put(assetDetailsHeader.get(i).getText(),assetDetailsValue.get(i).getText());
        }
        Element element=DataExtracter.getXMldata();
        for(Map.Entry<String,String> entry:assetDetails.entrySet()){
            String tagName=entry.getKey().replace(':',' ').replace(" ","");
            String value=entry.getValue();
            String expectedvalue=element.getElementsByTagName(tagName).item(0).getTextContent();
           boolean f= element.getElementsByTagName(tagName).item(0).getTextContent().equals(value);
            Assert.assertTrue("Failed in validating "+tagName+"Expected Value:"+expectedvalue+" ValueDispayed:"+value,f);
        }


    }

}
