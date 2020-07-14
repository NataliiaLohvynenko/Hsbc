package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(linkText = "COVID-19 latest")
    WebElement covid19Latest;

    public void gotoCoronavirus(){
        crollIntoView(covid19Latest);
        covid19Latest.click();
       wait.until((d)->driver.getTitle().contains("Coronavirus"));
    }
}
