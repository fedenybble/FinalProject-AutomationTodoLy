package cleanTest.todoLy;

import cleanTest.TestBaseTodoLy;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.GetProperties;

public class TestCaseForLogout extends TestBaseTodoLy {

    @Test
    @DisplayName("Verify if the user can Logout. ")
    @Description("This test case is to verify if the usser can logout after being logged in. ")
    @Owner("Federico Padin")
    @Epic("Logout")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Critical Flow")
    public void verifyLogout() throws InterruptedException {

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(GetProperties.getInstance().getUser());
        loginModal.loginPasswordInput.setText(GetProperties.getInstance().getPwd());
        loginModal.loginButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        navBar.navBarLogoutButton.waitIsVisible();
        navBar.navBarLogoutButton.click();

        Assertions.assertTrue(mainPage.loginButton.isControlDisplayed(), "ERROR: The user failed to logout. ");

        Thread.sleep(3000);

    }


}
