package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    //    Адрес страницы
    private final static String STELLAR_REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";
    //    Кнопка-Логотип "Stellar Burgers"
    private final static By LOGO_BUTTON = By.cssSelector("#root div > a > svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Лента Заказов']");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']");
    //    Поле "Имя"
    private final static By NAME_INPUT_FIELD = By.cssSelector(".Auth_fieldset__1QzWN:nth-child(1) input.text_type_main-default");
    //    Поле "Email"
    private final static By EMAIL_INPUT_FIELD = By.cssSelector(".Auth_fieldset__1QzWN:nth-child(2) input.text_type_main-default");
    //    Поле "Пароль"
    private final static By PASSWORD_INPUT_FIELD = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and @name = 'Пароль']");
    //    Кнопка "Войти"
    private final static By ENTER_BUTTON = By.xpath(".//a[@class = 'Auth_link__1fOlj' and text() = 'Войти']");
    //    Кнопка "Зарегистрироваться"
    private final static By REGISTER_BUTTON = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Зарегистрироваться']");
    //    Ошибка "Некорректный пароль"
    private final static By PASSWORD_ERROR = By.xpath(".//p[@class = 'input__error text_type_main-default' and text() = 'Некорректный пароль']");
    //    Ошибка "Такой пользователь уже существует"
    private final static By USER_ERROR = By.xpath(".//p[@class = 'input__error text_type_main-default' and text() = 'Такой пользователь уже существует']");

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу")
    public RegisterPage open() {
        driver.get(STELLAR_REGISTER_URL);
        return this;
    }

    @Step("Нажать на кнопку-логотип")
    public RegisterPage clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Конструктор\"")
    public RegisterPage clickConstructorButton() {
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Лента заказов\"")
    public RegisterPage clickOrdersButton() {
        driver.findElement(ORDERS_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Личный кабинет\"")
    public RegisterPage clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
        return this;
    }

    @Step("Ожидание появления кнопки \"Зарегистрироваться\"")
    public void waitForLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(REGISTER_BUTTON));
    }

    @Step("Нажать на кнопку \"Войти\"")
    public RegisterPage clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
        return this;
    }

    @Step("Заполнить поле \"Имя\"")
    public RegisterPage inputName(String name) {
        driver.findElement(NAME_INPUT_FIELD).click();
        driver.findElement(NAME_INPUT_FIELD).sendKeys(name);
        return this;
    }

    @Step("Заполнить поле \"Email\"")
    public RegisterPage inputEmail(String email) {
        driver.findElement(EMAIL_INPUT_FIELD).click();
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys(email);
        return this;
    }

    @Step("Заполнить поле \"Пароль\" некорректным значением")
    public RegisterPage inputPasswordWithFiveChars(String password) {
        driver.findElement(PASSWORD_INPUT_FIELD).click();
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
        return this;
    }

    @Step("Заполнить поле \"Пароль\" корректным значением")
    public RegisterPage inputPasswordWithSixChars(String password) {
        driver.findElement(PASSWORD_INPUT_FIELD).click();
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
        return this;
    }

    @Step("Ожидание появления ошибки \"Некорректный пароль\"")
    public boolean isPasswordErrorPresent() {
        return driver.findElement(PASSWORD_ERROR).isDisplayed();
    }

    @Step("Нажать на кнопку \"Зарегистрироваться\"")
    public RegisterPage clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
        return this;
    }

    @Step("Ожидание появления ошибки \"Такой пользователь уже существует\"")
    public String userErrorText() {
        return driver.findElement(USER_ERROR).getText();
    }
}
