package stepDefinitions;
import io.cucumber.java.en.*;
import pages.*;
import java.util.ArrayList;

import static hooks.Hooks.driver;

public class ProductSteps {
    private ProductPage productPage;

    @Given("User have searched for {string} and results are visible")
    public void verifySearchResultsVisible(String searchTerm) {
        SearchSteps searchSteps = new SearchSteps();
        searchSteps.navigateToHomepage();
        searchSteps.searchForProduct(searchTerm);
        searchSteps.verifyResultsContainText(searchTerm);
    }

    @When("User select the first product from the results")
    public void selectFirstProduct() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.selectFirstResult();
        //switchToNewWindow
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        productPage = new ProductPage(driver);
        productPage.clickPopUpButton();
    }

    @Then("the product details page should display:")
    public void verifyProductDetails(io.cucumber.datatable.DataTable dataTable) {
        dataTable.asMaps().forEach(row -> {
            String element = row.get("Element");
            boolean shouldBeVisible = Boolean.parseBoolean(row.get("Visible"));

            switch (element) {
                case "Product name" -> {
                    assert productPage.getProductName() != null;
                }
                case "Product price" -> {
                    assert productPage.getProductPrice() > 0;
                }
                // Availability durumu için sepete ekle butonu var mı kontrolü yapıldı.
                case "Availability text" -> {
                    assert !productPage.checkAvailability();
                }
            }
        });
    }
}