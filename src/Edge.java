import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Edge {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        System.setProperty("FirefoxDriver.Firefox.Driver","C:\\Users\\HARSH\\Desktop\\Automation 1\\Firefox Driver");
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://dev.deepthought.education/login");
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
    @Test(priority = 1)
    public  void verifyLoginwithValidCreads(){
    driver.findElement(By.name("username")).sendKeys("test1");
    driver.findElement(By.name("password")).sendKeys("Test@123");
    driver.findElement(By.id("login")).click();
    }
    @Test(priority = 2)
    public void verifyLoginwithInvalidCreads(){
        driver.findElement(By.name("username")).sendKeys("test0000");
        driver.findElement(By.name("password")).sendKeys("Test@12390");
        driver.findElement(By.id("login")).click();
    }
    @Test(priority = 3)
    public void verifyLoginWithInvalidCredsMessage(){
        driver.findElement(By.name("username")).sendKeys("test0000");
        driver.findElement(By.name("password")).sendKeys("Test@12390");
        driver.findElement(By.id("login")).click();

        String ActualMessage="The password entered is too short, please pick a different password.";
        String ExpectedMessage="The password entered is too short, please pick a different password.";

        Assert.assertTrue(ActualMessage.contains(ExpectedMessage),"Actual Message and Expected Messages is Not Coming in the Login Page !");
    }
    @Test(priority = 4)
    public void verifyLoginValidateDashboardorNot(){
        driver.findElement(By.name("username")).sendKeys("test1");
        driver.findElement(By.name("password")).sendKeys("Test@123");
        driver.findElement(By.id("login")).click();
        String validateDashboard="Welcome to DeepThought";
        String expectedDashboardText="Welcome to DeepThought";

        Assert.assertTrue(validateDashboard.contains(expectedDashboardText),"It is Not Redirected  Dashboard Page");
    }

}
