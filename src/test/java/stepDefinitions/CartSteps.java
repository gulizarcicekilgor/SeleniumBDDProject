package stepDefinitions;
import io.cucumber.java.en.*;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.time.Duration;
import java.util.ArrayList;

import static hooks.Hooks.driver;
import static org.junit.Assert.*;

public class CartSteps {
    private ProductPage productPage;
    private CartPage cartPage;
    private double expectedTotal;



    @Given("User have searched for {string} and selected a product")
    public void userHaveSearchedAndSelectedAProduct(String searchTerm) {
        ProductSteps productSteps = new ProductSteps();
        productSteps.verifySearchResultsVisible(searchTerm);
        productSteps.selectFirstProduct();
        productPage = new ProductPage(driver);
    }

    @When("User add the product to cart")
    public void addProduct() {
        productPage.addToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        System.out.println("1.4");
        productPage.goToCart();
        cartPage = new CartPage(driver);
        cartPage.clickPopUpButton();
    }

    @Then("User's cart should contain:")
    public void verifyCartContents(){
        System.out.println("cant verify results");
        assert false;
    }
    /*
    public void verifyCartContents(io.cucumber.datatable.DataTable dataTable) {
        dataTable.asMaps().forEach(row -> {
            String element = row.get("Element");
            boolean shouldBeVisible = Boolean.parseBoolean(row.get("Visible"));
            boolean shouldVerifyContent = Boolean.parseBoolean(row.get("Verified"));

            switch (element) {
                case "Product name" -> {
                    assert (cartPage.getProductName().contains(productPage.getProductName()));
                }
                case "Product price" -> {
                    double cartPrice = cartPage.getAllItemPrices().getFirst();
                    assert productPage.getProductPrice() != cartPrice;
                }
            }
        });
    }
     */


/*

    @When("User add another product to cart")
    public void addAnotherProduct() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.getFirst());
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.selectRandomResult();
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        productPage.clickPopUpButton();
        productPage.addToCart();
    }

    @Then("cart total price should equal products total price in cart")
    public void checkPrice() {
        assert true;
    }

    @When("I remove the product from my cart")
    public void removeProduct() {
        cartPage.removeFirstItem();
    }

    @Then("my cart should show {string}")
    public void verifyCartStatus(String expectedStatus) {
        if (expectedStatus.equals("0 items")) {
            assertTrue(cartPage.isCartEmpty());
        }
    }

    @Given("I have added {int} items to my cart")
    public void addMultipleItems(int quantity) {
        productPage.addToCart();
        expectedTotal = productPage.getProductPrice() * quantity;
    }

    @Then("the total price should equal product price multiplied by {int}")
    public void verifyTotalPrice(int quantity) {
        double actualTotal = cartPage.getTotalPrice();
        double expected = productPage.getProductPrice() * quantity;
        assertEquals(expected, actualTotal, 0.001);
    }



    @Given("User have a product in my cart")
    public void addProductToCart() {
        productPage = new ProductPage(driver);
        productPage.addToCart();
    }

 */
}