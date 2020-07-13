package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AcceptCookiesPage extends BasePage {




    public AcceptCookiesPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//button[contains(text(),'Accept all cookies')]")
    WebElement acceptAllCookies;

    public void gotoCookiePage(){
        driver.get("https://www.hsbc.com/");
        wait.until((d)->acceptAllCookies.isDisplayed());
    }

    public MainPage goToMainPage(){
        gotoCookiePage();
        acceptAllCookies.click();
        return new MainPage(driver);
    }
}
