package magentaHelperUi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "email")
    public WebElement emailFiled;

    @FindBy(id = "pass")
    public WebElement passwordField;

    @FindBy(id = "send2")
    public WebElement signInBtn;

    @FindBy(id = "maincontent")
    public WebElement errorTracker;

    @FindBy(xpath = "//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]")
    public WebElement forgotPasswordBtn;



}
