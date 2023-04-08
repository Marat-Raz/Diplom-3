import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainPageTest extends StartTest{
    private WebDriver driver;
    private MainPage mainPage;
/* @Before
 @Step("Запускаем браузер и создаем Главную страницу")
 public void setUp() {
     driver = BrowserCase.getBrowser("yandex");
     //driver = ChangeBrowser.getBrowser(CHROME_WDM); // chrome с зависимостью WebDriverManager
     //driver = ChangeBrowser.getBrowser(YANDEX); // проверен запуск Яндекс Браузера
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     MainPage mainPage = new MainPage(driver);
 }*/
    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    public void menuSauceIsActiveByClick() {

       // Assert.assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }

    }


