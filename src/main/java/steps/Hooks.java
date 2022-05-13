package steps;

import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public WebDriver wd;
    @Before
    public void nvigateToPVHsite(){
        wd= Driver.getWebDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("https://pvh-uat.apps.prod.nuxeo.io/nuxeo/");
    }
    @After
    public void truncatebrowser(){
        wd.quit();
    }
}
