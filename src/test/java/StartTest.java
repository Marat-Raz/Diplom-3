import client.BrowserCase;
import client.UserClient;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import usermodel.User;
import usermodel.UserCredentials;
import usermodel.UserGenerator;

import javax.swing.*;
import java.time.Duration;

import static pages.CommonLocatorsUrls.MAIN_PAGE_URL;

public class StartTest {
    User user;
    String accessToken;
    WebDriver driver;
    UserClient userClient;
    @BeforeClass
    public static void globalSetUp() {
        RestAssured.filters(
                new RequestLoggingFilter(), new ResponseLoggingFilter(),
                new AllureRestAssured());
    }
    @Before
    @Step("Запуск браузера и создание профиля пользователя")
    public void setUp() {

        String[] options = {"Google Chrome", "YandexBrowser"};
        int x = JOptionPane.showOptionDialog(null, "Select the browser in which the tests will be performed",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);
        if (x == 0 ) {
            driver = BrowserCase.getBrowser("chromeWebDriverManager");
        } else if (x == 1) {
            driver = BrowserCase.getBrowser("yandex");

        }

        driver.get(MAIN_PAGE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        user = UserGenerator.getUser();
        userClient = new UserClient();
    }

    @After
    @Step("Удаление профиля пользователя и закрытие браузера")
    public void tearDown() {
        driver.quit();
        ValidatableResponse loginResponse = userClient.loginUser(UserCredentials.from(user));
        accessToken = loginResponse.extract().path("accessToken");
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
    }
}
