package hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        System.out.println("Setting up driver...");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        System.out.println("done");
//        if (driver != null) {
//            driver.quit();
//        }
    }
}