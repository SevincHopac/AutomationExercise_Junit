package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TestCase17 extends TestBase {

    @Test
    public void test() {

        //4. Add products to cart
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,600)");
        waitFor(3);

        getWebElByXpath("(//*[@data-product-id='1'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();
        getWebElByXpath("(//*[@data-product-id='2'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();
        getWebElByXpath("(//*[@data-product-id='3'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();

        //5. Click 'Cart' button
        getWebElByXpath("//*[text()=' Cart']").click();
        //6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='active']")).isDisplayed());

        //7. Click 'X' button corresponding to particular product
        //8. Verify that product is removed from the cart


        List<WebElement> list2 = driver.findElements(By.xpath("//*[@class='cart_price']"));
        driver.findElement(By.xpath("(//*[@class='cart_quantity_delete'])[2]")).click();
        waitFor(3);
        List<WebElement> list3 = driver.findElements(By.xpath("//*[@class='cart_price']"));

        Assert.assertEquals(list2.size(),list3.size()+1);



    }
}
