package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class TestCase09 extends TestBase {

    @Test
    public void test() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String text = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        Assert.assertTrue(text.contains("ALL PRODUCTS"));

        //6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("tshirt",Keys.TAB ,Keys.ENTER);

        //7. Verify 'SEARCHED PRODUCTS' is visible
        String textTitle = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println(textTitle);
        Assert.assertTrue(textTitle.contains("SEARCHED PRODUCTS"));

        //8. Verify all the products related to search are visible
        int numberOfProducts = driver.findElements(By.xpath("//*[@class='productinfo text-center']/p")).size();


    }
}
