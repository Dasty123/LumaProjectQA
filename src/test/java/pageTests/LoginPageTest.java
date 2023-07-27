package pageTests;

import baseTestConfig.BaseTest;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static magentaHelperUi.helper.UserCredits.dastanEmail;
import static magentaHelperUi.helper.UserCredits.dastanPassword;

public class LoginPageTest extends BaseTest {


    @BeforeClass
    void openTheLink()
    {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
    }

    @Test
    public void testWithValidCredits()
    {
        elementActions.writeText(loginPage.emailFiled, dastanEmail.getCredential())
                .writeText(loginPage.passwordField, dastanPassword.getCredential())
                .clickTheButton(loginPage.signInBtn);
        Assert.assertTrue(driver
                .findElement(By.xpath("//a[@aria-label='store logo']//img"))
                .isDisplayed());
    }

    @Test
    void testWithInvalidEmail()
    {
        elementActions.writeText(loginPage.emailFiled, "dastan213")
                .writeText(loginPage.passwordField, dastanPassword.getCredential())
                .clickTheButton(loginPage.signInBtn);
        Assert.assertTrue(loginPage.errorTracker.getText().contains("Please enter a valid email address (Ex: johndoe@domain.com)."));
    }

    @Test

    void testWithInvalidPassword() throws InterruptedException
    {
        elementActions.writeText(loginPage.emailFiled, dastanEmail.getCredential())
                .writeText(loginPage.passwordField, "123")
                .clickTheButton(loginPage.signInBtn);
        Thread.sleep(2000);
        Assert.assertTrue(loginPage.errorTracker.getText().contains("The account sign-in was incorrect "));
    }

    @Test
    void testForgotPasswordBtn() throws InterruptedException {
        elementActions.clickTheButton(loginPage.forgotPasswordBtn);
        Thread. sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='base']"))
                .isDisplayed());
    }

}
