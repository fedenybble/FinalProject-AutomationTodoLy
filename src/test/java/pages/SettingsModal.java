package pages;

import controlSelenium.Button;
import controlSelenium.Input;
import org.openqa.selenium.By;

public class SettingsModal {

    public Button defaultSettingsTab = new Button(By.xpath("//a[@href=\"#settings_basicPanel\"]"), "[defaultSettingsTab] located in Settings Modal");
    public Button profileTab = new Button(By.xpath("//a[@href=\"#settings_Profile\"]"), "[profileTab] located in Settings Modal");
    public Button accountTab = new Button(By.xpath("//a[@href=\"#settings_Account\"]"), "[accountTab] located in Settings Modal");
    public Input fullNameInput = new Input(By.id("FullNameInput"), "[fullNameInput] located in Settings Modal -> Profile Tab");
    public Button dropDownListDays = new Button(By.id("DropDownFirstDayOfWeek"), "[dropDownListDays] located in Settings Modal -> Default Settings Tab");
    public Button sundayDayOption = new Button(By.xpath("//option[text()=\"Sunday\"]"), "[sundayDayOption] located in Settings Modal -> Default Settings Tab");
    public Button okButton = new Button(By.xpath("//span[text()=\"Ok\"]"), "[okButton] located in Settings Modal");
    public Input oldPasswordInput = new Input(By.id("TextPwOld"), "[oldPasswordInput] located in Settings Modal -> Profile Tab");
    public Input newPasswordInput = new Input(By.id("TextPwNew"), "[newPasswordInput] located in Settings Modal -> Profile Tab");
    public Button deleteAccountButton = new Button(By.id("DeleteAccountBtn"), "[deleteAccountButton] located in Settings Modal -> Account Tab");


}
