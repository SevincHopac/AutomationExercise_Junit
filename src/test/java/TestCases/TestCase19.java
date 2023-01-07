package TestCases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase19 extends TestBase {

    @Test
    public void test() {



        //3. Click on 'Products' button
        //3. 'Ürünler' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        driver.navigate().refresh();


        //4. Verify that Brands are visible on left side bar
        //4. Sol taraftaki çubukta Markaların göründüğünü doğrulayın


        WebElement signup = driver.findElement(By.xpath("//h2[normalize-space()='Brands']"));
        Assert.assertTrue(signup.isDisplayed());
        Actions actions = new Actions(driver);
        waitFor(3);
        actions
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();


        waitFor(3);



         //5. Click on any brand name
        //5. Herhangi bir marka adına tıklayın
        driver.findElement(By.xpath("//a[@href='/brand_products/H&M']")).sendKeys(Keys.ENTER);
        driver.navigate().refresh();


        //6. Verify that user is navigated to brand page and brand products are displayed
        //6. Kullanıcının marka sayfasına yönlendirildiğini ve marka ürünlerinin görüntülendiğini doğrulayın.
        WebElement beklenen = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(beklenen.isDisplayed());

        //7. On left side bar, click on any other brand link*/
        //7. Sol taraftaki çubukta herhangi bir başka marka bağlantısına tıklayın
        driver.findElement(By.xpath("//a[@href='/brand_products/Madame']")).sendKeys(Keys.ENTER);

        //8. Verify that user is navigated to that brand page and can see products
        //8. Kullanıcının o marka sayfasına gittiğini ve ürünleri görebildiğini doğrulayın
        WebElement beklenenMadam = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(beklenenMadam.isDisplayed());

    }
}
