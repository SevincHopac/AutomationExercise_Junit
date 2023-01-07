package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

import static java.awt.SystemColor.window;

public class TestCase18 extends TestBase {

    @Test
    public void test() {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,600)");

        //3. Verify that categories are visible on left side bar
        Assert.assertTrue(getWebElByXpath("//*[@class='left-sidebar']").isDisplayed());

        //4. Click on 'Women' category
        getWebElByXpath("(//*[@class='fa fa-plus'])[1]").click();

        //5. Click on any category link under 'Women' category, for example: Dress
        getWebElByXpath("(//*[.='Dress '])[2]").click();
        driver.navigate().back();
        getWebElByXpath("(//*[.='Dress '])[2]").click();

        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        Assert.assertTrue(getWebElByXpath("//*[@class='title text-center']").isDisplayed());

        //7. On left side bar, click on any sub-category link of 'Men' category
        getWebElByXpath("(//*[@class='fa fa-plus'])[2]").click();

        getWebElByXpath("//*[text()='Tshirts '] ").click();

        //8. Verify that user is navigated to that category page
        Assert.assertTrue(getWebElByXpath("//*[@class='title text-center']").isDisplayed());

    }
}
