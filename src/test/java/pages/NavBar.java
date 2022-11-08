package pages;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class NavBar {

    public Button navBarLogoutButton = new Button(By.id("ctl00_HeaderTopControl1_LinkButtonLogout"), "[navBarLogoutButton] in Navbar");
    public Button navBarSettingsButton = new Button(By.xpath("//a[@href=\"javascript:OpenSettingsDialog();\"]"), "[navBarSettingsButton] in Navbar");

}
