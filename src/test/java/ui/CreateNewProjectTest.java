package ui;

import org.testng.annotations.Test;
import ui.pages.CreatePage;
import ui.pages.EditorPage;
import ui.utility.Retry;

public class CreateNewProjectTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void createProject() {
        CreatePage createPage = new CreatePage(driver);
        softAssert.assertTrue(createPage.isCretePage(), "This is not a Create page");
        softAssert.assertTrue(createPage.isDesignBannerDisplayed(), "Design banner isn't displayed");
        softAssert.assertTrue(createPage.isNewProjectButtonDisplayed(), "New project button isn't displayed");
        softAssert.assertTrue(createPage.isUploadButton(), "Upload isn't displayed");
        createPage.clickOnNewProject();

        EditorPage editorPage = new EditorPage(driver);
        editorPage.closePopUp();
        softAssert.assertTrue(editorPage.isEditorPage(), "This is not Editor page");
        softAssert.assertTrue(editorPage.isLayoutDefault(), "Layout isn't default");
        softAssert.assertAll();
    }
}
