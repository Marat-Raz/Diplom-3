package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import usermodel.User;

import static pages.CommonLocatorsUrls.*;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открытие страницы «Регистрация»")
    public void openRegistrationPage() {
        driver.get(REGISTRATION_PAGE_URL);
    }
    @Step("Заполнение полей ввода на странице «Регистрация»")
    public void enterRegistrationData(User user) {
        driver.findElement(INPUT_NAME).sendKeys(user.getName());
        driver.findElement(INPUT_EMAIL).sendKeys(user.getEmail());
        driver.findElement(INPUT_PASSWORD).sendKeys(user.getPassword());
    }
    @Step("Нажатие кнопки «Зарегистрироваться»")
    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }
    @Step("Нажатие ссылки «Войти»")
    public void clickEnterLink() {
        driver.findElement(ENTER_LINK).click();
    }
    public boolean errorTextIsDisplay() {
        return driver.findElement(ERROR_TEXT).isDisplayed();
    }
    @Step("Заполнение полей ввода на странице «Регистрация» и нажатие кнопки «Зарегистрироваться»")
    public void enterRegistrationDataAndClickRegisterButton(User user) {
        enterRegistrationData(user);
        clickRegisterButton();
    }
}
