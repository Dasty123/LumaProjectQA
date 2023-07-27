package magentaHelperUi.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static magentaHelperUi.helper.UserCredits.dastanEmail;
import static magentaHelperUi.helper.UserCredits.dastanPassword;

public class MyAccountPage extends BasePage{

    LoginPage loginPage = new LoginPage();

    @FindBy(xpath = "//div[@class='box box-information']")
    public WebElement contactInformation;

    @FindBy(xpath = "//span[normalize-space()='Edit']")
    public WebElement editInformation;

    @FindBy(id = "firstname")
    public WebElement editFirstName;

    @FindBy(id = "lastname")
    public WebElement editLastName;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement editSubmitBtn;

    @FindBy(xpath = "//a[@class='action change-password']")
    public WebElement changePasswordBtn;

    @FindBy(id = "current-password")
    public WebElement currentPassword;


    @FindBy(id = "password")
    public WebElement newPassword;

    @FindBy(id = "password-confirmation")
    public WebElement newPasswordConfirm;

    @FindBy(xpath = "//button[@title='Save']")
    public WebElement saveNewPasswordBtn;


    @FindBy(xpath = "//a[@data-ui-id='default-billing-edit-link']")
    public WebElement editAddressBtn;

    @FindBy(id = "telephone")
    public WebElement telephoneField;

    @FindBy(id = "street_1")
    public WebElement streetField;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "zip")
    public WebElement zipCodeField;

    @FindBy(id = "country")
    public WebElement selectCountryBtn;

    @FindBy(xpath = "//button[@title='Save Address']")
    public WebElement saveAddressBtn;

    @FindBy(xpath = "//div[@class='box box-address-billing']")
    public WebElement addressCheck;

    public void fillUpTheLoginPage(){
        elementActions.writeText(loginPage.emailFiled, dastanEmail.getCredential())
                .writeText(loginPage.passwordField, dastanPassword.getCredential())
                .clickTheButton(loginPage.signInBtn);
    }




}
