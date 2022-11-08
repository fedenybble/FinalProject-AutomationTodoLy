package cleanTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestCasesForLogin extends TestBaseTodoLy {

    String email = "ejemplo@ejemplo.com";
    String password = "ejemplo";

    @Test
    @Order(1)
    @DisplayName("Verify if the user can login correctly.")
    @Description("This test case is to verify if the user can login to the page correctly with a registered account.")
    @Owner("Federico Padin")
    public void verifyLoginCorrectly() throws InterruptedException {

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(email);
        loginModal.loginPasswordInput.setText(password);
        loginModal.loginButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        Thread.sleep(5000);
    }

    @Test
    @Order(2)
    @DisplayName("Verify if the user can login with the [Email] field empty.")
    @Description("This test case is to verify if the user can login if the [Email] field empty.")
    @Owner("Federico Padin")
    public void verifyLoginEmptyEmail() throws InterruptedException {

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginPasswordInput.setText(password);
        loginModal.loginButton.click();

        Assertions.assertFalse(mainPage.errorMessageLogin.isControlDisplayed(), "The user could not login");

        Thread.sleep(5000);
    }

    @Test
    @Order(3)
    @DisplayName("Verify if the user can login with the [Password] field empty.")
    @Description("This test case is to verify if the user can login if he leaves the [Password] field empty and clicks [Login] button.")
    @Owner("Federico Padin")
    public void verifyLoginPwdEmpty() throws InterruptedException {

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(email);
        loginModal.loginButton.click();

        Assertions.assertFalse(mainPage.errorMessageLogin.isControlDisplayed(), "The user could not login");

        Thread.sleep(5000);

    }



}
