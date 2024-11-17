package praktikum.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorMainPage {

     private final WebDriver driver;
     private final static String STELLAR_URL = "https://stellarburgers.nomoreparties.site/";

     public ConstructorMainPage(WebDriver driver) {
          this.driver = driver;
     }
     private final static By LOGO_BUTTON = By.cssSelector("#root div > a > svg");
     private static final By ACCOUNT_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']");
     private static final By LOGIN_ACCOUNT_BUTTON = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text() = 'Войти в аккаунт']");
     private static final By CONSTRUCTOR_HEADER_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']");
     private static final By ORDER_FEED_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Лента Заказов']");
     private static final By BUNS_BUTTON = By.cssSelector(".tab_tab__1SPyG:nth-child(1)");
     private static final By SAUCES_BUTTON = By.cssSelector(".tab_tab__1SPyG:nth-child(2)");
     private static final By FILLINGS_BUTTON = By.cssSelector(".tab_tab__1SPyG:nth-child(3)");
     private final static By MENU = By.xpath(".//div[@class = 'BurgerIngredients_ingredients__menuContainer__Xu3Mo']");
     private final static By SEND_ORDER = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text() = 'Оформить заказ']");

     @Step("Открыть страницу")
     public ConstructorMainPage open() {
          driver.get(STELLAR_URL);
          return this;
     }

     @Step("Нажать на кнопку \"Личный кабинет\"")
     public ConstructorMainPage clickAccountButton() {
          driver.findElement(ACCOUNT_BUTTON).click();
          return this;
     }

     @Step("Нажать на кнопку \"Войти в аккаунт\"")
     public ConstructorMainPage clickLoginAccountButton() {
          driver.findElement(LOGIN_ACCOUNT_BUTTON).click();
          return this;
     }

     @Step("Нажать на раздел \"Соусы\"")
     public ConstructorMainPage clickSaucesButton() {
          driver.findElement(SAUCES_BUTTON).click();
          return this;
     }

     @Step("Нажать на раздел \"Начинки\"")
     public ConstructorMainPage clickFillingsButton() {
          driver.findElement(FILLINGS_BUTTON).click();
          return this;
     }

     @Step("Нажать на раздел \"Булки\"")
     public ConstructorMainPage clickBunsButton() {
          driver.findElement(BUNS_BUTTON).click();
          return this;
     }

     @Step("Ожидание загрузки меню ингридиентов")
     public void waitForLoadPage() {
          new WebDriverWait(driver, Duration.ofSeconds(10))
                  .until(ExpectedConditions.visibilityOfElementLocated(MENU));
     }

     @Step("Проверка наличия кнопки Оформить заказ")
     public boolean isSendOrderButtonPresent() {
          return driver.findElement(SEND_ORDER).isDisplayed();
     }

     @Step("Ожидание загрузки соусов")
     public void waitClickSauces() {
          new WebDriverWait(driver, Duration.ofSeconds(10))
                  .until(ExpectedConditions.visibilityOfElementLocated(SAUCES_BUTTON));
     }
     @Step("Ожидание загрузки булок")
     public void waitClickBuns() {
          new WebDriverWait(driver, Duration.ofSeconds(10))
                  .until(ExpectedConditions.visibilityOfElementLocated(BUNS_BUTTON));
     }
     @Step("Ожидание загрузки начинок")
     public void waitClickFillings() {
          new WebDriverWait(driver, Duration.ofSeconds(10))
                  .until(ExpectedConditions.visibilityOfElementLocated(FILLINGS_BUTTON));
     }

     @Step("Проверка смены стиля у таба \"Соусы\"")
     public void changeStyleSauces(){
          new WebDriverWait(driver,Duration.ofSeconds(10))
                  .until(ExpectedConditions.attributeContains(SAUCES_BUTTON, "class","current"));
     }

     @Step("Проверка смены стиля у таба \"Булки\"")
     public void changeStyleBuns(){
          new WebDriverWait(driver,Duration.ofSeconds(10))
                  .until(ExpectedConditions.attributeContains(BUNS_BUTTON, "class","current"));
     }

     @Step("Проверка смены стиля у таба \"Начинки\"")
     public void changeStyleFillings(){
          new WebDriverWait(driver,Duration.ofSeconds(10))
                  .until(ExpectedConditions.attributeContains(FILLINGS_BUTTON, "class","current"));
     }

}

