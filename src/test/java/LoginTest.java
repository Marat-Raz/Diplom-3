import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import pages.AuthorizationPage;
import pages.MainPage;
import pages.PasswordRecoveryPage;
import pages.RegistrationPage;
import usermodel.UserCredentials;

import static org.junit.Assert.assertTrue;
import static pages.CommonLocatorsUrls.SET_BURGER_INDICATOR;

public class LoginTest extends StartTest{
    private RegistrationPage registrationPage;
    private AuthorizationPage authorizationPage;
    private MainPage mainPage;
    private PasswordRecoveryPage passwordRecoveryPage;
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
        result = driver.findElement(SET_BURGER_INDICATOR).isDisplayed();

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
        result = driver.findElement(SET_BURGER_INDICATOR).isDisplayed();

        assertTrue(result);
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void authorizationByRegistrationPageTest(){
        response = userClient.createUser(user);
        registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.clickEnterLink();
        authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterAuthorizationDataAndClickLoginEnterButton(UserCredentials.from(user));
        result = driver.findElement(SET_BURGER_INDICATOR).isDisplayed();

        assertTrue(result);
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void authorizationByPassPageTest(){
        response = userClient.createUser(user);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.openPasswordRecoveryPage();
        passwordRecoveryPage.clickEnterLink();
        authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterAuthorizationDataAndClickLoginEnterButton(UserCredentials.from(user));
        result = driver.findElement(SET_BURGER_INDICATOR).isDisplayed();

        assertTrue(result);
    }
}