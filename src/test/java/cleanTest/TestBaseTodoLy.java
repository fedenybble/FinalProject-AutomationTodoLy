package cleanTest;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginModal;
import pages.MainPage;
import pages.NavBar;
import pages.SignUpModal;
import singletonSession.Session;
import utils.GetProperties;

import java.util.Date;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@ExtendWith(TestResultExtension.class)
public class TestBaseTodoLy {

    MainPage mainPage = new MainPage();
    SignUpModal signUpModal = new SignUpModal();
    NavBar navBar = new NavBar();
    LoginModal loginModal = new LoginModal();

    @BeforeEach
    public void setup(){
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
