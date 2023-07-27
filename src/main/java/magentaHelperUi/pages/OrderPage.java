package magentaHelperUi.pages;

import magentaHelperUi.driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static magentaHelperUi.helper.UserCredits.dastanEmail;
import static magentaHelperUi.helper.UserCredits.dastanPassword;

public class OrderPage extends BasePage {

    LoginPage loginPage = new LoginPage();

    @FindBy(xpath = "//a[@id='ui-id-5']//span[contains(text(),'Men')]")
    public WebElement menClothes;

    @FindBy(xpath = "//a[contains(text(),'Tops')]")
    public WebElement topsBtn;

    @FindBy(xpath = "//a[contains(text(),'Bottoms')]")
    public WebElement buttomBtn;

















    public void fillUpTheLogInPage() {
        Driver.getDriver().findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
        elementActions.writeText(loginPage.emailFiled, dastanEmail.getCredential())
                .writeText(loginPage.passwordField, dastanPassword.getCredential())
                .clickTheButton(loginPage.signInBtn);
    }
}
