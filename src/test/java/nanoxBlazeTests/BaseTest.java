package nanoxBlazeTests;

import nanoxBlazeUtils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class BaseTest {
    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("app.url"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
