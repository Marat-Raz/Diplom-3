package pages;

import org.openqa.selenium.By;

public class CommonLocatorsUrls {
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String PASSWORD_RECOVERY_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    public static final By TEXT_LINK = By.xpath(".//p[text()='Личный Кабинет']");
    public static final By ACCOUNT_LINK = By.xpath(".//a[text()='Профиль']");
    public static final By EXIT_BUTTON = By.xpath(".//button[text()='Выход']");

    public static final By MENU_BUN = By.xpath(".//div[./span[text()='Булки']]");
    public static final By MENU_FILLINGS = By.xpath(".//div[./span[text()='Начинки']]");
    public static final By MENU_SAUCE = By.xpath(".//div[./span[text()='Соусы']]");
    public static final By CURRENT_MENU = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    public static final By ENTER_ACCOUNT_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");

    public static final By SET_BURGER_INDICATOR = By.xpath(".//*[text()='Соберите бургер']");
    public static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    public static final By INPUT_NAME = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");
    public static final By INPUT_EMAIL = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    public static final By INPUT_PASSWORD = By.xpath(".//div[./label[text()='Пароль']]/input[@name='Пароль']");
    public static final By REGISTER_BUTTON = By.xpath("//button[text()='Зарегистрироваться']");
    public static final By ENTER_LINK = By.xpath(".//*[text()='Войти']");
    public static final By ERROR_TEXT = By.xpath(".//p[text()='Некорректный пароль']"); //input__error text_type_main-default
    public static final By APPHEADER_CONSTRUCTOR = By.className("AppHeader_header__link__3D_hX");
    public static final By APPHEADER_STELLAR = By.className("AppHeader_header__logo__2D0X2");


}
