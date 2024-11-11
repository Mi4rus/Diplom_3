package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResetPasswordPage {
    //    Адрес страницы
    private final static String STELLAR_RESET_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/reset-password";
    //    Кнопка-Логотип "Stellar Burgers"
    private final static By LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a > svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[2]/a/p");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    //    Поле "Пароль"
    private final static By PASSWORD_INPUT_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    //    Поле "Введите код из письма"
    private final static By CODE_INPUT_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    //    Кнопка "Сохранить"
    private final static By SAVE_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    //    Кнопка "Войти"
    private final static By ENTER_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");

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
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys("123456");
        return this;
    }


    @Step("Заполнить поле \"Введите код из письма\"")
    public ResetPasswordPage inputPasswordWithSixChars() {
        driver.findElement(CODE_INPUT_FIELD).click();
        driver.findElement(CODE_INPUT_FIELD).sendKeys("12345678");
        return this;
    }

    @Step("Ожидание появления окна \"Восстановление пароля\"")
    public boolean isResetPasswordWindowOpen() {
        return driver.findElement(SAVE_BUTTON).isDisplayed();
    }
}
