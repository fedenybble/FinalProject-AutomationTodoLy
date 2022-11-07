package cleanTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestCasesForLogin extends TestBaseTodoLy {

    String email = "ejemplo@ejemplo.com";
    String password = "ejemplo";

    @Test
    @Order(1)
    @DisplayName("Verify if an user can login correctly.")
    @Description("This test case is to verify if an user can login to the page correctly with a registered account.")
    @Owner("Federico Padin")
    public void verifyLoginCorrectly() throws InterruptedException {

        //mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(email);
        loginModal.loginPasswordInput.setText(password);
        loginModal.loginButton.click();

        Thread.sleep(5000);


    }

}
