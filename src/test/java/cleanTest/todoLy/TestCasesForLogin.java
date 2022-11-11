package cleanTest.todoLy;

import cleanTest.TestBaseTodoLy;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import singletonSession.Session;
import utils.GetProperties;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestCasesForLogin extends TestBaseTodoLy {

    @Test
    @Order(1)
    @DisplayName("Verify if the user can login correctly.")
    @Description("This test case is to verify if the user can login to the page correctly with a registered account.")
    @Owner("Federico Padin")
    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Critical Flow")
    public void verifyLoginCorrectly() throws InterruptedException {

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(GetProperties.getInstance().getUser());
        loginModal.loginPasswordInput.setText(GetProperties.getInstance().getPwd());
        loginModal.loginButton.click();
        navBar.navBarLogoutButton.waitIsVisible();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        Thread.sleep(3000);
    }


    @Test
    @Order(2)
    @DisplayName("Verify if the user can login with the [Email] field empty.")
    @Description("This test case is to verify if the user can login if the [Email] field empty.")
    @Owner("Federico Padin")
    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginEmptyEmail() throws InterruptedException {

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginPasswordInput.setText(GetProperties.getInstance().getPwd());
        loginModal.loginButton.click();

        Assertions.assertFalse(mainPage.errorMessageLogin.isControlDisplayed(), "ERROR: The user could not login");

        Thread.sleep(3000);
    }

    @Test
    @Order(3)
    @DisplayName("Verify if the user can login with the [Password] field empty.")
    @Description("This test case is to verify if the user can login if he leaves the [Password] field empty and clicks [Login] button.")
    @Owner("Federico Padin")
    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginPwdEmpty() throws InterruptedException {

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(GetProperties.getInstance().getUser());
        loginModal.loginButton.click();

        Assertions.assertFalse(mainPage.errorMessageLogin.isControlDisplayed(), "ERROR: The user could not login");

        Thread.sleep(3000);

    }

    @Test
    @Order(4)
    @DisplayName("Verify if the user can login with a non-register account.")
    @Description("This test case is to verify if the user can login with an account that is not registered.")
    @Owner("Federico Padin")
    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyNonRegisterAccount() throws InterruptedException {

        String emailNotRegistered = new Date().getTime()+"@gmail.com";

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(emailNotRegistered);
        loginModal.loginPasswordInput.setText(GetProperties.getInstance().getPwd());
        loginModal.loginButton.click();

        Assertions.assertFalse(mainPage.errorMessageLogin.isControlDisplayed(), "ERROR: The user could not login");

        Thread.sleep(3000);

    }



}
