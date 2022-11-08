package cleanTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestCasesForTask extends TestBaseTodoLy{


    String email = "ejemplo@ejemplo.com";
    String password = "ejemplo";

    @Test
    @Order(1)
    @DisplayName("Verify if a new task can be created")
    @Description("This test case is to verify if a new task can be created by the user")
    @Owner("Federico Padin")
    public void verifyCreateNewTask() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();
        String taskName = "newTask"+new Date().getTime();

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

        taskSection.newTaskNameInput.waitIsVisible();
        taskSection.newTaskNameInput.click();
        taskSection.newTaskNameInput.setText(taskName);
        taskSection.newTaskAddButton.click();

        Assertions.assertEquals(taskName, taskSection.findTaskCreated(taskName).getText(), "ERROR: The task was not created. ");

        Thread.sleep(5000);

    }

    @Test
    @Order(2)
    @DisplayName("Verify if a task can be deleted")
    @Description("This test case is to verify if the user can delete an existing task.")
    public void verifyDeleteTask() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();
        String taskName = "newTask"+new Date().getTime();

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

        taskSection.newTaskNameInput.waitIsVisible();
        taskSection.newTaskNameInput.click();
        taskSection.newTaskNameInput.setText(taskName);
        taskSection.newTaskAddButton.click();

        Assertions.assertEquals(taskName, taskSection.findTaskCreated(taskName).getText(), "ERROR: The task was not created. ");

        taskSection.findNewTaskCreated(taskName).waitIsVisible();
        taskSection.findNewTaskCreated(taskName).click();
        taskSection.optionButtonTask.click();
        taskSection.deleteTaskOption.click();

        Assertions.assertTrue(taskSection.findNewTaskCreated(taskName).isControlDisplayed(), "ERROR: The task was not deleted. ");

        Thread.sleep(5000);



    }

}
