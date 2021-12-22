package tests;

import testBase.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SearchTest extends TestBase {

    @Test
    public void searchForProduct() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.searchProduct()
                .getResultName();

        assertThat(mainPage.getResultName(), equalTo(webDriver.findElement(By.cssSelector("#search_widget input[type='text']")).getText()));

        mainPage.selectResult();
    }

    @Test
    public void searchResultInDropdown() {
        MainPage mainPage = new MainPage(webDriver);

        mainPage.searchProduct()
                .getResultName();
        mainPage.checkForResultInResultDropDownList()
                .selectResult();
    }

}
