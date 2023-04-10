import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.AuthorizationPage;
import pages.MainPage;
import usermodel.UserCredentials;

import static org.junit.Assert.assertTrue;
import static pages.CommonLocatorsUrls.EXIT_BUTTON;

public class LogoutTest extends StartTest{
    @Test
    @DisplayName("Выход из аккаунта")
    public void TransferToPersonalAccountTest(){
        userClient.createUser(user);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTextLink();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterAuthorizationDataAndClickLoginEnterButton(UserCredentials.from(user));
        mainPage.mainPageIsOpen();
        mainPage.clickTextLink();
        driver.findElement(EXIT_BUTTON).click();
        boolean result = authorizationPage.loginButtonIsDisplay();

        assertTrue(result);

    }

}
