package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase13 extends TestBase {

    @Test
    public void test() {

        //4. Click 'View Product' for any product on home page
     /*   JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,600)");*/

        driver.findElement(By.xpath("//a[@href='/product_details/2']")).sendKeys(Keys.ENTER);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/product_details/2']")).sendKeys(Keys.ENTER);

        //5. Verify product detail is opened
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed());

        //6. Increase quantity to 4
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP);

        //    driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(Keys.DELETE,"4",Keys.TAB,Keys.ENTER);

        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();

        //9. Verify that product is displayed in cart page with exact quantity
        String element = driver.findElement(By.xpath("//button[@class='disabled']")).getText();
        Assert.assertEquals("4",element);
    }
}
