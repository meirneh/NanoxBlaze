package nanoxBlazePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderPage extends BasePage {
    @FindBy(css = "#name")
    private WebElement nameField;
    @FindBy(css = "#country")
    private WebElement countryField;
    @FindBy(css = "#city")
    private WebElement cityField;
    @FindBy(css = "#card")
    private WebElement creditCardField;
    @FindBy(css = "#month")
    private WebElement monthField;
    @FindBy(css = "#year")
    private WebElement yearField;
    @FindBy(css = "#orderModal .btn.btn-primary")
    private WebElement purchaseButton;
    @FindBy(css = "#orderModal .btn.btn-secondary")
    private WebElement closeButton;
    @FindBy(css = ".confirm.btn.btn-lg.btn-primary")
    private WebElement okButton;
    @FindBy(css = ".lead.text-muted ")
    private WebElement successMessage;
    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }

    //Action

    public void fillDateCreditCard(String month, String yearNumber) {
        explicitWaitVisible(monthField);
        fillText(monthField, month);
        explicitWaitVisible(yearField);
        fillText(yearField, yearNumber);
    }

    public void placeOrder(String name, String country, String city, String numberCard, String month, String yearNumber) {
        explicitWaitVisible(nameField);
        fillText(nameField, name);
        explicitWaitVisible(countryField);
        fillText(countryField, country);
        explicitWaitVisible(cityField);
        fillText(cityField, city);
        explicitWaitVisible(creditCardField);
        fillText(creditCardField,numberCard);
        fillDateCreditCard(month, yearNumber);
        explicitWaitVisible(purchaseButton);
        click(purchaseButton);
    }

    public void closePlaceOrder() {
        click(closeButton);
    }

    public void confirmPurchase() {
        explicitWaitVisible(okButton);
        click(okButton);
    }

    //Verify

    public String getSuccessMessage() {
        return getText(successMessage);
    }


}
