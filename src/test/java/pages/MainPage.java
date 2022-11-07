package pages;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class MainPage {

    public Button signUpFreeButton = new Button(By.xpath("//div[@class=\"HPHeaderSignup\"]"), "[signUpFreeButton] in Main Page");
    public Label errorMessageText = new Label(By.id("ErrorMessageText"), "[ErrorMessageText] in Main Page");
    public Button loginButton = new Button(By.xpath("//div[@class=\"HPHeaderLogin\"]"), "[LoginButton] in Main Page");



}
