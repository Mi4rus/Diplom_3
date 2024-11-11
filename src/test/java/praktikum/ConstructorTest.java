package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.pageobject.ConstructorMainPage;

public class ConstructorTest {
    private ConstructorMainPage objMainPage;
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();//драйвер хром
        driver = new ChromeDriver();//экземпляр драйвера хром

        //замена на драйвер яндекс.браузера (закомментить экземпляр драйвера хрома выше и раскомментить строчки снизу)
//        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DNS\\yandexdriver.exe");
//        options.setBinary("C:\\Users\\DNS\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
//        driver = new ChromeDriver(options);

        objMainPage = new ConstructorMainPage(driver);//новый объект класса главной страницы
        objMainPage.open();//открытие тестовой страницы
        objMainPage.waitForLoadPage();//ожидание загрузки
    }

    @Test
    @DisplayName("Проверка работы переходов по разделам конструктора ингредиентов")
    public void successfulSectionNavigation() {
        objMainPage.waitClickFillings();//вкладка "Начинки" кликабельна
        objMainPage.clickFillingsButton();//клик на вкладку "Начинки"
        objMainPage.waitClickSauces();//вкладка "Соусы" кликабельна
        objMainPage.clickSaucesButton();//клик на вкладку "Соусы"
        objMainPage.waitClickBuns();//вкладка "Булки" кликабельна
        objMainPage.clickBunsButton();//клик на вкладку "Булки"
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
