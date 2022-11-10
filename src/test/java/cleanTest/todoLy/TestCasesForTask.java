package cleanTest.todoLy;

import cleanTest.TestBaseTodoLy;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import utils.GetProperties;

import java.util.Date;

public class TestCasesForTask extends TestBaseTodoLy {

    @Test
    @Order(1)
    @DisplayName("Verify if a new task can be created")
    @Description("This test case is to verify if a new task can be created by the user")
    @Owner("Federico Padin")
    @Epic("Task")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Task")
    public void verifyCreateNewTask() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();
        String taskName = "newTask"+new Date().getTime();

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(GetProperties.getInstance().getUser());
        loginModal.loginPasswordInput.setText(GetProperties.getInstance().getPwd());
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

        Thread.sleep(3000);

    }

    @Test
    @Order(2)
    @DisplayName("Verify if a task can be deleted")
    @Description("This test case is to verify if the user can delete an existing task.")
    @Owner("Federico Padin")
    @Epic("Task")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Task")
    public void verifyDeleteTask() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();
        String taskName = "newTask"+new Date().getTime();

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(GetProperties.getInstance().getUser());
        loginModal.loginPasswordInput.setText(GetProperties.getInstance().getPwd());
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

        Thread.sleep(3000);

    }

    @Test
    @Order(3)
    @DisplayName("Verify if the user can set a [Priority] to a task")
    @Description("This test case is to verify if the user can set a [Priority] to a task.")
    @Owner("Federico Padin")
    @Epic("Task")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Task")
    public void verifySetPriority() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();
        String taskName = "newTask"+new Date().getTime();
        String expectedStyle="background-color: rgb(255, 51, 0);";

        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(GetProperties.getInstance().getUser());
        loginModal.loginPasswordInput.setText(GetProperties.getInstance().getPwd());
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
        taskSection.setPriorityOneOption.click();
        String actualStyle = taskSection.setPriorityOneOption.getAttribute("style");

        Assertions.assertEquals(expectedStyle, actualStyle, "ERROR: The task does not have Priority = 1. ");

        Thread.sleep(3000);
    }


    @Test
    @Order(4)
    @DisplayName("Verify if the [Task Name] field has a maximum length")
    @Owner("Federico Padin")
    @Epic("Task")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Task")
    public void verifyLengthTaskNameField() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();
        String taskName = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";


        mainPage.loginButton.waitClickable();
        mainPage.loginButton.click();

        loginModal.loginEmailInput.waitIsVisible();
        loginModal.loginEmailInput.setText(GetProperties.getInstance().getUser());
        loginModal.loginPasswordInput.setText(GetProperties.getInstance().getPwd());
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

        Assertions.assertTrue(taskName.length()<300, "ERROR: The task was created");

        Thread.sleep(3000);


    }
}
