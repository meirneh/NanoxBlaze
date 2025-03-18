package nanoxBlazeTests;

import nanoxBlazePageObjects.HomePage;
import nanoxBlazeUtils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginRegistrationTests extends BaseTest{

    @Test(description = "Verify that a user can log in successfully")
    public void tc01_validateSuccessfulLogin() {
        HomePage hp = new HomePage(driver);
        hp.goToLogin();
        hp.loginUser(ConfigReader.get("user.name"), ConfigReader.get("user.password"));
        String actualUsername = hp.getUserName();
        String expectedUserName = "Welcome " + ConfigReader.get("user.name");
        Assert.assertEquals(actualUsername,expectedUserName);
        hp.logoutUser();
    }

    @Test(description = "Verify that a user can log out successfully")
    public void tc02_validateLogoutFunctionality() {
        HomePage hp = new HomePage(driver);
        hp.goToLogin();
        hp.loginUser(ConfigReader.get("user.name"), ConfigReader.get("user.password"));
        hp.logoutUser();
        Assert.assertTrue(hp.isUserNameHidden(), "The user remains visible after logout");
        Assert.assertTrue(hp.isLoginTabVisible(), "The login button is not visible after logout.");
    }

    @Test(description = "Verify that registering an existing user shows an error")
    public void tc03_verifyExistingUserError() {
        HomePage hp = new HomePage(driver);
        hp.goToSignUp();
        hp.signUpUser(ConfigReader.get("user.name"), ConfigReader.get("user.password"));
        String expectedErrorMessage = "This user already exist.";
        String actualErrorMessage = hp.getSignUpErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        hp.closeSignUpWindow();
    }
}
