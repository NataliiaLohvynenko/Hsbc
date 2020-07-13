package tests;

import Utils.drivers.GetDriver;
import Utils.drivers.RemoteDriverFactory;
import Utils.drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.sql.SQLException;

public class BaseTest {

    RemoteWebDriver driver;
    //WebDriver driver;
    GetDriver getDriver;

    @Parameters("browser")
    @BeforeTest
    public void gerBrowser(@Optional("chrome") String browser) throws SQLException {
        getDriver = new RemoteDriverFactory();
        driver = (RemoteWebDriver) getDriver.getDriver(browser);
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
