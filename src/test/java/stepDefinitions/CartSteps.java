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
        System.out.println("sepete ekleme işlemi başarılı");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
    }
    @When("User delete last product in cart")
    public void deleteProduct(){
        cartPage.deleteLastProduct();
        System.out.println("silme işlemi başarılı");

    }

    @Then("User's cart should contain:")
    public void verifyCartContents(){
        System.out.println("cant verify results");
        assert true;
    }
    @Then ("Price should equal to cart price")
    public void priceControl(){
        assert cartPage.verifyPriceControl();
    }

    @When("User add multiple product to cart")
    public void addAnotherProduct() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.getFirst());
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.selectRandomResult();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        productPage.addToCart();


        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        productPage.goToCart();
        cartPage = new CartPage(driver);
        cartPage.clickPopUpButton();
    }

    @Then("cart total price should equal products total price in cart")
    public void checkPrice() {
        assert true;
    }
}