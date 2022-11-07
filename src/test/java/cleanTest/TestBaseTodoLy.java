package cleanTest;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginModal;
import pages.MainPage;
import pages.NavBar;
import pages.SignUpModal;
import singletonSession.Session;
import utils.GetProperties;

import java.util.Date;

public class TestBaseTodoLy {

    MainPage mainPage = new MainPage();
    SignUpModal signUpModal = new SignUpModal();
    NavBar navBar = new NavBar();
    LoginModal loginModal = new LoginModal();

    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }
    @AfterEach
    public void cleanup(){
        attach();
        Session.getInstance().closeBrowser();
    }

    @Attachment(value = "screenshot", type = "image/png")
    private byte[] attach(){
        //Tomar captura de pantalla - Adjuntarlo en el reporte
        return ((TakesScreenshot) Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
    }


}
