package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase07 extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//*[text()='Test Cases']")).click();
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[text()='Test Cases']")).click();

        //5. Verify user is navigated to test cases page successfully
        String actualText = driver.findElement(By.xpath("//b[normalize-space()='Test Cases']")).getText();
        String expectedText = "TEST CASES";
        Assert.assertEquals(expectedText,actualText);


  /*      driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]")).click();
        //5. Verify user is navigated to test cases page successfully
        WebElement testCasePage = driver.findElement(By.xpath("/html/body"));
        Assert.assertTrue(testCasePage.isDisplayed());

        */
    }
}
