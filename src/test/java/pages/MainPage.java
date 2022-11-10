package pages;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class MainPage {

    public Button signUpFreeButton = new Button(By.xpath("//div[@class=\"HPHeaderSignup\"]"), "[signUpFreeButton] located in Main Page");
    public Label errorMessageText = new Label(By.id("ErrorMessageText"), "[ErrorMessageText] located in Main Page");
    public Label errorMessageLogin = new Label(By.id("HeaderMessageError"), "[ErrorMessageLogin] located in Main Page");
    public Button loginButton = new Button(By.xpath("//div[@class=\"HPHeaderLogin\"]"), "[LoginButton] located in Main Page");



}
