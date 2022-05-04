package steps;

import Utilities.Driver;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public WebDriver wd;
    @Before
    public void nvigateToPVHsite(){
        wd= Driver.getWebDriver();
        wd.get("https://pvh-uat.apps.prod.nuxeo.io/nuxeo/");
    }
}
