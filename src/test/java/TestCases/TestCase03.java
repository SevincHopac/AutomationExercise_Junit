package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase03 {

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
        //3. Verify that home page is visible successfully
        driver.get("https://automationexercise.com");
        //3. Verify that home page is visible successfully
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl,currentUrl);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
        boolean login = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();
        Assert.assertTrue(login);

        //6. Enter incorrect email address and password
        //7. Click 'login' button
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ali6@bak.com", Keys.TAB,"12345asdfg",Keys.TAB,Keys.ENTER);

        //8. Verify error 'Your email or password is incorrect!' is visible
        String incorrect = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")).getText();
        Assert.assertEquals("Your email or password is incorrect!",incorrect);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
