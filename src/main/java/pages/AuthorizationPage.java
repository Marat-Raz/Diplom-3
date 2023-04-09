package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import usermodel.UserCredentials;

import java.time.Duration;

import static pages.CommonLocatorsUrls.*;

public class AuthorizationPage {
    private final WebDriver driver;
     public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Заполняем поля формы авторизации - e-mail  и пароль Пользователя, нажать кнопку - Войти")
    public void enterAuthorizationDataAndClickLoginEnterButton(UserCredentials userCredentials) {
        (new WebDriverWait(driver, Duration.ofSeconds(3))).until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        driver.findElement(INPUT_EMAIL).sendKeys(userCredentials.getEmail());
        driver.findElement(INPUT_PASSWORD).sendKeys(userCredentials.getPassword());
        driver.findElement(ENTER_LINK).click();
     }
    public boolean loginButtonIsDisplay() {
        boolean isDisplayed = driver.findElement(LOGIN_BUTTON).isDisplayed();
        return isDisplayed;
    }
}
