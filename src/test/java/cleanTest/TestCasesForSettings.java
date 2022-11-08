package cleanTest;

import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

import java.util.Date;

public class TestCasesForSettings extends TestBaseTodoLy {

    String email = "ejemplo@ejemplo.com";
    String password = "ejemplo";


    @Test
    @Order(1)
    @DisplayName("Verify if the user can edit the 'First Day of Week'")
    @Description("This test case is to verify if the user can edit the “First Day of Week” from his account.")
    @Owner("Federico Padin")
    public void editFirstDayOfWeek() throws InterruptedException {

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(email);
        loginModal.loginPasswordInput.setText(password);
        loginModal.loginButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        navBar.navBarSettingsButton.waitIsVisible();
        navBar.navBarSettingsButton.click();

        settingsModal.defaultSettingsTab.waitClickable();
        settingsModal.defaultSettingsTab.click();
        settingsModal.dropDownListDays.waitClickable();
        settingsModal.dropDownListDays.click();
        settingsModal.sundayDayOption.click();
        settingsModal.okButton.click();


        navBar.navBarSettingsButton.waitIsVisible();
        navBar.navBarSettingsButton.click();
        settingsModal.defaultSettingsTab.waitClickable();
        settingsModal.defaultSettingsTab.click();


        Thread.sleep(5000);

    }

    @Test
    @Order(2)
    @DisplayName("Verify if the user can edit his full name")
    @Description("This test case is to verify if the user can edit his full name in [Settings] modal")
    @Owner("Federico Padin")
    public void editFullName() throws InterruptedException {

        String newName = "name"+new Date().getTime();

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(email);
        loginModal.loginPasswordInput.setText(password);
        loginModal.loginButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        navBar.navBarSettingsButton.waitIsVisible();
        navBar.navBarSettingsButton.click();

        settingsModal.profileTab.waitClickable();
        settingsModal.profileTab.click();
        settingsModal.fullNameInput.click();
        settingsModal.fullNameInput.clear();
        settingsModal.fullNameInput.setText(newName);
        String actualResult = settingsModal.fullNameInput.getAttribute("value");
        settingsModal.okButton.click();

        Assertions.assertEquals(newName, actualResult, "ERROR: The Full Name was not modified.");

        Thread.sleep(5000);

    }

    @Test
    @Order(3)
    @DisplayName("Verify if the user can change his password.")
    @Description("This test case is to verify if the user can change his password correctly.")
    @Owner("Federico Padin")
    public void editPassword() throws InterruptedException {

        String fullName = "newName"+new Date().getTime();
        String email = new Date().getTime()+"@gmail.com";
        String pwd = "passwordForAutomation";
        String newPassword = "ejemploAutomation";

        mainPage.signUpFreeButton.waitClickable();
        mainPage.signUpFreeButton.click();

        signUpModal.signUpFullNameInput.waitIsVisible();
        signUpModal.signUpFullNameInput.setText(fullName);
        signUpModal.signUpEmailInput.setText(email);
        signUpModal.signUpPasswordInput.setText(pwd);
        signUpModal.signUpTermsCB.check();
        signUpModal.signUpButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user was not registered.");

        navBar.navBarSettingsButton.waitIsVisible();
        navBar.navBarSettingsButton.click();

        settingsModal.profileTab.waitClickable();
        settingsModal.profileTab.click();
        settingsModal.oldPasswordInput.click();
        settingsModal.oldPasswordInput.clear();
        settingsModal.oldPasswordInput.setText(pwd);
        settingsModal.newPasswordInput.setText(newPassword);
        settingsModal.okButton.click();

        navBar.navBarLogoutButton.click();

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();
        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(email);
        loginModal.loginPasswordInput.setText(newPassword);
        loginModal.loginButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        Thread.sleep(5000);

    }


}
