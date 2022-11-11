package cleanTest.todoLy;

import cleanTest.TestBaseTodoLy;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import singletonSession.Session;
import utils.GetProperties;

import java.util.Date;

public class TestCasesForProject extends TestBaseTodoLy {


    @Test
    @Order(1)
    @DisplayName("Verify if an user can create a new project.")
    @Description("This test case is to verify if the user can create a new project after being logged in.")
    @Owner("Federico Padin")
    @Epic("Project")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Critical Flow")
    public void verifyNewProject() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();

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

        Thread.sleep(3000);

    }

    @Test
    @Order(2)
    @DisplayName("Verify if a project can be created by setting ' ' as name.")
    @Description("This test case is to verify if the user can create a new project by setting ' ' as a name and clicking [Add] button.")
    @Owner("Federico Padin")
    @Epic("Project")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Negative Test for Project Section")
    public void verifyNewProjectWithoutName(){

        String newProjectName = " ";

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

        Assertions.assertFalse(projectSection.findProjectCreated(newProjectName).isControlDisplayed(), "ERROR: The project was created with blank space.");

    }

    @Test
    @Order(3)
    @DisplayName("Verify if an user can create two (or more) projects with the same name")
    @Description("This test case is to verify if the user can create two projects (or more) with the same name")
    @Owner("Federico Padin")
    @Epic("Project")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Bug")
    @Issue("https://nybblegroup.atlassian.net/browse/NAQA-416")
    public void verifyProjectsWithSameName() throws InterruptedException {

        String newProjectName = "NewProjectName";

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
        String firstProjectCreated = projectSection.findLastProjectCreated(newProjectName).getText();

        Assertions.assertEquals(newProjectName, firstProjectCreated, "ERR0R: The project was not created. ");

        projectSection.addNewProjectButton.waitClickable();
        projectSection.addNewProjectButton.click();
        projectSection.addNewProjectInput.waitIsVisible();
        projectSection.addNewProjectInput.setText(newProjectName);
        projectSection.addButton.click();
        String secondProjectCreated = projectSection.findLastProjectCreated(newProjectName).getText();

        Assertions.assertNotEquals(firstProjectCreated, secondProjectCreated, "ERROR: Already exists a project with that name.");

        Thread.sleep(3000);

    }

    @Test
    @Order(4)
    @DisplayName("Verify if the user can create a project that has 300 character in the name")
    @Description("This test case is to verify if a project can be created with a name that has 300 characters")
    @Owner("Federico Padin")
    @Epic("Project")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Bug")
    @Issue("https://nybblegroup.atlassian.net/browse/NAQA-419")
    public void projectNameWith300Characters() throws InterruptedException {

        String projectName = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";

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
        projectSection.addNewProjectInput.setText(projectName);
        projectSection.addButton.click();

        Assertions.assertTrue(projectName.length()<300, "ERROR: The project was created");

        Thread.sleep(3000);

    }

    @Test
    @Order(5)
    @DisplayName("Verify if a project can be deleted")
    @Description("This test case is to verify if the user can delete an existing project")
    @Owner("Federico Padin")
    @Epic("Project")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Project")
    public void deleteProject() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();

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

        projectSection.findLastProjectCreated(newProjectName).click();
        projectSection.findOptionIconForProject(newProjectName).click();
        projectSection.deleteOptionButton.click();
        Session.getInstance().getBrowser().switchTo().alert().accept();

        Thread.sleep(3000);

        Assertions.assertFalse(projectSection.findLastProjectCreated(newProjectName).isControlDisplayed(), "ERROR: The project was not deleted. ");

        Thread.sleep(3000);
    }

    @Test
    @Order(6)
    @DisplayName("Verify if the project name can be edited")
    @Description("This test case is to verify if the project name can be edited by the user. ")
    @Owner("Federico Padin")
    @Epic("Project")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyEditProject() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();
        String editProjectName = "NameEdited";

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

        projectSection.findLastProjectCreated(newProjectName).click();
        projectSection.findOptionIconForProject(newProjectName).click();
        projectSection.editOptionButton.click();
        projectSection.editInputProjectName.clear();
        projectSection.editInputProjectName.setText(editProjectName);
        projectSection.saveIconButton.click();
        String projectWithNameEdited = projectSection.findLastProjectCreated(editProjectName).getText();

        Assertions.assertEquals(editProjectName, projectWithNameEdited, "ERROR: The name was not edited.");

        Thread.sleep(3000);
    }

    @Test
    @Order(7)
    @DisplayName("Verify if the user can set a new icon to an existing Project")
    @Description("This test case is to verify if the user can select an existing project and set a new icon. ")
    @Owner("Federico Padin")
    @Epic("Project")
    @Severity(SeverityLevel.MINOR)
    public void setNewIconToProject() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();

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

        projectSection.findLastProjectCreated(newProjectName).click();
        projectSection.findOptionIconForProject(newProjectName).click();
        projectSection.ballIcon.click();

        Assertions.assertTrue(projectSection.ballIconLabel.isControlDisplayed(), "ERROR: The ball icon was not setted.");

        Thread.sleep(3000);

    }

    @Test
    @Order(8)
    @DisplayName("Verify if the option [Add item above] works correctly and adds a new Project above the selected one")
    @Description("This test case is to verify if the user can add a new project above of the one selected.")
    @Owner("Federico Padin")
    @Epic("Project")
    @Severity(SeverityLevel.NORMAL)
    public void verifyAddItemAboveButton() throws InterruptedException {

        String newProjectName = "newProject"+new Date().getTime();
        String newProjectNameAbove = "projectAbove"+new Date().getTime();

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

        projectSection.findLastProjectCreated(newProjectName).click();
        projectSection.findOptionIconForProject(newProjectName).click();
        projectSection.addItemAboveButton.click();
        projectSection.nameNewProjectAboveInput.setText(newProjectNameAbove);
        projectSection.saveNewProjectAboveButton.click();

        Assertions.assertEquals(newProjectNameAbove, projectSection.findNewProjectAbove(newProjectNameAbove).getText(), "ERROR: The project was not created above the project selected");

        Thread.sleep(3000);
    }

}
