package cleanTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestCasesForSignUp extends TestBaseTodoLy {

    String fullName = "newName"+new Date().getTime();
    String email = new Date().getTime()+"@gmail.com";
    String password = "passwordForAutomation";

    @Test
    @Order(1)
    @DisplayName("Verify if an user can SignUp correctly.")
    @Description("This test case is to verify that an user can sign up correctly after filling all the fields with valid data.")
    @Owner("Federico Padin")
    public void verifySignUp() throws InterruptedException {

        mainPage.signUpFreeButton.waitClickable();
        mainPage.signUpFreeButton.click();

        signUpModal.signUpFullNameInput.waitIsVisible();
        signUpModal.signUpFullNameInput.setText(fullName);
        signUpModal.signUpEmailInput.setText(email);
        signUpModal.signUpPasswordInput.setText(password);
        signUpModal.signUpTermsCB.check();
        signUpModal.signUpButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user was not registered.");

        Thread.sleep(5000);
    }

    @Test
    @Order(2)
    @DisplayName("Verify if an user can set the same [Full Name] and [Email] in SignUp modal.")
    @Description("This test case is to verify if the user can enter an email in [Full Name] field and repeat the same input in [Email] field.")
    @Owner("Federico Padin")
    public void verifySameNameAndEmail() throws InterruptedException {

        //Thread.sleep(4000);
        //mainPage.signUpFreeButton.waitClickable();
        mainPage.signUpFreeButton.click();

        signUpModal.signUpFullNameInput.waitIsVisible();
        signUpModal.signUpFullNameInput.setText(email);
        signUpModal.signUpEmailInput.setText(email);
        signUpModal.signUpPasswordInput.setText(password);
        signUpModal.signUpTermsCB.check();
        signUpModal.signUpButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user was not registered.");

        Thread.sleep(5000);

    }

    @Test
    @Order(3)
    @DisplayName("Verify if the user can SignUp without filling the [Email] field.")
    @Description("This test case is to verify if the user can SignUp without filling the [Email] field.")
    @Owner("Federico Padin")
    public void verifyWithoutEmailField(){

        mainPage.signUpFreeButton.click();

        signUpModal.signUpFullNameInput.waitIsVisible();
        signUpModal.signUpFullNameInput.setText(fullName);
        signUpModal.signUpPasswordInput.setText(password);
        signUpModal.signUpTermsCB.check();
        signUpModal.signUpButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user was not registered.");


    }


}
