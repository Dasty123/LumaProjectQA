package magentaHelperUi.helper;

import magentaHelperUi.driverFactory.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActions {

    public ElementActions waiButtonToBeClickable(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public ElementActions waitElementToBeDisplayed(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public ElementActions clickTheButton(WebElement element) {
        waiButtonToBeClickable(element);
        element.click();
        return this;
    }

    public ElementActions writeText(WebElement element, String text) {
        element.sendKeys(text);
        return this;
    }

    public ElementActions scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }
    public ElementActions setZoomLevel(WebDriver driver, double zoomLevel) {
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String script = "document.body.style.zoom = arguments[0]";
            jsExecutor.executeScript(script, zoomLevel);
        } else {
            throw new UnsupportedOperationException("Zoom level setting is not supported by this WebDriver");
        }
        return this;
    }

    public ElementActions clickWithJsExecutor(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();",element);
        return this;
    }

    public ElementActions highlightElement(WebElement element){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 2px solid red");
        return this;

    }

    public ElementActions eraseTheInfoAndWriteText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
        return this;
    }

}
