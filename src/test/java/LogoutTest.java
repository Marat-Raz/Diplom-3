import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import pages.AuthorizationPage;
import pages.MainPage;
import usermodel.UserCredentials;

import static org.junit.Assert.assertTrue;
import static pages.CommonLocatorsUrls.EXIT_BUTTON;
import static pages.CommonLocatorsUrls.SET_BURGER_INDICATOR;

public class LogoutTest extends StartTest{
    @Test
    @DisplayName("Переход в «Личный кабинет»")
    public void TransferToPersonalAccountTest(){
        ValidatableResponse response = userClient.createUser(user);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTextLink();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterAuthorizationDataAndClickLoginEnterButton(UserCredentials.from(user));
        driver.findElement(SET_BURGER_INDICATOR).isDisplayed();
        mainPage.clickTextLink();
        driver.findElement(EXIT_BUTTON).click();
        boolean result = authorizationPage.loginButtonIsDisplay();

        assertTrue(result);

    }

}
