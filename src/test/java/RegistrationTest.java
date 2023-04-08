import org.junit.Test;
import pages.AuthorizationPage;
import pages.RegistrationPage;
import usermodel.User;
import usermodel.UserGenerator;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends StartTest{
    private RegistrationPage registrationPage;
    private AuthorizationPage authorizationPage;
    boolean result;
/*    @Before
    public void setUp() {
        user = UserGenerator.getUser();
        userClient = new UserClient();
    }*/
    @Test
    public void correctRegistrationOnRegistrationPageTest() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.enterRegistrationDataAndClickRegisterButton(user);
        authorizationPage = new AuthorizationPage(driver);
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
