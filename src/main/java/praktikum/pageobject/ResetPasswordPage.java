package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResetPasswordPage {

    private final String PASSWORD = "123456";
    private final String CODE_OF_EMAIL = "12345678";
    //    Адрес страницы
    private final static String STELLAR_RESET_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/reset-password";
    //    Кнопка-Логотип "Stellar Burgers"
    private final static By LOGO_BUTTON = By.cssSelector("#root div > a > svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Лента Заказов']");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']");
    //    Поле "Пароль"
    private final static By PASSWORD_INPUT_FIELD = By.xpath(".//div[@class = 'text input__textfield text_type_main-default' and @name = 'Введите новый пароль']");
    //    Поле "Введите код из письма"
    private final static By CODE_INPUT_FIELD = By.xpath("//fieldset[2]/div/div/input");
    //    Кнопка "Сохранить"
    private final static By SAVE_BUTTON = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Сохранить']");
    //    Кнопка "Войти"
    private final static By ENTER_BUTTON = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");

    private final WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу")
    public ResetPasswordPage open() {
        driver.get(STELLAR_RESET_PASSWORD_URL);
        return this;
    }

    @Step("Нажать на кнопку-логотип")
    public ResetPasswordPage clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Конструктор\"")
    public ResetPasswordPage clickConstructorButton() {
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Лента заказов\"")
    public ResetPasswordPage clickOrdersButton() {
        driver.findElement(ORDERS_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Личный кабинет\"")
    public ResetPasswordPage clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
        return this;
    }

    @Step("Ожидание появления кнопки \"Сохранить\"")
    public void waitForLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
    }

    @Step("Нажать на кнопку \"Войти\"")
    public ResetPasswordPage clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
        return this;
    }

    @Step("Заполнить поле \"Пароль\"")
    public ResetPasswordPage inputPassword() {
        driver.findElement(PASSWORD_INPUT_FIELD).click();
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(PASSWORD);
        return this;
    }


    @Step("Заполнить поле \"Введите код из письма\"")
    public ResetPasswordPage inputPasswordWithSixChars() {
        driver.findElement(CODE_INPUT_FIELD).click();
        driver.findElement(CODE_INPUT_FIELD).sendKeys(CODE_OF_EMAIL);
        return this;
    }

    @Step("Ожидание появления окна \"Восстановление пароля\"")
    public boolean isResetPasswordWindowOpen() {
        return driver.findElement(SAVE_BUTTON).isDisplayed();
    }
}
