package praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pageobject.ConstructorMainPage;
import praktikum.pageobject.LoginPage;
import praktikum.pageobject.ProfilePage;
import praktikum.pageobject.RegisterPage;
import io.restassured.response.ValidatableResponse;
import praktikum.pageobject.user.User;
import praktikum.pageobject.user.UserChecks;
import praktikum.pageobject.user.UserClient;
import praktikum.pageobject.user.UserCredentionals;
import java.time.Duration;
import static praktikum.pageobject.constants.Constants.*;


public class ExitTest {
    private UserClient client = new UserClient();
    private UserChecks check = new UserChecks();
    private ConstructorMainPage objMainPage;
    private LoginPage objLoginPage;
    private RegisterPage objRegisterPage;
    private ProfilePage objProfilePage;
    private WebDriver driver;
    private String accessToken;

    @Rule
    public DriverFactory factory = new DriverFactory();

    @Before
    public void startUp() {
        driver=factory.getDriver();

        objMainPage = new ConstructorMainPage(driver);//новый объект класса главной страницы
        objLoginPage = new LoginPage(driver);//новый объект класса страницы "Вход"
        objRegisterPage = new RegisterPage(driver);//новый объект класса страницы "Регистрация"
        objProfilePage = new ProfilePage(driver);//новый объект класса страницы "Личный кабинет"
        objMainPage.open();//открытие тестовой страницы
        objMainPage.waitForLoadPage();//ожидание загрузки

        var user = User.correctUser();
        ValidatableResponse createResponse = client.createUser(user);
        check.checkCreated(createResponse);

        var creds = UserCredentionals.fromUser(user);
        ValidatableResponse loginResponse = client.loginUser(creds);
        accessToken = check.checkLoggedIn(loginResponse);

    }

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void successfulExitFromAccount() {
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы "Вход"
        objLoginPage.waitForLoadPage();//ожидание появления окна "Вход"
        objLoginPage.isLoginPageWindowOpen();//проверка открытия окна входа
        objLoginPage.inputEmail(EMAIL);//ввод почты
        objLoginPage.inputPasswordWithSixChars(CORRECT_PASSWORD);//ввод пароля
        objLoginPage.clickEnterButton();//клик на "Войти"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия главной страницы
        objMainPage.waitForLoadPage();//ожидание появления окна главной страницы
        objMainPage.isSendOrderButtonPresent();//проверка наличия кнопки "Оформить заказ"
        objMainPage.clickAccountButton();//клик на "Личный кабинет"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия кабинета
        objProfilePage.waitForLoadPage();//ожидание появления окна кабинета
        objProfilePage.isListItemButtonPresent();//проверка наличия кнопки "История заказов" в кабинете
        objProfilePage.clickExitButton();//клик на кнопку выхода
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//ожидание открытия страницы входа
        objLoginPage.waitForLoadPage();//ожидание появления окна страницы входа
        objLoginPage.isLoginPageWindowOpen();//проверка наличия кнопки "Восстановить пароль" на странице входа
    }

    @After
    public void cleanUp() {

        if(accessToken != null){
            ValidatableResponse response = client.deleteUser(accessToken);
            check.deleteUser(response);
        }
    }
}
