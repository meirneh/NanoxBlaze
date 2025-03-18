package nanoxBlazePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends  BasePage {
    @FindBy(css = ".btn.btn-success.btn-lg")
    private WebElement addToCartButton;
    @FindBy(css = "#cartur")
    private WebElement cartTabButton;
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //Action
    public void addToCart() {
        explicitWaitClickable(addToCartButton);
        click(addToCartButton);
        alertOK();
    }

    public void goToCartPage() {
        click(cartTabButton);
    }

    //Verification
    public String getAddItemConfirmation() {
        return getAlertText();
    }

    public String getAddToCartConfirmationMessage() {
        return waitForAlertAndGetText(); // Asegurar que obtenemos el texto antes de cerrarlo
    }


}
