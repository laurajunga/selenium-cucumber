package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchResultsPage extends BasePage {
    @FindBy(id = "hdtb-tls")
    private WebElement toolsButton;
    @FindBy(xpath = "//li[@id='qdr_d']/parent::ul/preceding-sibling::div[@class='hdtb-mn-hd'][1]")
    private WebElement anyTimeButton;
    @FindBy(id = "qdr_w")
    private WebElement pastWeekOption;
    @FindBy(xpath = "//a[h3]")
    private WebElement result;
    @FindBy(xpath = "//a[h3]")
    private List<WebElement> results;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void pageIsOpened() {
        waitForElementToBeVisible(toolsButton);
    }

    public void pressToolsButton() {
        waitForElementToBeVisible(toolsButton).click();
    }

    public void pressAnyTimeMenu() {
        waitForElementToBeVisible(anyTimeButton).click();
    }

    public void selectPastWeekOption() {
        waitForElementToBeVisible(pastWeekOption).click();
    }

    public void secondResultLeadsToPage(String domainName) {
        waitForElementToBeVisible(result, 5);
        results.get(1).click();
        waitForPageTitleToBeDifferent("Google Search", 7);
        String url = driver.getCurrentUrl();
        assertTrue(url.contains(domainName));
    }
}
