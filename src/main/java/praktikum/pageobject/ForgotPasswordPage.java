package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {

    private final String EMAIL = "1test-data1@yandex.ru";
    //    Адрес страницы
    private final static String STELLAR_FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    //    Кнопка-Логотип "Stellar Burgers"
    private final static By LOGO_BUTTON = By.cssSelector("#root div > a > svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Лента Заказов']");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']");
    //    Поле "Email"
    private final static By EMAIL_INPUT_FIELD = By.xpath(".//input[@class = 'text input__textfield text_type_main-default']");
    //    Кнопка "Войти"
    private final static By ENTER_BUTTON = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");
    //    Кнопка "Восстановить"
    private final static By RECOVER_BUTTON = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Восстановить']");

    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу")
    public ForgotPasswordPage open() {
        driver.get(STELLAR_FORGOT_PASSWORD_URL);
        return this;
    }

    @Step("Нажать на кнопку-логотип")
    public ForgotPasswordPage clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Конструктор\"")
    public ForgotPasswordPage clickConstructorButton() {
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Лента заказов\"")
    public ForgotPasswordPage clickOrdersButton() {
        driver.findElement(ORDERS_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Личный кабинет\"")
    public ForgotPasswordPage clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
        return this;
    }

    @Step("Ожидание появления кнопки \"Восстановить\"")
    public void waitForLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(RECOVER_BUTTON));
    }

    @Step("Нажать на кнопку \"Войти\"")
    public ForgotPasswordPage clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
        return this;
    }

    @Step("Заполнить поле \"Email\"")
    public ForgotPasswordPage inputEmail() {
        driver.findElement(EMAIL_INPUT_FIELD).click();
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys(EMAIL);
        return this;
    }

    @Step("Нажать на кнопку \"Восстановить\"")
    public ForgotPasswordPage clickRegisterButton() {
        driver.findElement(RECOVER_BUTTON).click();
        return this;
    }
}
