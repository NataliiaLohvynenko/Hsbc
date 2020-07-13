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

    /*@BeforeSuite
    public void startDockerFile() throws IOException, InterruptedException {

        DockerComposeRun dc = new DockerComposeRun();
        dc.DockerComposeRunToOutput("dockerUp.bat", "Registering the node to the hub");
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start scaleChrome.bat");
        Thread.sleep(3000);
    }

    @AfterSuite
    public void stopDockerFile() throws IOException, InterruptedException {
        DockerComposeRun dc = new DockerComposeRun();
        dc.DockerComposeRunToOutput("dockerComposeDown.bat", "INFO stopped: selenium-hub");
        File f = new File("output.txt");
        Thread.sleep(7000);
        System.out.println("after dockerCompose Run " + f.delete());
    }
*/
    @Parameters("browser")
    @BeforeTest
    public void gerBrowser(@Optional("firefox") String browser) throws SQLException {
        getDriver = new RemoteDriverFactory();
        driver = (RemoteWebDriver) getDriver.getDriver(browser);
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
    }

}
