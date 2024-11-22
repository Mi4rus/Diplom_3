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
    private final static By LOGO_BUTTON = By.cssSelector("#root div > a > svg");
    //    Кнопка "Конструктор" в хедере
    private final static By HEADER_CONSTRUCTOR_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']");
    //    Кнопка "Лента Заказов"
    private final static By ORDERS_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Лента Заказов']");
    //    Кнопка "Личный Кабинет"
    private final static By ACCOUNT_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']");
    //    Кнопка "Отмена"
    private final static By CANCEL_BUTTON = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_secondary__3-tsA button_button_size_medium__3zxIa' and text() = 'Отмена']");
    //    Кнопка "Сохранить"
    private final static By SAVE_BUTTON = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Сохранить']");
    //    Кнопка "Профиль"
    private final static By PROFILE_BUTTON = By.xpath(".//a[@class = 'Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9' and text() = 'Профиль']");
    //    Кнопка "История заказов"
    private final static By LIST_ITEM_BUTTON = By.xpath(".//a[@class = 'Account_link__2ETsJ text text_type_main-medium text_color_inactive' and text() = 'История заказов']");
    //    Кнопка "Выход"
    private final static By EXIT_BUTTON = By.xpath(".//button[@class = 'Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text() = 'Выход']");

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
