package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase16 extends TestBase {
    @Test
    public void test() {

        //4. Click 'Signup / Login' button
        //5. Fill email, password and click 'Login' button

        getWebElByXpath("//*[text()=' Signup / Login']").click();

        getWebElByXpath("//*[@data-qa='login-email']").sendKeys("qwer@1234.com",
                Keys.TAB,"bjk1903.",Keys.TAB,Keys.ENTER);


        //6. Verify 'Logged in as username' at top

        String loggedMsg = getWebElByXpath("//*[text()=' Logged in as ']").getText();
        Assert.assertTrue(loggedMsg.contains("Logged in as"));



        //7. Add products to cart
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,600)");
        waitFor(3);

        getWebElByXpath("(//*[@data-product-id='1'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();
        getWebElByXpath("(//*[@data-product-id='2'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();
        getWebElByXpath("(//*[@data-product-id='3'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();

        //8. Click 'Cart' button
        getWebElByXpath("//*[text()=' Cart']").click();

        //9. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='active']")).isDisplayed());

        //10. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        //11. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Your delivery address']")).isDisplayed());

        //12. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello World", Keys.TAB,Keys.ENTER);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello World", Keys.TAB,Keys.ENTER);

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("1234567",Keys.TAB,"q34567",Keys.TAB,"232",Keys.TAB,"03",Keys.TAB,"2022");

        //14. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        waitFor(3);

        //15. Verify success message 'Your order has been placed successfully!' ///++++++++++++++++++++++++++++
    //    Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Your order has been placed successfully!']")).isDisplayed());

/*        //16. Click 'Delete Account' button
        getWebElByXpath("//a[normalize-space()='Delete Account']").click();

        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String text2 = getWebElByXpath("//b[normalize-space()='Account Deleted!']").getText();
        Assert.assertEquals("ACCOUNT DELETED!",text2);
        getWebElByXpath("//*[@data-qa='continue-button']").click();*/
    }
}
