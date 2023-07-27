package baseTestConfig;


import magentaHelperUi.configuration.FakeDataProvider;
import magentaHelperUi.driverFactory.Driver;
import magentaHelperUi.helper.ElementActions;
import magentaHelperUi.pages.CreateAccountPage;
import magentaHelperUi.pages.LoginPage;
import magentaHelperUi.pages.MyAccountPage;
import magentaHelperUi.pages.OrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(AllureReportListener.class)
public abstract class BaseTest {

    public WebDriver driver;
    public ElementActions elementActions;
    public FakeDataProvider fakeDataProvider;
    public CreateAccountPage createCustomerPage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public OrderPage orderPage;


    @BeforeClass
    public void setUpBrowser() {
        driver = Driver.getDriver();
        elementActions = new ElementActions();
        fakeDataProvider = new FakeDataProvider();
        createCustomerPage = new CreateAccountPage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        orderPage = new OrderPage();

    }

    @AfterClass
    public void tearDown() {
        Driver.closeDriver();
    }
}
