import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import usermodel.UserCredentials;

import static org.junit.Assert.assertTrue;
import static pages.CommonLocatorsUrls.APPHEADER_CONSTRUCTOR;
import static pages.CommonLocatorsUrls.APPHEADER_STELLAR;

public class SwitchingToTheConstructorTest extends StartTest{
    private boolean result;
    @Test
    @DisplayName("Переход из личного кабинета пользователя в конструктор по клику на «Конструктор»")
    public void clickToConstructorTest() {
        userClient.createUser(user);
        userClient.loginUser(UserCredentials.from(user));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTextLink();
        driver.findElement(APPHEADER_CONSTRUCTOR).click();
        result = mainPage.mainPageIsOpen();

        assertTrue(result);
    }
    @Test
    @DisplayName("Переход из личного кабинета пользователя в конструктор по клику на логотип Stellar Burgers")
    public void clickToStellarLogoTest() {
        userClient.createUser(user);
        userClient.loginUser(UserCredentials.from(user));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTextLink();
        driver.findElement(APPHEADER_STELLAR).click();
        result = mainPage.mainPageIsOpen();

        assertTrue(result);
    }
}
