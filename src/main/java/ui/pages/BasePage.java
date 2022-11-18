package ui.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 1000);
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement webElement) {
        waitForElementToBeClickable(webElement);
        log.info("Clicking to " + webElement.getText());
        webElement.click();
    }

    protected void sendKeys(WebElement webElement, String text) {
        waitForVisibilityOfElement(webElement);
        log.info("Filling " + webElement.getText() + "field with text " + text);
        webElement.sendKeys(text);
    }

    protected boolean checkPageURL(String title) {
        log.info("Compering title with " + title);
        return driver.getCurrentUrl().contains(title);
    }
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> pageLoadCondition =
                driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        wait.until(pageLoadCondition);
    }

    public void waitForVisibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
