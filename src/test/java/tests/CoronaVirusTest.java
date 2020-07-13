package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CoronaVirusTest extends BaseTest{

    AcceptCookiesPage acceptCookiesPage;
    MainPage mainPage;


    @Test
    public void openCoronavirusPage() throws SQLException {

        acceptCookiesPage = new AcceptCookiesPage(driver);
       mainPage = acceptCookiesPage.goToMainPage();
        mainPage.gotoCoronavirus();
        Assert.assertTrue(driver.getTitle().contains("Coronavirus"));
   }
}
