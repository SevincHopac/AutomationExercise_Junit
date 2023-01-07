package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase15 extends TestBase {

    @Test
    public void test() {

        //4. Click 'Signup / Login' button
        //5. Fill all details in Signup and create account
        createAccount("qwe2r@1234.com","Tom");

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

        //7. Verify ' Logged in as username' at top
        String loggedMsg = getWebElByXpath("//*[text()=' Logged in as ']").getText();
        Assert.assertTrue(loggedMsg.contains("Logged in as"));

        //8. Add products to cart
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,600)");
        waitFor(3);

        getWebElByXpath("(//*[@data-product-id='1'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();
        getWebElByXpath("(//*[@data-product-id='2'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();
        getWebElByXpath("(//*[@data-product-id='3'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();

        //9. Click 'Cart' button
        getWebElByXpath("//*[text()=' Cart']").click();

        //10. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='active']")).isDisplayed());

        //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        //12. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Your delivery address']")).isDisplayed());

        //13. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello World", Keys.TAB,Keys.ENTER);

        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("1234567",Keys.TAB,"q34567",Keys.TAB,"232",Keys.TAB,"03",Keys.TAB,"2022");


        //15. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        //16. Verify success message 'Your order has been placed successfully!' //*********************************************


        //17. Click 'Delete Account' button
        getWebElByXpath("//a[normalize-space()='Delete Account']").click();


        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String text2 = getWebElByXpath("//b[normalize-space()='Account Deleted!']").getText();
        Assert.assertEquals("ACCOUNT DELETED!",text2);
        getWebElByXpath("//*[@data-qa='continue-button']").click();


    }
}
