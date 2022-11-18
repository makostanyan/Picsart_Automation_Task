package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.utility.TestDataReader;

public class EditorPage extends BasePage {

    @FindBy(id = "layout-category")
    public WebElement layout;

    @FindBy(css = "[data-testid='hints-close']")
    private WebElement popUpCloseButton;

    public EditorPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLayoutDefault() {
        waitForVisibilityOfElement(layout);
        return layout.getAttribute("className").contains("active");
    }

    public boolean isEditorPage() {
        waitForPageLoaded();
        return checkPageURL(TestDataReader.getTestData("editor_url"));
    }

    public void closePopUp() {
        waitForVisibilityOfElement(popUpCloseButton);
        click(popUpCloseButton);
    }
}
