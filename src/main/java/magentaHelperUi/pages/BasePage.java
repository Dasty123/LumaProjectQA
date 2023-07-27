package magentaHelperUi.pages;


import magentaHelperUi.driverFactory.Driver;
import magentaHelperUi.helper.ElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public ElementActions elementActions = new ElementActions();


}
