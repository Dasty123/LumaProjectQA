package pageTests;

import baseTestConfig.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class OrderTest extends BaseTest {

    @BeforeClass
    void configPage() {
        driver.get("https://magento.softwaretestingboard.com/");
        orderPage.fillUpTheLogInPage();
    }

    @Test
    void test123() throws InterruptedException {

        orderPage.menClothes.click();
        elementActions.clickTheButton(orderPage.topsBtn);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//li[@class='item product product-item'])[1]")));
        elementActions.clickTheButton(driver.findElement(By.xpath("//div[@class='swatch-opt-724']//div[@id='option-label-size-143-item-166']")))
                .clickTheButton(driver.findElement(By.xpath("//div[@class='swatch-opt-724']//div[@id='option-label-color-93-item-50']")))
                .clickTheButton(driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]")));
        Thread.sleep(2000);
        elementActions.clickTheButton(driver.findElement(By.xpath("//a[@class='action showcart']")));
        driver.findElement(By.xpath("//a[@title='Remove item']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();

    }
}
