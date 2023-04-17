import org.junit.Test;
import pages.AuthorizationPage;
import pages.RegistrationPage;
import usermodel.User;
import usermodel.UserGenerator;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends StartTest{
    private RegistrationPage registrationPage;
    boolean result;
    @Test
    public void correctRegistrationOnRegistrationPageTest() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.enterRegistrationDataAndClickRegisterButton(user);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        result = authorizationPage.loginButtonIsDisplay();

        assertTrue(result);
    }
    @Test
    public void inCorrectRegistrationOnRegistrationPageTest() {
        User wrongUser = UserGenerator.getUserWithIncorrectPassFive();
        registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.enterRegistrationDataAndClickRegisterButton(wrongUser);
        result = registrationPage.errorTextIsDisplay();

        assertTrue(result);
    }

}
