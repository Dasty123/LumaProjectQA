package magentaHelperUi.pages;

import magentaHelperUi.driverFactory.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class CreateAccountPage extends BasePage {

    List<WebElement> webElementList;


    public void addToList(){
        webElementList = List.of(firstName,lastName);
    }


    @FindBy(id = "firstname")
    public static WebElement firstName;

    @FindBy(id = "lastname")
    public static WebElement lastName;

    @FindBy(id = "is_subscribed")
    public static WebElement clickForNewsLetter;

    @FindBy(id = "email_address")
    public static WebElement emailAddress;

    @FindBy(id = "password")
    public static WebElement password;

    @FindBy(id = "password-confirmation")
    public static WebElement passwordField;


    @FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
    public static WebElement createAnAccountBtn;

    @FindBy(id = "maincontent")
    public static WebElement errorMessages;



    @Test
    public void fillUpTheCreateCustomerPage() {
        elementActions.writeText(firstName, "Dastan")
                .writeText(lastName, "Baidolotov")
                .writeText(emailAddress, "dastan2134@gmail.com")
                .writeText(password, "Dastan99")
                .writeText(passwordField, "Dastan99")
                .clickTheButton(createAnAccountBtn);
    }




}
