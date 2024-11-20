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
import static praktikum.pageobject.constants.Constants.*;

public class FailRegistrationTest {
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
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля меньше шести символов")
    public void checkPasswordErrorIfLessSixChars() {
        objMainPage.clickLoginAccountButton();//клик на "Войти в аккаунт"
        objLoginPage.clickRegisterButton();//клик на "Зарегистрироваться"
        objRegisterPage.inputName(NAME);//ввод имени
        objRegisterPage.inputEmail(EMAIL);//ввод почты
        objRegisterPage.inputPasswordWithFiveChars(INCORRECT_PASSWORD);//ввод пароля
        objRegisterPage.clickRegisterButton();//клик на "Зарегистрироваться"
        objRegisterPage.isPasswordErrorPresent();//проверка появления ошибки
    }
    @After
    public void cleanUp() {
        var user = User.nonExistentUser();
        var creds = UserCredentionals.fromUser(user);

        ValidatableResponse loginResponse = client.loginUser(creds);
        accessToken = check.check401ErrorLoggedIn(loginResponse);

        if(accessToken != null){
            ValidatableResponse response = client.deleteUser(accessToken);
            check.deleteUser(response);
        }
    }
}
