import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;
import pages.LoginPage;
import pages.MainPage;

import java.io.File;

/**
 * Created by r.popov on 8/9/2016.
 */
public class Fixture {
    public WebDriverWait wait;
    public static WebDriver driver;
    BasePage page;
    LoginPage loginPage;
    MainPage mainPage;


    @BeforeSuite

    public void setUp() {
        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("");
        driver = new FirefoxDriver( new FirefoxBinary(
                new File(System.getProperty("user.dir"),
                        "src\\main\\resources\\files\\FirefoxPortable\\App\\Firefox\\firefox.exe")
        ),
                profile);
        wait = new WebDriverWait(driver, 30);
        page = new BasePage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @AfterSuite

    public static void tearDown() {
        driver.quit();
    }
}
