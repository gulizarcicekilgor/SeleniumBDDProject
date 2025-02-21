package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By searchBox = By.className("V8wbcUhU");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String product) {
        $sendKeys(searchBox, product, Keys.ENTER);
    }
}