package ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utility.TestDataReader;

public class SettingsPage extends BasePage {

    @FindBy(css = "[class*='user-avatar-inputLabel']")
    private WebElement uploadAvatarButton;

    @FindBy(id = "upload-avatar")
    private WebElement uploadAvatarInput;

    @FindBy(css = "[class*='user-avatar-description']")
    private WebElement avatarDescription;

    @FindBy(css = "[class*='account-saveChanges']")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//img[contains(@src,'data:image')]")
    public WebElement image;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSettingsPage() {
        waitForPageLoaded();
        return checkPageURL(TestDataReader.getTestData("settings_url"));
    }

    public void uploadAvatar() {
        waitForVisibilityOfElement(uploadAvatarButton);
        uploadAvatarInput.sendKeys("C:\\Users\\Mane_Kostanyan\\Desktop\\photo_upload.png");
    }

    public String getDescription() {
        waitForVisibilityOfElement(avatarDescription);
        return avatarDescription.getText();
    }

    public void clickOnSaveChanges() {
        waitForVisibilityOfElement(saveChangesButton);
        click(saveChangesButton);
    }

    public boolean isImageUploaded() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (boolean) (js.executeScript
                ("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                        image));
    }
}
