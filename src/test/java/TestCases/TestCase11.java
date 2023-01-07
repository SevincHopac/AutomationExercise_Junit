package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase11 extends TestBase {

    @Test
    public void test() {

        //4. Click 'Cart' button
        driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();

        //5. Scroll down to footer
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //6. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")).getText().contains("SUBSCRIPTION"));

        //7. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("asd@yxcv.com",Keys.ENTER);

        //8. Verify success message 'You have been successfully subscribed!' is visible

        String result = driver.findElement(By.xpath("//div[@class='alert-success alert']")).getText();
        Assert.assertEquals("You have been successfully subscribed!",result);

    }
}
