package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pageobject.ConstructorMainPage;

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
