package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class CartPage extends BasePage {
    private final By productName = By.xpath("//p[@class='pb-item']");
    private final By totalPrice = By.id("totalAmount");
    private final By popUpButton = By.xpath("//div[@class='tooltip-content']/button");
    private final By productPrice = By.xpath("//div[@class='pb-basket-item-price']");
    private final By cartPrice = By.xpath("//ul[@class='pb-summary-box-prices']/li[1]/strong");
    private final By deleteLastProductBtn = By.xpath("//div[@class='pb-merchant-group'][last()]//button[@class='checkout-saving-remove-button']");


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

    public void clickPopUpButton() {
        $click(popUpButton);
    }
    public double convertToDouble (By price) {
        String priceText = $getText(price)
                .replace("TL", "")
                .replace(",", ".");
        return Double.parseDouble(priceText);
    }
    public boolean verifyPriceControl()
    {
        return convertToDouble(productPrice) == convertToDouble(cartPrice) ;

    }int i=0;
    public void deleteLastProduct(){
        $click(deleteLastProductBtn);


    }
}