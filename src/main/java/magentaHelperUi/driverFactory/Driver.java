package magentaHelperUi.driverFactory;


import magentaHelperUi.configuration.ConfigReader;
import org.openqa.selenium.WebDriver;


public class Driver {

    private Driver() {
        //Singleton pattern - Единственный экземпляр
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser").toLowerCase()) {
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFireFoxDriver();
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Wrong Driver name");
            }
        }
        return driver;
    }


    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            System.out.println("Error while closing driver");
        }
    }
}
