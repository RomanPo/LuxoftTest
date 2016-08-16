
import org.apache.http.util.Asserts;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EmailTest extends Fixture {

    String xpathForAddAccountLink = ".//a[@id='account-chooser-link']";
    String mainPageforLogin = "https://accounts.google.com/ServiceLogin?sacu=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier";
    String messageisSendSuccesfull = ".//div[@class='vh']/span";

    static final Logger log = Logger.getLogger(EmailTest.class);

    @Test
    public void emailTest() throws InterruptedException {


        log.info("Open page");
        page.openPage(mainPageforLogin);
        loginPage.enterEmail("luxoftTestrp@gmail.com");
        loginPage.clickNextButton();
        loginPage.waitForPasswordField();
        loginPage.enterPassword("luxofttt");
        loginPage.clickSignInButton();
        mainPage.waitForMainPageLoaded();
        log.info("Create new Email");
        mainPage.clickComposeButton();
        mainPage.switchToFrameandSendEmail();
        mainPage.waitForElementPresent(messageisSendSuccesfull);

        mainPage.clickLogoutButton();
        mainPage.waitForElementPresent(xpathForAddAccountLink);

        log.info("Now check Received email");
        loginPage.clickOnSignInWithDifferentAccount();
        loginPage.clickOnAddAccount();
        loginPage.enterEmail("romantestpopov@gmail.com");
        loginPage.clickNextButton();
        loginPage.waitForPasswordField();
        loginPage.enterPassword("RomatestLuxoft");
        loginPage.clickSignInButton();
        mainPage.waitForMainPageLoaded();
        log.info("Search for message with specific subject");
        mainPage.clickOnDropdownButton();
        mainPage.enterSubjectintheSearchDropdown();
        mainPage.clickOnSearchButton();

        mainPage.clickOnInboxLink();
        mainPage.clickOntheEmail();
        mainPage.clickOnDocument();
        WebElement documentLocator = driver.findElement(By.xpath(".//div[@class='aLF-aPX-aPF-aPE-a1J-Jz-Jw']//p"));

        Assert.assertTrue(documentLocator.getText().equals("This is the test message for sending the file.This is the test message for sending the file."));
    }
}
