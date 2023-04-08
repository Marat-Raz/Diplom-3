package client;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BrowserCase {
    public static WebDriver getBrowser(String browserName) {
        switch (browserName) {

            case "yandex":
                System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandex\\yandexdriver.exe");
                ChromeOptions options = new ChromeOptions();
                return new ChromeDriver(options);


            case "chromeWebDriverManager":
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            case "chromeNoManager":
                ChromeOptions optionsCh = new ChromeOptions();
                optionsCh.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(optionsCh);

            default:
                throw new RuntimeException("Ваш браузер пока не поддерживается - только Хром и Яндекс!");
        }
    }
}
