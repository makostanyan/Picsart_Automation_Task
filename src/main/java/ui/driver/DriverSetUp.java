package ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetUp {
    private static WebDriver driver;

    private DriverSetUp(){};

    public static WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser", "chrome")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
