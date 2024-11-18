package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import praktikum.pageobject.ConstructorMainPage;

import java.time.Duration;

public class ConstructorTest {
    private ConstructorMainPage objMainPage;
    private WebDriver driver;

    @Rule
    public DriverFactory factory = new DriverFactory();

    @Before
    public void startUp() {
        driver=factory.getDriver();

        objMainPage = new ConstructorMainPage(driver);//новый объект класса главной страницы
        objMainPage.open();//открытие тестовой страницы
        objMainPage.waitForLoadPage();//ожидание загрузки
    }

    @Test
    @DisplayName("Проверка работы перехода в раздел \"Начинки\"")
    public void successfulSectionNavigationFillings() {
        objMainPage.waitClickFillings();//вкладка "Начинки" кликабельна
        objMainPage.clickFillingsButton();//клик на вкладку "Начинки"
        objMainPage.changeStyleFillings();


    }
    @Test
    @DisplayName("Проверка работы перехода в раздел \"Соусы\"")
    public void successfulSectionNavigationSauces() {
        objMainPage.waitClickSauces();//вкладка "Соусы" кликабельна
        objMainPage.clickSaucesButton();//клик на вкладку "Соусы"
        objMainPage.changeStyleSauces();
    }

    @Test
    @DisplayName("Проверка работы перехода в раздел \"Булки\"")
    public void successfulSectionNavigationBuns() {
        objMainPage.waitClickBuns();//вкладка "Булки" кликабельна
        objMainPage.clickFillingsButton();
        objMainPage.clickBunsButton();//клик на вкладку "Булки"
        objMainPage.changeStyleBuns();
    }
}
