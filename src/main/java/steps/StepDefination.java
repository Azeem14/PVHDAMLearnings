package steps;

import PageObject.HomePageLibrary;
import PageObject.WelcomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefination {
    public WelcomePage welcomePage;
    public HomePageLibrary homePageLibrary;

    @Given("^user is on PVH WecomePage$")
    public void verifyWelcomePage(){
    welcomePage=new WelcomePage();
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
        homePageLibrary=new HomePageLibrary();
      homePageLibrary.selectBrandBanner("ck");
    }

}
