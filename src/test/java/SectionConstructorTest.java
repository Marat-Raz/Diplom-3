import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

public class SectionConstructorTest extends StartTest{
    private MainPage mainPage;
    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    public void menuSauceClickTest() {
        mainPage = new MainPage(driver);
        mainPage.waitOpenMainPage();
        mainPage.clickMenuSauce();

        assertEquals("Соусы",mainPage.getTextFromSelectedMenu());
    }
    @Test
    @DisplayName("Проверка перехода к разделу «Начинки»")
    public void menuFillingsClickTest() {
        mainPage = new MainPage(driver);
        mainPage.waitOpenMainPage();
        mainPage.clickMenuFillings();

        assertEquals("Начинки",mainPage.getTextFromSelectedMenu());
    }
    @Test
    @DisplayName("Проверка перехода к разделу «Булки»")
    public void menuBunClickTest() {
        mainPage = new MainPage(driver);
        mainPage.waitOpenMainPage();
        mainPage.clickMenuFillings();
        mainPage.clickMenuBun();

        assertEquals("Булки",mainPage.getTextFromSelectedMenu());
    }
}


