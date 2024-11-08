package praktikum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorMainPage {

     private final WebDriver driver;

     public ConstructorMainPage(WebDriver driver) {
          this.driver = driver;
     }

     private static final By PERSONAL_ACCOUNT_HEADER_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']");
     private static final By PERSONAL_ACCOUNT_BUTTON = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text() = 'Войти в аккаунт']");
     private static final By CONSTRUCTOR_HEADER_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Конструктор']");
     private static final By ORDER_FEED_HEADER_BUTTON = By.xpath(".//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Лента Заказов']");
     private static final By CREATE_MENU_BUNS_BUTTON = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Булки']");
     private static final By CREATE_MENU_SAUCES_BUTTON = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Соусы']");
     private static final By CREATE_MENU_FILLINGS_BUTTON = By.xpath(".//span[@class = 'text text_type_main-default' and text() = 'Начинки']");


}

