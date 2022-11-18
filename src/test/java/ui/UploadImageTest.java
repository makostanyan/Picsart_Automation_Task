package ui;

import org.testng.annotations.Test;
import ui.pages.CreatePage;
import ui.pages.SettingsPage;
import ui.utility.Retry;

public class UploadImageTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void uploadImage() {
        CreatePage createPage = new CreatePage(driver);
        createPage.clickOnSettings();

        SettingsPage settingsPage = new SettingsPage(driver);
        softAssert.assertTrue(settingsPage.isSettingsPage(), "This isn't Settings page");
        softAssert.assertEquals(settingsPage.getDescription(), "You can upload jpg. or png image files. Max size 2mb.",
                "Wrong description");

        settingsPage.uploadAvatar();
        settingsPage.clickOnSaveChanges();
        softAssert.assertTrue(settingsPage.isImageUploaded(), "Image isn't uploaded");
        softAssert.assertAll();
    }
}
