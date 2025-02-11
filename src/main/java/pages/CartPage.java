package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class CartPage extends BasePage {
    private final By productName = By.xpath("//p[@class='pb-item']");
    private final By cartItems = By.cssSelector(".cart-item");
    private final By itemPrices = By.cssSelector(".item-price");
    private final By totalPrice = By.id("totalAmount");
    private final By emptyCartMessage = By.id("emptyCartMessage");
    private final By popUpButton = By.xpath("//div[@class='tooltip-content']/button");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return $getText(productName);
    }

    public double getTotalPrice() {
        String totalText = $getText(totalPrice)
                .replace("₺", "")
                .replace(",", ".");
        return Double.parseDouble(totalText);
    }

    public void removeFirstItem() {
        $click(By.cssSelector(".remove-item:first-child"));
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartItems).isEmpty();
    }

    public List<Double> getAllItemPrices() {
        return driver.findElements(itemPrices).stream()
                .map(element -> element.getText()
                        .replace("₺", "")
                        .replace(",", "."))
                .map(Double::parseDouble)
                .toList();
    }

    public void clickPopUpButton() {
        $click(popUpButton);
    }
}