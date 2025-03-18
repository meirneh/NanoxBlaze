package nanoxBlazePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    @FindBy(css = ".btn.btn-success")
    private WebElement placeOrderButton;
    @FindBy(css = ".nav-item.active a")
    private WebElement homePageTabButton;
    @FindBy(css = "#tbodyid :nth-child(2)")
    private WebElement itemName;
    @FindBy(css = "#tbodyid :nth-child(4)  a")
    private WebElement deleteItemButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    //Actions
    public void placeOrder() {
        click(placeOrderButton);
    }

    public void goToHomePage() {
        click(homePageTabButton);
    }

    public void deleteItem() {
        click(deleteItemButton);
    }


    //Verifications

    public String getItem() {
        explicitWaitVisible(itemName);
        return getText(itemName);
    }





}
