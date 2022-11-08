package pages;

import controlSelenium.Button;
import controlSelenium.Input;
import org.openqa.selenium.By;

public class ProjectSection {

    public Button addNewProjectButton = new Button(By.xpath("//div[@class=\"AddProjectLiDiv\"]"), "[addNewProjectButton] in Project Section");
    public Input addNewProjectInput = new Input(By.id("NewProjNameInput"), "[addNewProjectInput] in Project Section");
    public Button addButton = new Button(By.id("NewProjNameButton"), "[addButton] in Project Section");
    public Button deleteOptionButton = new Button(By.id("ProjShareMenuDel"), "[deleteOptionButton] in Project Section");
    public Button findLastProjectCreated(String name){
        Button lastProjectCreated = new Button(By.xpath("//li[last()]//td[text()='" + name + "']"), "[lastProjectCreated] in Project Section");
        return lastProjectCreated;
    }

    public Button findOptionIconForProject(String name){
        Button optionIconButton = new Button(By.xpath("//li[last()]//td[text()='" + name + "']//following-sibling::td//div[@style=\"display: block;\"]//img[@src=\"/Images/dropdown.png\"]"), "[optionIconButton] in Project Section");
        return optionIconButton;
    }
}
