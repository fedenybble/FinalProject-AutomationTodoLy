package pages;

import controlSelenium.Button;
import controlSelenium.Input;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class ProjectSection {

    public Button addNewProjectButton = new Button(By.xpath("//div[@class=\"AddProjectLiDiv\"]"), "[addNewProjectButton] in Project Section");
    public Input addNewProjectInput = new Input(By.id("NewProjNameInput"), "[addNewProjectInput] in Project Section");
    public Button addButton = new Button(By.id("NewProjNameButton"), "[addButton] in Project Section");
    public Button deleteOptionButton = new Button(By.id("ProjShareMenuDel"), "[deleteOptionButton] in Project Section");
    public Button editOptionButton = new Button(By.xpath("//ul[@id=\"projectContextMenu\"]//li[@class=\"edit\"]"), "[editOptionButton] in Project Section");
    public Input editInputProjectName = new Input(By.xpath("//td[@class=\"ProjItemContent UnderEditingItem\"]//input[@id=\"ItemEditTextbox\"]"), "[editInputProjectName] in Project Section");
    public Button saveIconButton = new Button(By.xpath("//td[@class=\"ProjItemContent UnderEditingItem\"]//*[@id=\"ItemEditSubmit\"]"), "[saveIconButton] in Project Section");
    public Button ballIcon = new Button(By.xpath("//ul[@id=\"projectContextMenu\"]//li[@class=\"share separator\"]//div[@id=\"IconFrameOuter\"]//span[@style=\"background: url(Images/icons/ball.png) no-repeat;\"]"), "[ballIcon] in Project Section");
    public Label ballIconLabel = new Label(By.xpath("//li[last()]//div[@id=\"ListIcon\" and @style=\"background: url(Images/icons/ball.png) no-repeat;\"]"), "[ballIconLabel] in Project Section");
    public Button addItemAboveButton = new Button(By.xpath("//ul[@id=\"projectContextMenu\"]//li[@class=\"add separator\"]"), "[addItemAboveButton] in Project Section");
    public Input nameNewProjectAboveInput = new Input(By.xpath("//li[@id=\"AddProjectLi\"]//input[@id=\"ItemEditTextbox\"]"), "[newNameProjectAboveInput] in Project Section");
    public Button saveNewProjectAboveButton = new Button(By.xpath("//li[@id=\"AddProjectLi\"]//div[@id=\"ProjectEditDiv\"]//img[@id=\"ItemEditSubmit\"]"), "[saveNewProjectAboveButton] in Project Section");
    public Button findLastProjectCreated(String name){
        Button lastProjectCreated = new Button(By.xpath("//li[last()]//td[text()='" + name + "']"), "[lastProjectCreated] in Project Section");
        return lastProjectCreated;
    }

    public Button findOptionIconForProject(String name){
        Button optionIconButton = new Button(By.xpath("//li[last()]//td[text()='" + name + "']//following-sibling::td//div[@style=\"display: block;\"]//img[@src=\"/Images/dropdown.png\"]"), "[optionIconButton] in Project Section");
        return optionIconButton;
    }

    public Label findNewProjectAbove(String name){
        Label findNewProjectAboveCreated = new Label(By.xpath("//td[@class=\"ProjItemContent\" and text()='" +name+ "']"), "[projectAboveCreated] in Project Section");
        return findNewProjectAboveCreated;
    }
}
