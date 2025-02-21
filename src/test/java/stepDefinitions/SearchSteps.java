package stepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.time.Duration;

import static hooks.Hooks.driver;

public class SearchSteps {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @Given("User on the homepage")
    public void navigateToHomepage() {
        homePage = new HomePage(driver);
        driver.get("https://www.trendyol.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(300));
        WebElement rejectCookieButton = driver.findElement(By.id("onetrust-reject-all-handler"));
        rejectCookieButton.click();
    }

    @When("User search for {string}")
    public void searchForProduct(String searchTerm) {
        homePage.searchForProduct(searchTerm);
    }

    @Then("the search results should be displayed")
    public void verifySearchResultsDisplayed() {
        searchResultsPage = new SearchResultsPage(driver);
        assert !searchResultsPage.getResults().isEmpty();
    }

    @Then("results should contain text {string}")
    public void verifyResultsContainText(String expectedText) {
        searchResultsPage = new SearchResultsPage(driver);
        assert !searchResultsPage.getCorrectResults(expectedText).isEmpty();
    }
}