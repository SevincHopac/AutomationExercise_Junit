package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    protected static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://automationexercise.com");
        //3. Verify that home page is visible successfully
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

/*    @After
    public void tearDown() throws Exception {
        driver.quit();
    }*/

    public WebElement getWebElByXpath(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public WebElement getWebElById(String locator) {
        return driver.findElement(By.id(locator));
    }

    public List<WebElement> getWebElsToList(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    public void createAccount(String mail, String isim)  {

        getWebElByXpath("//*[text()=' Signup / Login']").click();

        getWebElByXpath("//*[@data-qa='signup-name']").sendKeys(isim, Keys.TAB, mail, Keys.ENTER);

        getWebElByXpath("//*[@id='id_gender1']").click();

        getWebElByXpath("//*[@id='password']").

                sendKeys("password0987",
                        Keys.TAB, "6",
                        Keys.TAB, "Mar",
                        Keys.TAB, "1992",
                        Keys.TAB, Keys.SPACE,
                        Keys.TAB, Keys.SPACE,
                        Keys.TAB, "Sevinc",
                        Keys.TAB, "Hopac",
                        Keys.TAB, "Company",
                        Keys.TAB, "Mahalle",
                        Keys.TAB, "Cadde",
                        Keys.TAB, "India",
                        Keys.TAB, "State",
                        Keys.TAB, "City",
                        Keys.TAB, "1111",
                        Keys.TAB, "123456789", Keys.ENTER);
    }

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
