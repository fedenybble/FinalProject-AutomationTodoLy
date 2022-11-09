package cleanTest.todoLy;

import cleanTest.TestBaseTodoLy;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.GetProperties;

public class TestCaseForLogout extends TestBaseTodoLy {

//    String email = "ejemplo@ejemplo.com";
//    String password = "ejemplo";


    @Test
    @DisplayName("Verify if the user can Logout. ")
    @Description("This test case is to verify if the usser can logout after being logged in. ")
    @Owner("Federico Padin")
    public void verifyLogout() throws InterruptedException {

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(GetProperties.getInstance().getUser());
        loginModal.loginPasswordInput.setText(GetProperties.getInstance().getPwd());
//        loginModal.loginEmailInput.setText(email);
//        loginModal.loginPasswordInput.setText(password);
        loginModal.loginButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        navBar.navBarLogoutButton.waitIsVisible();
        navBar.navBarLogoutButton.click();

        Assertions.assertTrue(mainPage.loginButton.isControlDisplayed(), "ERROR: The user failed to logout. ");

        Thread.sleep(3000);

    }


}
