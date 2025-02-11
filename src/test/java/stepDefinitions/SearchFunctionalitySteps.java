// ESKİ KOD

package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SearchFunctionalitySteps {
    WebDriver driver;

    List<WebElement> correctResults = new ArrayList<WebElement>();
//
//    @Given("User open the Trendyol website")
//    public void openWebsite() {
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\chromedriver-win64\\chromedriver.exe");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.get("https://www.trendyol.com/");
//        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
//        WebElement rejectCookieButton = driver.findElement(By.id("onetrust-reject-all-handler"));
//        rejectCookieButton.click();
//    }

//    @When("I search for {string}")
//    public void searchForProduct(String productName) {
//        // Search for a product called "kablosuz kulaklik" using the search bar.
//        WebElement searchBox = driver.findElement(By.className("V8wbcUhU"));
//        searchBox.sendKeys(productName);
//        searchBox.sendKeys(Keys.ENTER);
//    }

    @Then("I should see search results containing {string}")
    public void verifySearchResults(String productName) {
        //select results
        List<WebElement> results = driver.findElements(By.xpath("//div[contains(@class,'p-card-wrppr')]//div[@class='prdct-desc-cntnr']"));

        String[] productNameWords = productName.toLowerCase().split("\\s+");

        for (WebElement result : results) {
            int c = 0;
            for (String productNameWord : productNameWords){
                if (result.getText().toLowerCase().contains(productNameWord)) {
                    c = c + 1;
                }
            }
            if (c == productNameWords.length) {
                correctResults.add(result);
            }
        }

        if (!results.isEmpty()) {
            System.out.println(results.size() + " result found");
            if (!correctResults.isEmpty()) {
                System.out.println(correctResults.size() + " of them contains '" + productName + "'");
            } else {
                System.out.println("None of them contains '" + productName + "'");
            }
        } else {
            System.out.println("No results found");
        }
    }

}
