package Utils.drivers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class RemoteDriverFactory implements GetDriver {

    private static RemoteWebDriver driver;
    private static DesiredCapabilities ds;

    private static URL url;

    static {
        try {
            url = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    static Supplier<RemoteWebDriver> chromeDriver = () -> {
        ds = DesiredCapabilities.chrome();
        return driver = new RemoteWebDriver(url, ds);
    };


    static Supplier<RemoteWebDriver> fireFoxDriver = () -> {
        ds = DesiredCapabilities.firefox();
        return driver = new RemoteWebDriver(url, ds);
    };

    static Supplier<RemoteWebDriver> OperaDriver = () -> {
        ds = DesiredCapabilities.operaBlink();
        return driver = new RemoteWebDriver(url, ds);
    };


    static Map<String, Supplier<RemoteWebDriver>> driverMap = new HashMap<>();

    static {
        driverMap.put("chrome", chromeDriver);
        driverMap.put("firefox", fireFoxDriver);
        driverMap.put("opera", OperaDriver);

    }

    @Override
    public RemoteWebDriver getDriver(String browser) {
        return driverMap.get(browser).get();
    }


}
