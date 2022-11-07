package controlSelenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;

public class Control {

    protected By locator;
    protected WebElement control;
    protected String controlName; // reflection

    public Control (By locator){
        this.locator=locator;
    }

    public Control (By locator, String controlName) {
        this.locator = locator;
        this.controlName = controlName;
    }

    protected void findControl(){
        control= Session.getInstance().getBrowser().findElement(this.locator);
    }

    @Step("{0}")
    public void step(String action){}

    /**
     *
     */
    public void click(){
        this.findControl();
        this.step("CLICK on "+controlName);
        control.click();
    }

    public void clear(){
        this.findControl();
        control.clear();
    }

    public boolean isControlDisplayed(){
        try {
            this.findControl();
            this.step("Check the "+controlName+" is displayed: true");
            return control.isDisplayed();
        }catch (Exception e){
            this.step("Check the "+controlName+" is displayed: false");
            return false;
        }
    }

    public String getText(){
        this.findControl();
        this.step("Get text from "+controlName+", the value is: "+control.getText());
        return control.getText();
    }

    public String getAttribute(String name){
        this.findControl();
        return control.getAttribute(name);
    }

    public void hoverAction(){
        this.findControl();
        Actions action = new Actions(Session.getInstance().getBrowser());
        action.moveToElement(this.control).perform();
    }

    public void waitClickable() {
        // todo --> factory para instanciar el wait una sola vez
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(this.locator));
    }

    public void waitIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeSelected(this.locator));
    }

    public void waitIsVisible(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.locator));
    }

    public void waitToBePresent(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(this.locator));
    }

    public void waitToDissapear(){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.locator));
    }

    public void waitAttributeToChange(String attribute, String value){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(this.locator, attribute, value));
    }
    public void waitPropertyToChange(String property, String value){
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.domPropertyToBe(this.control, property, value));
    }

//    public void waitURLToBe(String url){
//        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlToBe(url));
//    }



}
