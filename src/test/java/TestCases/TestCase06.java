package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase06 {


    //1. Launch browser
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test() {

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/", url);

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        boolean reslt = driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']")).isDisplayed();
        Assert.assertTrue(reslt);

        //6. Enter name, email, subject and message
        //7. Upload file
        //8. Click 'Submit' button


        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ali", Keys.TAB,"email@sd.com",Keys.TAB,"beschwerde",Keys.TAB,"hello world");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//input[@name='upload_file']")).sendKeys("C:\\Users\\sevin\\OneDrive\\Desktop\\deneme.docx");
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //9. Click OK button
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String message = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
        Assert.assertEquals("Success! Your details have been submitted successfully.",message);

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();

        String homPageUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://automationexercise.com/", url);

    }
}
