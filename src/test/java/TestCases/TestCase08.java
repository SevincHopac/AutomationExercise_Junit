package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.util.List;

public class TestCase08 extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //4. Click on 'Products' button

        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String text = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        Assert.assertTrue(text.contains("ALL PRODUCTS"));

        //6. The products list is visible
        List<WebElement> products = driver.findElements(By.xpath("//*[@class='productinfo text-center']"));
        int actualSize = products.size();
        Assert.assertTrue(actualSize>0);
        System.out.println(actualSize);


        //7. Click on 'View Product' of first product
        Thread.sleep(3000);

        //---------------------------------------------------------------------
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400)");

        Thread.sleep(3000);

        driver.findElement(By.xpath("(//*[@class='nav nav-pills nav-justified'])[1]")).click();

        //8. User is landed to product detail page
        WebElement product = getWebElByXpath("//*[@class='product-information']");

        System.out.println(product.isEnabled());

        //9. Verify that  detail is visible: product name, category, price, availability, condition, brand
        System.out.println(product.getText());
        Assert.assertTrue(product.isDisplayed());


    }
}
