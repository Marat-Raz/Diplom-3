import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import pages.AuthorizationPage;
import pages.MainPage;
import usermodel.UserCredentials;

import static org.junit.Assert.assertTrue;
import static pages.CommonLocatorsUrls.ACCOUNT_LINK;

public class PersonalAccountPageTest extends StartTest {
    ValidatableResponse response;
    boolean resultOne, resultTwo;
    @Test
    @DisplayName("Переход в «Личный кабинет»")
    public void TransferToPersonalAccountTest(){
        response = userClient.createUser(user);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTextLink();
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.enterAuthorizationDataAndClickLoginEnterButton(UserCredentials.from(user));
        resultOne = mainPage.mainPageIsOpen();;
        mainPage.clickTextLink();
        resultTwo = driver.findElement(ACCOUNT_LINK).isDisplayed();

        assertTrue(resultOne);
        assertTrue(resultTwo);
    }
}
