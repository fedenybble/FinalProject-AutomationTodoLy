package pages;

import controlSelenium.Button;
import controlSelenium.Input;
import org.openqa.selenium.By;

public class SettingsModal {

    public Button defaultSettingsTab = new Button(By.xpath("//a[@href=\"#settings_basicPanel\"]"), "[defaultSettingsTab] in Settings Modal");
    public Button profileTab = new Button(By.xpath("//a[@href=\"#settings_Profile\"]"), "[profileTab] in Settings Modal");
    public Button accountTab = new Button(By.xpath("//a[@href=\"#settings_Account\"]"), "[accountTab] in Settings Modal");
    public Input fullNameInput = new Input(By.id("FullNameInput"), "[fullNameInput] in Settings Modal");
    public Button dropDownListDays = new Button(By.id("DropDownFirstDayOfWeek"), "[dropDownListDays] in Settings Modal");
    public Button sundayDayOption = new Button(By.xpath("//option[text()=\"Sunday\"]"), "[sundayDayOption] in Settings Modal");
    public Button okButton = new Button(By.xpath("//span[text()=\"Ok\"]"), "[okButton] in Settings Modal");
    public Input oldPasswordInput = new Input(By.id("TextPwOld"), "[oldPasswordInput] in Settings Modal");
    public Input newPasswordInput = new Input(By.id("TextPwNew"), "[newPasswordInput] in Settings Modal");
    public Button deleteAccountButton = new Button(By.id("DeleteAccountBtn"), "[deleteAccountButton] in Settings Modal");


}
