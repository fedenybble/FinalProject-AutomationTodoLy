package cleanTest;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Description;
import singletonSession.Session;

import java.util.Date;

public class TestCasesForProject extends TestBaseTodoLy{

    String email = "ejemplo@ejemplo.com";
    String password = "ejemplo";


    @Test
    @Order(1)
    @DisplayName("Verify if an user can create a new project.")
    @Description("This test case is to verify if the user can create a new project after being logged in.")
    @Owner("Federico Padin")
    public void verifyNewProject() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(email);
        loginModal.loginPasswordInput.setText(password);
        loginModal.loginButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        projectSection.addNewProjectButton.waitClickable();
        projectSection.addNewProjectButton.click();
        projectSection.addNewProjectInput.waitIsVisible();
        projectSection.addNewProjectInput.setText(newProjectName);
        projectSection.addButton.click();

        Assertions.assertEquals(newProjectName, projectSection.findLastProjectCreated(newProjectName).getText(), "ERR0R: The project was not created. ");

        Thread.sleep(5000);

    }

    @Test
    @Order(2)
    @DisplayName("Verify if a project can be created by setting ' ' as name.")
    @Description("This test case is to verify if the user can create a new project by setting ' ' as a name and clicking [Add] button.")
    @Owner("Federico Padin")
    public void verifyNewProjectWithoutName(){

        String newProjectName = " ";

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(email);
        loginModal.loginPasswordInput.setText(password);
        loginModal.loginButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        projectSection.addNewProjectButton.waitClickable();
        projectSection.addNewProjectButton.click();
        projectSection.addNewProjectInput.waitIsVisible();
        projectSection.addNewProjectInput.setText(newProjectName);
        projectSection.addButton.click();

//        Assertions.assertEquals(newProjectName, projectSection.findLastProjectCreated(newProjectName).getText(), "ERR0R: The project was not created. ");

    }

    @Test
    @Order(3)
    @DisplayName("Verify if an user can create two (or more) projects with the same name")
    @Description("This test case is to verify if the user can create two projects (or more) with the same name")
    @Owner("Federico Padin")
    public void verifyProjectsWithSameName() throws InterruptedException {

        String newProjectName = "NewProjectName";

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(email);
        loginModal.loginPasswordInput.setText(password);
        loginModal.loginButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        projectSection.addNewProjectButton.waitClickable();
        projectSection.addNewProjectButton.click();
        projectSection.addNewProjectInput.waitIsVisible();
        projectSection.addNewProjectInput.setText(newProjectName);
        projectSection.addButton.click();
        String firstProjectCreated = projectSection.findLastProjectCreated(newProjectName).getText();

        Assertions.assertEquals(newProjectName, firstProjectCreated, "ERR0R: The project was not created. ");

        projectSection.addNewProjectButton.waitClickable();
        projectSection.addNewProjectButton.click();
        projectSection.addNewProjectInput.waitIsVisible();
        projectSection.addNewProjectInput.setText(newProjectName);
        projectSection.addButton.click();
        String secondProjectCreated = projectSection.findLastProjectCreated(newProjectName).getText();

        Assertions.assertEquals(firstProjectCreated, secondProjectCreated, "ERROR: Already exists a project with that name.");


        Thread.sleep(5000);

    }

    @Test
    @Order(4)
    @DisplayName("Verify if the user can create a project that has 300 character in the name")
    @Description("This test case is to verify if a project can be created with a name that has 300 characters")
    @Owner("Federico Padin")
    public void projectNameWith300Characters() throws InterruptedException {

        String projectName = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(email);
        loginModal.loginPasswordInput.setText(password);
        loginModal.loginButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        projectSection.addNewProjectButton.waitClickable();
        projectSection.addNewProjectButton.click();
        projectSection.addNewProjectInput.waitIsVisible();
        projectSection.addNewProjectInput.setText(projectName);
        projectSection.addButton.click();

        Assertions.assertEquals(projectName, projectSection.findLastProjectCreated(projectName).getText(), "ERR0R: The project was not created. ");

        Thread.sleep(5000);

    }

    @Test
    @Order(5)
    @DisplayName("Verify if a project can be deleted")
    @Description("This test case is to verify if the user can delete an existing project")
    @Owner("Federico Padin")
    public void deleteProject() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(email);
        loginModal.loginPasswordInput.setText(password);
        loginModal.loginButton.click();

        Assertions.assertTrue(navBar.navBarLogoutButton.isControlDisplayed(), "ERROR: The user failed to login");

        projectSection.addNewProjectButton.waitClickable();
        projectSection.addNewProjectButton.click();
        projectSection.addNewProjectInput.waitIsVisible();
        projectSection.addNewProjectInput.setText(newProjectName);
        projectSection.addButton.click();

        Assertions.assertEquals(newProjectName, projectSection.findLastProjectCreated(newProjectName).getText(), "ERR0R: The project was not created. ");

        projectSection.findLastProjectCreated(newProjectName).click();
        projectSection.findOptionIconForProject(newProjectName).click();
        projectSection.deleteOptionButton.click();
        Session.getInstance().getBrowser().switchTo().alert().accept();

        Thread.sleep(3000);

        Assertions.assertFalse(projectSection.findLastProjectCreated(newProjectName).isControlDisplayed(), "ERROR: The project was not deleted. ");

        Thread.sleep(3000);
    }

}
