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

public class TestCase04 {

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
        Assert.assertEquals("https://automationexercise.com/",url);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
        boolean result =  driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed();
        Assert.assertTrue(result);

        //6. Enter correct email address and password
        //7. Click 'login' button
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ali12@bak.com", Keys.TAB,"1234qwert",Keys.ENTER);

        //8. Verify that 'Logged in as username' is visible
        String str = driver.findElement(By.xpath("//li[10]//a[1]")).getText();
        Assert.assertEquals("Logged in as alibak09",str);


        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

        //10. Verify that user is navigated to login page
        String loginPage = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).getText();
        Assert.assertEquals("Login to your account",loginPage);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
