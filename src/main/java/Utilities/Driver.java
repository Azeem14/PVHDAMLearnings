package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    private static WebDriver wd;

    public static WebDriver getWebDriver(){
        if(wd==null){
            WebDriverManager.chromedriver().setup();
            wd=new ChromeDriver();
            return wd;
        }
        else {
            return wd;
        }
        }

    }
