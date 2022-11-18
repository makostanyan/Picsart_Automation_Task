package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ui.utility.TestDataReader;

import java.util.ArrayList;

public class CreatePage extends BasePage {
    @FindBy(css = "[class*='createSearchContainer']")
    private WebElement designBanner;

    @FindBy(css = "[data-testid='create-search-button']")
    private WebElement newProjectButton;

    @FindBy(css = "[data-testid='create-upload-button']")
    private WebElement uploadButton;

    @FindBy(css = "[class*='rc-header-dev-profile-imageInnerHolder']")
    private WebElement userAvatar;

    @FindBy(css = "[data-test='settings-button']")
    private WebElement settings;

    public CreatePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDesignBannerDisplayed() {
        return designBanner.isDisplayed();
    }

    public boolean isNewProjectButtonDisplayed() {
        return newProjectButton.isDisplayed();
    }

    public boolean isUploadButton() {
        return uploadButton.isDisplayed();
    }

    public boolean isCretePage(){
        waitForPageLoaded();
        return checkPageURL(TestDataReader.getTestData("create_url"));
    }

    public void clickOnNewProject(){
        click(newProjectButton);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void clickOnSettings() {
        Actions actions = new Actions(driver);
        waitForVisibilityOfElement(userAvatar);
        actions.moveToElement(userAvatar).perform();
        waitForVisibilityOfElement(settings);
        actions.moveToElement(settings).click().perform();

    }
}
