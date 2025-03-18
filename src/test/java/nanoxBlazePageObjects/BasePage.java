package nanoxBlazePageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    private JavascriptExecutor js;
    private Actions actions;
    private WebDriverWait wait;
    private int timeOutInSeconds = 50;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void fillText(WebElement el, String text) {
        el.clear();
        el.sendKeys(text);
    }

    public String getText(WebElement el) {
        return el.getText();
    }

    public void alertOK() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public String waitForAlertAndGetText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public void explicitWaitClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void explicitWaitVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void explicit_dynamic_List_Element_WaitVisible(List<WebElement> elements, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void click(WebElement el) {
        el.click();
    }

    public String getUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

}
