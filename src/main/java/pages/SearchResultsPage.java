package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchResultsPage extends BasePage {

    String resultXPath = "//div[contains(@class,'p-card-wrppr')]//div[@class='prdct-desc-cntnr']";

    private final By results = By.xpath("//div[contains(@class,'p-card-wrppr')]//div[@class='prdct-desc-cntnr']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getResults() {
        return driver.findElements(results);
    }

    public List<WebElement> correctResults = new ArrayList<WebElement>();

    public List<WebElement> getCorrectResults(String expectedText) {
        //split expected text to words by space char using regex
        String[] expectedTextWords = expectedText.toLowerCase().split("\\s+");
        for (WebElement result : getResults()) {
            int c = 0;
            for (String productNameWord : expectedTextWords){
                if (result.getText().toLowerCase().contains(productNameWord)) {
                    c = c + 1;
                }
            }
            if (c == expectedTextWords.length) {
                correctResults.add(result);
            }
        }
        return correctResults;
    }

    public void selectFirstResult() {
        $click(results);
    }

    public void selectRandomResult() {
        List<WebElement> allResults = driver.findElements(results);

        if (allResults.isEmpty()) {
            throw new RuntimeException("No search results found!");
        }

        // Generate a random index
        Random random = new Random();
        int randomIndex = random.nextInt(allResults.size());

        // Click the randomly selected result
        allResults.get(randomIndex).click();
    }
}