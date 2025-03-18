package nanoxBlazePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class HomePage extends BasePage {
    @FindBy(css = "#login2")
    private  WebElement loginTabButton;
    @FindBy(css = "#loginusername")
    private WebElement loginUsernameField;
    @FindBy(css = "#loginpassword")
    private WebElement loginPasswordField;
    @FindBy(css = "#logInModal .btn.btn-primary")
    private WebElement loginButton;
    @FindBy(css = "#logout2")
    private WebElement logoutTabButton;
    @FindBy(css ="#signin2")
    private WebElement signUpTabButton;
    @FindBy(css ="#sign-username")
    private WebElement signUsernameField;
    @FindBy(css ="#sign-password")
    private WebElement signPasswordField;
    @FindBy(css ="#signInModal .btn.btn-primary")
    private WebElement signUpButton;
    @FindBy(css = "#signInModal .btn.btn-secondary")
    private WebElement closeSignUpButton;
    @FindBy(css = "#nameofuser")
    private WebElement nameOfUser;
    @FindBy(css = ".card-block")
    private List<WebElement> cardsBlocks;
    @FindBy(css = ".card-title")
    private List<WebElement> cardsTitles;

    public HomePage(WebDriver driver) {
        super(driver);
    }
//Actions
    public void goToLogin(){
        click(loginTabButton);
    }

    public void loginUser(String username, String password) {
        explicitWaitVisible(loginUsernameField);
        fillText(loginUsernameField, username);
        explicitWaitVisible(loginPasswordField);
        fillText(loginPasswordField, password);
        click(loginButton);
    }

    public void goToSignUp() {
        click(signUpTabButton);
    }

    public void signUpUser(String username, String password) {
        explicitWaitVisible(signUsernameField);
        fillText(signUsernameField, username);
        explicitWaitVisible(signPasswordField);
        fillText(signPasswordField, password);
        click(signUpButton);
    }

    public void closeSignUpWindow() {
        alertOK();
//        explicitWaitVisible(closeSignUpButton);
        click(closeSignUpButton);
    }

    public void logoutUser() {
        explicitWaitVisible(logoutTabButton);
        click(logoutTabButton);
    }



    public void selectItemCard(String name) {
        explicit_dynamic_List_Element_WaitVisible(cardsTitles, 1);
        for (WebElement el : cardsTitles){
            System.out.println("Item founded: " + name);
            if (el.getText().equalsIgnoreCase(name)) {
                click(el);
                System.out.println("Item selected: " + name);
                break;
            }
        }
    }
//Verify
    public String getHomePageUrl() {
        return getUrl(driver);
    }

    public String getUserName() {
        explicitWaitVisible(nameOfUser);
        return getText(nameOfUser);

    }

    public boolean isUserNameHidden() {
        return !nameOfUser.isDisplayed();
    }


    public boolean isLoginTabVisible() {
        explicitWaitVisible(loginTabButton);
        return loginTabButton.isDisplayed();
    }

    public String getSignUpErrorMessage() {
        return getAlertText();
    }

}
