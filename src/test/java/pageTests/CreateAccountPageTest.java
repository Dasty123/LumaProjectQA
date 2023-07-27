package pageTests;

import baseTestConfig.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static magentaHelperUi.helper.UserCredits.*;
import static magentaHelperUi.pages.CreateAccountPage.*;


public class CreateAccountPageTest extends BaseTest {

    @BeforeClass
    public void openTheLink()
    {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @Test()
    void testWithRegisteredCredits() throws InterruptedException
    {
        createCustomerPage.fillUpTheCreateCustomerPage();
        Thread.sleep(1500);
        Assert.assertTrue(errorMessages.getText().contains("There is already an account with this email address"));

    }

    @Test()
    void testLoginWithInvalidEmail() throws InterruptedException
    {
        elementActions.writeText(firstName, dastanFirstName.getCredential())
                .writeText(lastName, dastanLastName.getCredential())
                .writeText(emailAddress, "dastan21")
                .writeText(password, dastanPassword.getCredential())
                .writeText(passwordField, dastanPassword.getCredential());
        createAnAccountBtn.click();
        Thread.sleep(5000);
        Assert.assertTrue(errorMessages.getText().contains("Please enter a valid email address"));

    }

    @Test()
    void testLoginWithInvalidPassword() throws InterruptedException
    {
        elementActions.writeText(firstName, dastanFirstName.getCredential())
                .writeText(lastName, dastanLastName.getCredential())
                .clickTheButton(clickForNewsLetter)
                .writeText(emailAddress, dastanEmail.getCredential())
                .writeText(password, "123")
                .writeText(passwordField, "123")
                .clickTheButton(createAnAccountBtn);
        Thread.sleep(2000);
        Assert.assertTrue(errorMessages.getText().contains("Minimum length of this field must be equa"));
    }


}
