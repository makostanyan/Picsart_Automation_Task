package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utility.TestDataReader;

public class LoginPage extends BasePage {

    @FindBy(css = "[data-test='login-signup-button']")
    private WebElement loginOrSingUp;

    @FindBy(css = "[aria-label='Sign in with Email']")
    private WebElement continueWithEmailButton;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueButton;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "[class*='pa-uiLib-modal-closeIcon']")
    private WebElement closePopUpButton;

    @FindBy(css = "[class*='pa-uiLib-modal-modalContent']")
    private WebElement popUp;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void closePopUp(){
        waitForVisibilityOfElement(popUp);
        click(closePopUpButton);
    }
    public void login() {
        driver.get(TestDataReader.getTestData("home_url"));
        click(acceptCookies);
        click(loginOrSingUp);
        click(continueWithEmailButton);
        sendKeys(emailField, TestDataReader.getTestData("username"));
        click(continueButton);
        sendKeys(password, TestDataReader.getTestData("password"));
        click(loginButton);
        closePopUp();
    }
}
