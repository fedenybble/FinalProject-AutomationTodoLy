package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Safari implements IBrowser{

    @Override
    public WebDriver create() {
        //System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        SafariDriver driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        return driver;
    }
}
