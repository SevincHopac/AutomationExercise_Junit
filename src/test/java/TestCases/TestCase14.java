package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase14 extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //4. Add products to cart
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)");
        Thread.sleep(3000);

        getWebElByXpath("(//*[@data-product-id='1'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();
        getWebElByXpath("(//*[@data-product-id='2'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();
        getWebElByXpath("(//*[@data-product-id='3'])[1]").click();
        getWebElByXpath("//*[text()='Continue Shopping']").click();

        Thread.sleep(2000);

        //5. Click 'Cart' button
        driver.findElement(By.xpath("//*[@href='/view_cart']")).click();

        //6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='active']")).isDisplayed());

        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();

        //9. Fill all details in Signup and create account
        createAccount("f1278t@asdf.com", "Tom");

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button

        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[text()='Continue']")).click();


      // 11. Verify ' Logged in as username' at top
        WebElement loggedMsg = getWebElByXpath("//*[text()=' Logged in as ']");
        Assert.assertTrue(loggedMsg.isDisplayed());


        //12.Click 'Cart' button
        getWebElByXpath("//*[text()=' Cart']").click();


        //13. Click 'Proceed To Checkout' button
        getWebElByXpath("//*[.='Proceed To Checkout']").click();


        //14. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Your delivery address']")).isDisplayed());

        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello World", Keys.TAB, Keys.ENTER);

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("1234567", Keys.TAB, "q34567", Keys.TAB, "232", Keys.TAB, "03", Keys.TAB, "2022");

        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();

      /*  //18. Verify success message 'Your order has been placed successfully!'
        String text1 = driver.findElement(By.xpath("//div[contains(text(),'Your order has been placed successfully!')]")).getText();
        Assert.assertEquals("Your order has been placed successfully!",text1);*/

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        //19. Click 'Delete Account' button
        getWebElByXpath("//a[normalize-space()='Delete Account']").click();


        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String text2 = getWebElByXpath("//b[normalize-space()='Account Deleted!']").getText();
        Assert.assertEquals("ACCOUNT DELETED!", text2);

        getWebElByXpath("//a[@class='btn btn-primary']").click();


    }
}
