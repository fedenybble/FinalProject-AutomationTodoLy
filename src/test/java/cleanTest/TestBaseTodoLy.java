package cleanTest;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.*;
import singletonSession.Session;
import utils.GetProperties;

import java.time.Duration;
import java.util.Date;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@ExtendWith(TestResultExtension.class)
public class TestBaseTodoLy {

    public MainPage mainPage = new MainPage();
    public SignUpModal signUpModal = new SignUpModal();
    public NavBar navBar = new NavBar();
    public LoginModal loginModal = new LoginModal();
    public SettingsModal settingsModal = new SettingsModal();
    public ProjectSection projectSection = new ProjectSection();
    public TaskSection taskSection = new TaskSection();

    @BeforeEach
    public void setup() throws InterruptedException {

        Thread.sleep(5000);

        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", GetProperties.getInstance().getBrowser())
                        .put("URL", GetProperties.getInstance().getHost())
                        .put("User", GetProperties.getInstance().getUser())
                        .put("Pwd", GetProperties.getInstance().getPwd())
                        .build(), System.getProperty("user.dir")
                        + "/build/allure-results/");
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }

}
