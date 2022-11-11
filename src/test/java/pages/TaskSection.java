package pages;

import controlSelenium.Button;
import controlSelenium.Input;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class TaskSection {

    public Input newTaskNameInput = new Input(By.id("NewItemContentInput"), "[newTaskNameInput] located Task Section");
    public Button newTaskAddButton = new Button(By.id("NewItemAddButton"), "[newTaskAddButton] located Task Section");
    public Button optionButtonTask = new Button(By.xpath("//div[@id=\"ItemListPlaceHolder\"]//img[@src=\"/Images/dropdown.png\"]"), "[optionButtonTask] located in Task Section");
    public Button deleteTaskOption = new Button(By.xpath("//ul[@id=\"itemContextMenu\"]//a[@href=\"#delete\"]"), "[deleteTaskOption] located in Task Section -> Options");
    public Button setPriorityOneOption = new Button(By.xpath("//div[@id=\"Div1\"]//span[@iconid=\"1\"]"), "[setPriorityOneOption] located in Task Section");

    public Label tasksList = new Label(By.id("mainItemList"), "[tasksList] located in Task Section");

    public Label findTaskCreated(String name){

        Label taskCreated = new Label(By.xpath("//ul[@id=\"mainItemList\"]//div[text()='" +name+ "']"), "[taskCreated] in Task Section");

        return taskCreated;
    }
    public Button findNewTaskCreated(String name){
        Button newTaskCreated = new Button(By.xpath("//div[@class=\"LiDiv BaseItemLiDiv\"]//div[text()='"+name+"']"), "[newTaskCreated] in Task Section");
        return newTaskCreated;
    }
    public Button findOptionsIconForTask(String name){
        Button optionsButtonForTask = new Button(By.xpath("//li[last()]//td[text()='" + name + "']//following-sibling::td//div[@style=\"display: block;\"]//img[@src=\"/Images/dropdown.png\"]"), "[optionsButtonForTask] in Task Section");
        return optionsButtonForTask;
    }


}
