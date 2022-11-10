package pages;

import controlSelenium.Button;
import controlSelenium.Checkbox;
import controlSelenium.Input;
import org.openqa.selenium.By;

public class SignUpModal {

    public Input signUpFullNameInput = new Input(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"), "[signUpFullNameInput] located in SignUp modal");
    public Input signUpEmailInput = new Input(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"), "[signUpEmailInput] located in SignUp modal");
    public Input signUpPasswordInput = new Input(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"), "[signUpPasswordInput] located in SignUp modal");
    public Checkbox signUpTermsCB = new Checkbox(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"), "[signUpTermsCB] checkBox located in SignUp modal");
    public Button signUpButton = new Button(By.id("ctl00_MainContent_SignupControl1_ButtonSignup"), "[signUpButton] located in SignUp modal");

}
