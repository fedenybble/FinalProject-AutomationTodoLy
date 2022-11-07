package pages;

import controlSelenium.Button;
import controlSelenium.Input;
import org.openqa.selenium.By;

public class LoginModal {

    public Input loginEmailInput = new Input(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail"), "[LoginEmailInput] located in Login Modal");
    public Input loginPasswordInput = new Input(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword"), "[LoginPasswordInput] located in Login Modal");
    public Button loginButton = new Button(By.id("ctl00_MainContent_LoginControl1_ButtonLogin"), "[LoginButton] located in Login Modal");

}
