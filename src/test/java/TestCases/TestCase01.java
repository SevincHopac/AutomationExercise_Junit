package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase01 {

    //1. Launch browser
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test01(){

        driver.get("https://automationexercise.com");
        //3. Verify that home page is visible successfully
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl,currentUrl);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement signUp = driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));
        Assert.assertTrue(signUp.isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("asdd1jgnb",Keys.TAB,"safsd14sda@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String  str = driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']")).getText();
        Assert.assertEquals(str,"ENTER ACCOUNT INFORMATION");

        //--------------------------------" 2.Page " --------------------------------
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        //9. Fill details: Title, Name, Email, Password, Date of birth

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("qwermjkthj",Keys.TAB,
                "02",Keys.TAB,"September",Keys.TAB,"1990",Keys.TAB,Keys.SPACE,Keys.TAB,Keys.SPACE,Keys.TAB);


        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
        actions.click(firstName)
                .sendKeys("Tiona").sendKeys(Keys.TAB)
                .sendKeys("Gorgotti").sendKeys(Keys.TAB)
                .sendKeys("Motiamssrie").sendKeys(Keys.TAB)
                .sendKeys("sadsfdgfhgj").sendKeys(Keys.TAB)
                .sendKeys("fghjkhj").sendKeys(Keys.TAB)
                .sendKeys("Israel").sendKeys(Keys.TAB)
                .sendKeys("poiu").sendKeys(Keys.TAB)
                .sendKeys("fghj45678").sendKeys(Keys.TAB)
                .sendKeys("3212345").sendKeys(Keys.TAB)
                .sendKeys("765432123456").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //14. Verify that 'ACCOUNT CREATED!' is visible

        String accountCreated = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).getText();
        Assert.assertEquals("ACCOUNT CREATED!",accountCreated);

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        //16. Verify that 'Logged in as username' is visible
        boolean logged = driver.findElement(By.xpath("//b[normalize-space()='asdd1jgnb']")).isDisplayed();
        Assert.assertTrue(logged);

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        boolean delete = driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).isDisplayed();
        Assert.assertTrue(delete);

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}
