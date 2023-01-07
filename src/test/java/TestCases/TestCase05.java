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

public class TestCase05 {


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

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        boolean result = driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed();
        Assert.assertTrue(result);

        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("alibak09", Keys.TAB, "ali12@bak.com", Keys.ENTER);

        //8. Verify error 'Email Address already exist!' is visible
        String str = driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']")).getText();
        Assert.assertEquals("Email Address already exist!", str);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }


}
