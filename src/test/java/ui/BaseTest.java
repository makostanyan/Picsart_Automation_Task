package ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import ui.driver.DriverSetUp;
import ui.pages.LoginPage;
import ui.utility.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    protected SoftAssert softAssert = new SoftAssert();
    protected WebDriver driver;

    @BeforeMethod
    public void loginToApp() {
        driver =  DriverSetUp.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }

    @AfterMethod
    public void closeWindows() {
        DriverSetUp.closeDriver();
    }
}
