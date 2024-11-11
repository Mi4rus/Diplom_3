package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    //    Адрес страницы
    private final static String STELLAR_LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    //    Кнопка-Логотип "Stellar Burgers"
    private final static By LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a > svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[2]/a/p");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    //    Поле "Email"
    private final static By EMAIL_INPUT_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    //    Поле "Пароль"
    private final static By PASSWORD_INPUT_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    //    Кнопка "Войти"
    private final static By ENTER_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    //    Кнопка "Зарегистрироваться"
    private final static By REGISTER_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");
    //    Кнопка "Восстановить пароль"
    private final static By FORGOT_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a");
    //    Ошибка "Некорректный пароль"
    private final static By PASSWORD_ERROR = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/p");
    //    Заголовок "Вход"
    private final static By HEADER_INPUT = By.xpath("//*[@id=\"root\"]/div/main/div/h2");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу")
    public LoginPage open() {
        driver.get(STELLAR_LOGIN_URL);
        return this;
    }

    @Step("Нажать на кнопку-логотип")
    public LoginPage clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Конструктор\"")
    public LoginPage clickConstructorButton() {
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Лента заказов\"")
    public LoginPage clickOrdersButton() {
        driver.findElement(ORDERS_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Личный кабинет\"")
    public LoginPage clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
        return this;
    }

    @Step("Ожидание появления кнопки \"Войти\"")
    public void waitForLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(ENTER_BUTTON));
    }

    @Step("Нажать на кнопку \"Войти\"")
    public LoginPage clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
        return this;
    }

    @Step("Заполнить поле \"Email\"")
    public LoginPage inputEmail() {
        driver.findElement(EMAIL_INPUT_FIELD).click();
        driver.findElement(EMAIL_INPUT_FIELD).sendKeys("1test-data1@yandex.ru");
        return this;
    }

    @Step("Заполнить поле \"Пароль\" некорректным значением")
    public LoginPage inputPasswordWithFiveChars() {
        driver.findElement(PASSWORD_INPUT_FIELD).click();
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys("12345");
        return this;
    }

    @Step("Заполнить поле \"Пароль\" корректным значением")
    public LoginPage inputPasswordWithSixChars() {
        driver.findElement(PASSWORD_INPUT_FIELD).click();
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys("123456");
        return this;
    }

    @Step("Ожидание появления ошибки \"Некорректный пароль\"")
    public boolean isPasswordErrorPresent() {
        return driver.findElement(PASSWORD_ERROR).isDisplayed();
    }

    @Step("Нажать на кнопку \"Зарегистрироваться\"")
    public LoginPage clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Восстановить пароль\"")
    public LoginPage clickForgotButton() {
        driver.findElement(FORGOT_BUTTON).click();
        return this;
    }

    // метод для получения текста заголовка страницы "Вход"
    public String headerInputText() {
        return driver.findElement(HEADER_INPUT).getText();
    }

    @Step("Ожидание появления окна \"Вход\"")
    public boolean isLoginPageWindowOpen() {
        return driver.findElement(FORGOT_BUTTON).isDisplayed();
    }
}
