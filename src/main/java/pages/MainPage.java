package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static pages.CommonLocatorsUrls.*;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на закладку «Булки»")
    public void clickMenuBun() {
        driver.findElement(MENU_BUN).click();
    }

    @Step("Нажать на закладку «Соусы»")
    public void clickMenuSauce() {
        driver.findElement(MENU_SAUCE).click();
    }

    @Step("Нажать на закладку «Начинки»")
    public void clickMenuFillings() {
        driver.findElement(MENU_FILLINGS).click();
    }
    @Step("Проверка отображения кнопки «Оформить заказ»")
    public boolean isMainPageOpen() {
        return driver.findElement(MAKE_ORDER_BUTTON).isDisplayed();
    }
    @Step("Проверка текста текущего меню")
    public String getTextFromSelectedMenu() {
        return driver.findElement(CURRENT_MENU).getText();
    }

    @Step("Нажать на кнопку «Войти в аккаунт»")
    public void clickLoginButton() {
        driver.findElement(ENTER_ACCOUNT_BUTTON).click();
    }
    @Step("Нажать на кнопку «Личный Кабинет»")
    public void clickTextLink() {
        driver.findElement(TEXT_LINK).click();
    }
}
