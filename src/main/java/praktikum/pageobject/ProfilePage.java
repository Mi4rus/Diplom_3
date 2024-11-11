package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    //    Адрес страницы
    private final static String STELLAR_PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    //    Кнопка-Логотип "Stellar Burgers"
    private final static By LOGO_BUTTON = By.cssSelector("#root > div > header > nav > div > a > svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[2]/a/p");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");
    //    Поле "Имя"
    private final static By NAME_INPUT_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/ul/li[1]/div/div/input");
    //    Кнопка редактирования поля "Имя"
    private final static By NAME_EDIT_BUTTON = By.cssSelector("#root > div > main > div > div > div > ul > li:nth-child(1) > div > div > div > svg");
    //    Поле "Логин"
    private final static By EMAIL_INPUT_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/ul/li[2]/div/div/input");
    //    Кнопка редактирования поля "Логин"
    private final static By LOGIN_EDIT_BUTTON = By.cssSelector("#root > div > main > div > div > div > ul > li:nth-child(2) > div > div > div > svg");
    //    Поле "Пароль"
    private final static By PASSWORD_INPUT_FIELD = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/ul/li[3]/div/div/input");
    //    Кнопка редактирования поля "Пароль"
    private final static By PASSWORD_EDIT_BUTTON = By.cssSelector("#root > div > main > div > div > div > ul > li:nth-child(3) > div > div > div > svg");
    //    Кнопка "Отмена"
    private final static By CANCEL_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div/button[1]");
    //    Кнопка "Сохранить"
    private final static By SAVE_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/div/button[2]");
    //    Кнопка "Профиль"
    private final static By PROFILE_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[1]/a");
    //    Кнопка "История заказов"
    private final static By LIST_ITEM_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[2]/a");
    //    Кнопка "Выход"
    private final static By EXIT_BUTTON = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу")
    public ProfilePage open() {
        driver.get(STELLAR_PROFILE_URL);
        return this;
    }

    @Step("Нажать на кнопку-логотип")
    public ProfilePage clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Конструктор\"")
    public ProfilePage clickConstructorButton() {
        driver.findElement(HEADER_CONSTRUCTOR_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Лента заказов\"")
    public ProfilePage clickOrdersButton() {
        driver.findElement(ORDERS_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Личный кабинет\"")
    public ProfilePage clickAccountButton() {
        driver.findElement(ACCOUNT_BUTTON).click();
        return this;
    }

    @Step("Ожидание появления кнопки \"Сохранить\"")
    public void waitForLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
    }

    @Step("Нажать на кнопку \"Отмена\"")
    public ProfilePage clickEnterButton() {
        driver.findElement(CANCEL_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Сохранить\"")
    public ProfilePage clickRegisterButton() {
        driver.findElement(SAVE_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Профиль\"")
    public ProfilePage clickProfileButton() {
        driver.findElement(PROFILE_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"История заказов\"")
    public ProfilePage clickListItemButton() {
        driver.findElement(LIST_ITEM_BUTTON).click();
        return this;
    }

    @Step("Нажать на кнопку \"Выход\"")
    public ProfilePage clickExitButton() {
        driver.findElement(EXIT_BUTTON).click();
        return this;
    }

    @Step("Проверить наличие кнопки \"История заказов\"")
    public boolean isListItemButtonPresent() {
        return driver.findElement(LIST_ITEM_BUTTON).isDisplayed();
    }
}
