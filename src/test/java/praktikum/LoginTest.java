package praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pageobject.ConstructorMainPage;
import praktikum.pageobject.LoginPage;
import praktikum.pageobject.RegisterPage;
import praktikum.pageobject.user.User;
import praktikum.pageobject.user.UserChecks;
import praktikum.pageobject.user.UserClient;
import praktikum.pageobject.user.UserCredentionals;
import java.time.Duration;

public class LoginTest {
    private ConstructorMainPage objMainPage;
    private LoginPage objLoginPage;
    private RegisterPage objRegisterPage;
    private WebDriver driver;
    private UserClient client = new UserClient();
    private UserChecks check = new UserChecks();
    private String accessToken;

    @Rule
    public DriverFactory factory = new DriverFactory();

    @Before
    public void startUp() {
        driver=factory.getDriver();

        objMainPage = new ConstructorMainPage(driver);//новый объект класса главной страницы
        objLoginPage = new LoginPage(driver);//новый объект класса страницы "Вход"
        objRegisterPage = new RegisterPage(driver);//новый объект класса страницы "Регистрация"
        objMainPage.open();//открытие тестовой страницы
        objMainPage.waitForLoadPage();//ожидание загрузки

        var user = User.randomUser();
        ValidatableResponse createResponse = client.createUser(user);
        check.checkCreated(createResponse);

        var creds = UserCredentionals.fromUser(user);
        ValidatableResponse loginResponse = client.loginUser(creds);
        accessToken = check.checkLoggedIn(loginResponse);
    }

    @Test
    @DisplayName("Проверка входа по кнопке Войти в аккаунт на главной")
    public void successfulLoginWithButtonEnterInAccount() {
        objMainPage.clickLoginAccountButton();//клик на "Войти в аккаунт"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
    }

    @Test
    @DisplayName("Проверка входа через кнопку Личный кабинет")
    public void successfulLoginWithAccountButton() {
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
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void successfulLoginWithRegisterPageButton() {
        objMainPage.clickLoginAccountButton();//клик на "Войти в аккаунт"
        objLoginPage.clickRegisterButton();//клик на "Зарегистрироваться"
        objRegisterPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void successfulLoginWithResetPasswordPageButton() {
        objMainPage.clickLoginAccountButton();//клик на "Войти в аккаунт"
        objLoginPage.clickForgotButton();//клик на "Восстановить пароль"
        objRegisterPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail();//ввод почты
        objLoginPage.inputPasswordWithSixChars();//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
    }

    @After
    public void cleanUp() {

        if(accessToken != null){
            ValidatableResponse response = client.deleteUser(accessToken);
            check.deleteUser(response);
        }
    }
}
