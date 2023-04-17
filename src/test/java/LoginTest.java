import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import pages.AuthorizationPage;
import pages.MainPage;
import pages.PasswordRecoveryPage;
import pages.RegistrationPage;
import usermodel.UserCredentials;

import static org.junit.Assert.assertTrue;

public class LoginTest extends StartTest{
    private AuthorizationPage authorizationPage;
    private MainPage mainPage;
    ValidatableResponse response;
    boolean result;

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void authorizationByLoginButtonTest(){
        response = userClient.createUser(user);
        mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterAuthorizationDataAndClickLoginEnterButton(UserCredentials.from(user));
        result = mainPage.mainPageIsOpen();;

        assertTrue(result);
    }
    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void authorizationByTextLinkTest(){
        response = userClient.createUser(user);
        mainPage = new MainPage(driver);
        mainPage.clickTextLink();
        authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterAuthorizationDataAndClickLoginEnterButton(UserCredentials.from(user));
        result = mainPage.mainPageIsOpen();

        assertTrue(result);
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void authorizationByRegistrationPageTest(){
        response = userClient.createUser(user);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.clickEnterLink();
        authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterAuthorizationDataAndClickLoginEnterButton(UserCredentials.from(user));
        mainPage = new MainPage(driver);
        result = mainPage.mainPageIsOpen();;

        assertTrue(result);
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void authorizationByPassPageTest(){
        response = userClient.createUser(user);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.openPasswordRecoveryPage();
        passwordRecoveryPage.clickEnterLink();
        authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterAuthorizationDataAndClickLoginEnterButton(UserCredentials.from(user));
        mainPage = new MainPage(driver);
        result = mainPage.mainPageIsOpen();;

        assertTrue(result);
    }
}
