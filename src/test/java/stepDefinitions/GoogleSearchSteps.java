package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.GoogleHomePage;
import pageFactory.SearchResultsPage;
import util.exceptions.UnsupportedBrowserException;

import static util.Driver.*;

public class GoogleSearchSteps {
    GoogleHomePage googleHomePage;
    SearchResultsPage searchResultsPage;

    @Before
    public void createDriver() throws UnsupportedBrowserException {
        createDriverInstance().manage().window().maximize();;
    }

    @After
    public void tearDown() {
        killDriverInstance();
    }

    @Given("User is on Google main page")
    public void userIsOnGoogleMainPage() {
        googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.openHomePage();
    }

    @And("User types {string} in search box")
    public void userTypesInSearchBox(String searchKey) {
        googleHomePage.typeIntoSearchBox(searchKey);
    }

    @And("User presses Google Search button")
    public void userPressesGoogleSearchButton() {
        googleHomePage.pressSearchButton();
    }

    @And("Search results are displayed")
    public void searchResultsAreDisplayed() {
        searchResultsPage = new SearchResultsPage(getDriver());
        searchResultsPage.pageIsOpened();
    }

    @When("User taps Tools button")
    public void userTapsToolsButton() {
        searchResultsPage.pressToolsButton();
    }

    @And("User selects Past week option in time frame selection menu")
    public void userSelectsPastWeekOptionInTimeFrameSelectionMenu() {
        searchResultsPage.pressAnyTimeMenu();
        searchResultsPage.selectPastWeekOption();
    }

    @Then("Second result leads to {string} home page")
    public void secondResultLeadsToHomePage(String domainName) {
        searchResultsPage.secondResultLeadsToPage(domainName);
    }
}
