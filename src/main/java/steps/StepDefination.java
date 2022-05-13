package steps;

import PageObject.AssetDetailsPage;
import PageObject.CKHomePageLibrary;
import PageObject.HomePageLibrary;
import PageObject.WelcomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefination {
    public WelcomePage welcomePage;
    public HomePageLibrary homePageLibrary;
    public CKHomePageLibrary ckHomePageLibrary;
    public AssetDetailsPage assetDetailsPage;
    public StepDefination(){
        welcomePage=new WelcomePage();
        homePageLibrary=new HomePageLibrary();
        ckHomePageLibrary=new CKHomePageLibrary();
    }

    @Given("^user is on PVH WecomePage$")
    public void verifyWelcomePage(){
    //welcomePage=new WelcomePage();
    welcomePage.verifyWelcomePage();
    }
    @Then("^Click Login with UserName and Password$")
    public void clickLoginWithUserNameAndPassword(){
        welcomePage.clickOnLoginWithUsername();
    }

    @And("^Enter the UserName,Password and Click Login$")
    public void enterUserNamepassword(){
        welcomePage.enterUserNamePassword();
    }

    @And("^Select Brand Banner$")
    public void selectBrandBanner(){
      //  homePageLibrary=new HomePageLibrary();
      homePageLibrary.selectBrandBanner("ck");
    }

    @And("^Check the Banner is active$")
    public void showtheBannerandhide(){
      //  ckHomePageLibrary=new CKHomePageLibrary();
        ckHomePageLibrary.showBannerAndHide();
    }
    @And("^Select the ListView$")
    public void selectListView()
    {
        ckHomePageLibrary.selectListView();
    }

    @And("^Hide the Global Collection$")
        public void toggleGlobalCollection(){
        ckHomePageLibrary.toggleGlobalconnection();
        }

        @And("^Select All asset and Add Favorite$")
    public void addAllAssetFavorite(){
        ckHomePageLibrary.addtoFavorite();
        }

        @And("^Toggle Include Expired Asset '(.*)'$")
    public void toggleIncludeExpiredAsset(boolean toggle){
        ckHomePageLibrary.toggleExpiredAssets(toggle);
        }
        @And("^Select the Asset With the name '(.*)'$")
        public void selectAssetfromGridView(String assetName){
        ckHomePageLibrary.selectTheAsssetByName(assetName);
        }
        @And("^Select the Filter '(.*)'$")
        public void selectFilter(String filtername){
        ckHomePageLibrary.selectFilter(filtername);
        }
        @And("^Select the radio '(.*)' filterOption under '(.*)' Filter$")
        public void selectFilterOption(String filterOption,String filterName){
        ckHomePageLibrary.selectRadioFilterOption(filterName,filterOption);
        }
        @And("^Validate the Asset details$")
        public void validateAssetDetails(){
        assetDetailsPage=new AssetDetailsPage();
        assetDetailsPage.validateDetails();
        }

}
