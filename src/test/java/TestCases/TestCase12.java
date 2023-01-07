package TestCases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class TestCase12 extends TestBase {

    @Test
    public void test() {

        //4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Hover over first product and click 'Add to cart'
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,400)");

        driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[1]//div[2]//div[1]//a[1]")).click();

        //6. Click 'Continue Shopping' button

        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        //7. Hover over second product and click 'Add to cart'
        //8. Click 'View Cart' button
        //9. Verify both products are added to Cart
        //10. Verify their prices, quantity and total price

    }
}
