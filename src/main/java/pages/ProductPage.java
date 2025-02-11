package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.DoubleSummaryStatistics;

public class ProductPage extends BasePage {
    private final By productName = By.xpath("//h1[@class='pr-new-br']/span");
    private final By productPrice = By.xpath("//div[@class='pr-in-cn']//span[@class='prc-dsc']");
    private final By availability = By.xpath("//div[@class='product-button-container']//button[@class='add-to-basket']");
    private final By quantityInput = By.id("quantity");
    private final By addToCartButton = By.xpath("//div[@class='product-button-container']//button[@class='add-to-basket']");
    private final By sideBarBasket = By.xpath("//div[@class='side-bar-basket-body side-bar-basket-body-single-grid']");
    //private final By goToCartButton = By.xpath("//div[contains(@class,'redirect-to-basket')]");
    private final By goToCartButton = By.xpath("//a[@class='link account-basket']");
    private final By popUpButton = By.xpath("//button[contains(@class, 'onboarding-popover')]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return $getText(productName);
    }

    public boolean checkAvailability() {
        return $getText(availability).isEmpty();
    }

    public double getProductPrice() {
        String priceText = $getText(productPrice)
                .replace("TL", "")
                .replace(",", ".");
        return Double.parseDouble(priceText);
    }

    public void addToCart() {
        $click(addToCartButton);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
    }

    public void goToCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        $click(goToCartButton);
    }

    public void clickPopUpButton() {
        $click(popUpButton);
    }

    private void waitForCartSummary() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(sideBarBasket));
    }
}