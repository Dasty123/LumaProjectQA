package pageTests;

import baseTestConfig.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class MyAccountPageTest extends BaseTest {

    Faker faker = new Faker();
    String firsName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String password = "Dastan99";

    @BeforeClass
    void configBrowser() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
        myAccountPage.fillUpTheLoginPage();

    }


    @Test
    void testContactInformation()
    {
        elementActions.clickTheButton(myAccountPage.editInformation)
                .eraseTheInfoAndWriteText(myAccountPage.editFirstName, firsName)
                        .eraseTheInfoAndWriteText(myAccountPage.editLastName, lastName)
                                .clickTheButton(myAccountPage.editSubmitBtn);
        Assert.assertTrue(myAccountPage.contactInformation.getText().contains(firsName)
        && myAccountPage.contactInformation.getText().contains(firsName));
    }

    @Test
    void testEditedInfo()
    {


        elementActions.clickTheButton(myAccountPage.editInformation)
                .eraseTheInfoAndWriteText(myAccountPage.editFirstName, firsName)
                .eraseTheInfoAndWriteText(myAccountPage.editLastName, lastName)
                .clickTheButton(myAccountPage.editSubmitBtn);
        Assert.assertTrue(myAccountPage.contactInformation.getText()
                .contains(firsName) && myAccountPage.contactInformation.getText()
                .contains(lastName));

    }

    @Test
    void testEditedAddress() throws InterruptedException
    {

        String mobileNumber = "0707634401";
        String street = "Karakol123";
        String city = faker.address().city();
        String zipCode = "722200";
        List<String> userCredits =  List.of(firsName,lastName,mobileNumber,street,city,zipCode);

        elementActions.clickTheButton(myAccountPage.editAddressBtn)
                .eraseTheInfoAndWriteText(myAccountPage.editFirstName, firsName)
                .eraseTheInfoAndWriteText(myAccountPage.editLastName, lastName)
                .eraseTheInfoAndWriteText(myAccountPage.telephoneField, mobileNumber)
                .eraseTheInfoAndWriteText(myAccountPage.streetField, street)
                .eraseTheInfoAndWriteText(myAccountPage.cityField, city)
                .eraseTheInfoAndWriteText(myAccountPage.zipCodeField, zipCode);
        Select select = new Select(myAccountPage.selectCountryBtn);
        select.selectByValue("KG");
        elementActions.clickTheButton(myAccountPage.saveAddressBtn);
        Thread.sleep(3000);

        for (String userCredit : userCredits){
            assertTrue(myAccountPage.addressCheck.getText().contains(userCredit));
        }

    }


    @Test
    void testChangePasswordWithWrongCurrent()
    {
        elementActions.clickTheButton(myAccountPage.changePasswordBtn)
                .writeText(myAccountPage.currentPassword, faker.internet().password())
                .writeText(myAccountPage.newPassword, "Hello123")
                .writeText(myAccountPage.newPasswordConfirm, "Hello123")
                .clickTheButton(myAccountPage.saveNewPasswordBtn);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='message-error error message']"))
                .isDisplayed());
    }

    @Test
    void testChangePasswordWithSamePassword()
    {
        elementActions.clickTheButton(myAccountPage.changePasswordBtn)
                .writeText(myAccountPage.currentPassword, password)
                .writeText(myAccountPage.newPassword, "Hello123")
                .writeText(myAccountPage.newPasswordConfirm, "Hello12")
                .clickTheButton(myAccountPage.saveNewPasswordBtn);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='password-confirmation-error']"))
                .isDisplayed());

    }

    @Test
    void testChangePasswordSuccess(){
        elementActions.clickTheButton(myAccountPage.changePasswordBtn)
                .writeText(myAccountPage.currentPassword, password)
                .writeText(myAccountPage.newPassword, password)
                .writeText(myAccountPage.newPasswordConfirm, password)
                .clickTheButton(myAccountPage.saveNewPasswordBtn);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='message-success success message']"))
                .isDisplayed());
    }


}
