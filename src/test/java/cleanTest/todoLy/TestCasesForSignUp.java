package cleanTest.todoLy;

import cleanTest.TestBaseTodoLy;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

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
    @Epic("SignUp")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("SignUp")
    public void verifySignUp() throws InterruptedException {

        mainPage.signUpFreeButton.waitClickable();
        mainPage.signUpFreeButton.click();

        signUpModal.signUpFullNameInput.waitIsVisible();
        signUpModal.signUpFullNameInput.setText(fullName);
        signUpModal.signUpEmailInput.setText(email);
        signUpModal.signUpPasswordInput.setText(password);
        signUpModal.signUpTermsCB.check();
        signUpModal.signUpButton.click();
        navBar.navBarLogoutButton.waitIsVisible();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user was not registered.");

        Thread.sleep(3000);
    }

    @Test
    @Order(2)
    @DisplayName("Verify if an user can set the same [Full Name] and [Email] in SignUp modal.")
    @Description("This test case is to verify if the user can enter an email in [Full Name] field and repeat the same input in [Email] field.")
    @Owner("Federico Padin")
    @Epic("SignUp")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("SignUp")
    public void verifySameNameAndEmail() throws InterruptedException {

        mainPage.signUpFreeButton.waitClickable();
        mainPage.signUpFreeButton.click();

        signUpModal.signUpFullNameInput.waitIsVisible();
        signUpModal.signUpFullNameInput.setText(email);
        signUpModal.signUpEmailInput.setText(email);
        signUpModal.signUpPasswordInput.setText(password);
        signUpModal.signUpTermsCB.check();
        signUpModal.signUpButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user was not registered.");

        Thread.sleep(3000);

    }

    @Test
    @Order(3)
    @DisplayName("Verify if the user can SignUp without filling the [Email] field.")
    @Description("This test case is to verify if the user can SignUp without filling the [Email] field.")
    @Owner("Federico Padin")
    @Epic("SignUp")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("SignUp")
    public void verifyWithoutEmailField() throws InterruptedException {

        mainPage.signUpFreeButton.waitClickable();
        mainPage.signUpFreeButton.click();

        signUpModal.signUpFullNameInput.waitIsVisible();
        signUpModal.signUpFullNameInput.setText(fullName);
        signUpModal.signUpPasswordInput.setText(password);
        signUpModal.signUpTermsCB.check();
        signUpModal.signUpButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user was not registered.");

        Thread.sleep(3000);

    }

    @Test
    @Order(4)
    @DisplayName("Verify if an user can SignUp if the checkbox of [Terms of Service] is unchecked.")
    @Description("This test case is to verify it the user can SignUp after filling all the fields and uncheck the [Terms of Service] checkbox.")
    @Owner("Federico Padin")
    @Epic("SignUp")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("SignUp")
    public void verifyTermsOfServiceUnchecked() throws InterruptedException {

        mainPage.signUpFreeButton.waitClickable();
        mainPage.signUpFreeButton.click();

        signUpModal.signUpFullNameInput.waitIsVisible();
        signUpModal.signUpFullNameInput.setText(fullName);
        signUpModal.signUpEmailInput.setText(email);
        signUpModal.signUpPasswordInput.setText(password);
        signUpModal.signUpButton.click();

        // Assertions.assertFalse(mainPage.errorMessageText.isControlDisplayed(), "ERROR: The user was not registered.");
       Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user was not registered.");

        Thread.sleep(3000);


    }


}
