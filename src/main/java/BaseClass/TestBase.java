package BaseClass;

import Pages.LoginPage;
import Utility.WaitHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Locale;

public class TestBase {
    WebDriver driver=null;
    WebDriverWait wait;

    @BeforeClass
    public void  Setup(){
        String ee=System.getProperty("os.name");
        System.out.println("Automation Run in the "+ee);
        String browser=System.getProperty("browser","chrome");
        switch (browser.toLowerCase(Locale.ROOT))
        {

            case "chrome":
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(ops);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "safari":
                driver=new SafariDriver();
                break;
            default:
                driver=null;
                break;
        }
        PageDriver.getInstance().setDriver(driver);
        driver.manage().window().maximize();
        driver.get("https://snuat.benekiva.io/login");
        new WaitHelper(PageDriver.getCurrentDriver(),10).waitForEl(new LoginPage().TextLoginPage);
    }
    @AfterClass
    public void tearDown(){
        PageDriver.getCurrentDriver().quit();
    }

}
