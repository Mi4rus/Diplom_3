package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import praktikum.pageobject.ConstructorMainPage;
import praktikum.pageobject.LoginPage;
import praktikum.pageobject.ProfilePage;
import praktikum.pageobject.RegisterPage;

import java.time.Duration;

import static io.restassured.RestAssured.given;

public class TransitionTest {
    private ConstructorMainPage objMainPage;
    private LoginPage objLoginPage;
    private RegisterPage objRegisterPage;
    private ProfilePage objProfilePage;
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
        objLoginPage = new LoginPage(driver);//новый объект класса страницы "Вход"
        objRegisterPage = new RegisterPage(driver);//новый объект класса страницы "Регистрация"
        objProfilePage = new ProfilePage(driver);//новый объект класса страницы "Личный кабинет"
        objMainPage.open();//открытие тестовой страницы
        objMainPage.waitForLoadPage();//ожидание загрузки
        objMainPage.clickLoginAccountButton();//клик на "Войти в аккаунт"
        objLoginPage.clickRegisterButton();//клик на "Зарегистрироваться"
        objRegisterPage.inputName();//ввод имени
        objRegisterPage.inputEmail();//ввод почты
        objRegisterPage.inputPasswordWithSixChars();//ввод пароля
        objRegisterPage.clickRegisterButton();//клик на "Зарегистрироваться"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.clickLogoButton();//клик на лого для возврата на главную
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет по клику на Личный кабинет")
    public void successfulTransitionWithAccountButton() {
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия кабинета
        objProfilePage.waitForLoadPage();//ожидание появления окна кабинета
        objProfilePage.isListItemButtonPresent();//проверка наличия кнопки "История заказов" в кабинете
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на Конструктор")
    public void successfulTransitionWithConstructorButton() {
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия кабинета
        objProfilePage.waitForLoadPage();//ожидание появления окна кабинета
        objProfilePage.isListItemButtonPresent();//проверка наличия кнопки "История заказов" в кабинете
        objProfilePage.clickConstructorButton();//клик на "Конструктор"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на логотип")
    public void successfulTransitionWithLogoButton() {
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия кабинета
        objProfilePage.waitForLoadPage();//ожидание появления окна кабинета
        objProfilePage.isListItemButtonPresent();//проверка наличия кнопки "История заказов" в кабинете
        objProfilePage.clickLogoButton();//клик на логотип
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
    }

    @After
    public void cleanUp() {
        driver.quit();
        String accessToken = given()
                .header("Content-Type", "application/json")
                .log().all() // логируем реквест
                .body("{\"email\": \"1test-data1@yandex.ru\", \"password\": \"123456\"}")
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then()
                .extract().path("accessToken").toString();
        given()
                .header("Content-Type", "application/json")
                .header("Authorization", accessToken)
                .log().all() // логируем реквест
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then()
                .log().all(); // логируем респонс
    }
}
