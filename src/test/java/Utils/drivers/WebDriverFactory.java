package Utils.drivers;

import com.google.common.base.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory  implements GetDriver{

    private static final Supplier<WebDriver> chromeSupplier = ()->{
      System.setProperty("webdriver.chrome.driver","D:\\education\\drivers\\chromedriver.exe");
      return new ChromeDriver();
    };
    private static final Supplier<WebDriver> fireFoxSupplier = ()->{
        System.setProperty("webdriver.gecko.driver","D:\\education\\drivers\\geckodriver.exe");
        return new FirefoxDriver();
    };

    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();
    static {
        MAP.put("chrome", chromeSupplier);
        MAP.put("firefox", fireFoxSupplier);
    }

    @Override
    public  WebDriver getDriver(String browser){

        return MAP.get(browser).get();
    }

}
