package controlSelenium;

import org.openqa.selenium.By;

public class Input extends Control{

    public Input(By locator) {
        super(locator);
    }

    public Input(By locator, String controlName) {
        super(locator, controlName);
    }

    public void setText(String value){
        this.findControl();
        this.control.sendKeys(value);
    }
}
