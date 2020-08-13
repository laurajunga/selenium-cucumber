package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends BasePage {
    private static final String URL = "http://www.google.com";

    @FindBy(id = "hplogo")
    private WebElement logo;
    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;
    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;


    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get(URL);
        waitForElementToBeVisible(logo, 6);
    }

    public void typeIntoSearchBox(String text) {
        waitForElementToBeVisible(searchInput, 3).sendKeys(text);
    }

    public void pressSearchButton() {
        waitForElementToBeVisible(searchButton).click();
    }
}
