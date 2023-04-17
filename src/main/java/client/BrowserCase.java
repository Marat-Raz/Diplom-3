package client;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BrowserCase {
    public static WebDriver getBrowser(String browserName) {
        switch (browserName) {

            case "yandex":
                System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();
                return new ChromeDriver(options);

            case "chromeWebDriverManager":
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

/*            case "chromeNoManager":
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                return new ChromeDriver();*/

            default:
                throw new RuntimeException("Ваш браузер пока не поддерживается - только Хром и Яндекс!");
        }
    }
}
