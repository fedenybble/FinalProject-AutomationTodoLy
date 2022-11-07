package pages;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MainPage {

    public Button signUpFreeButton = new Button(By.xpath("//div[@class=\"HPHeaderSignup\"]"), "[signUpFreeButton] in MainPage");

}
