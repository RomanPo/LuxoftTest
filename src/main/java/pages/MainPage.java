package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by r.popov on 8/10/2016.
 */
public class MainPage extends BasePage {

    public MainPage(WebDriver dr) {
        super(dr);
    }

    public void clickComposeButton() {
        driver.findElement(By.xpath(".//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
    }

    public void switchToFrameandSendEmail() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@class='a7A']")));
        WebElement printbody = driver.switchTo().activeElement();
        printbody.sendKeys("romantestpopov@gmail.com");
        printbody.sendKeys(Keys.ENTER);
        printbody.sendKeys(Keys.TAB);
        printbody.sendKeys("testestse");
        printbody.sendKeys(Keys.TAB);
        printbody.sendKeys("Body");
        printbody.sendKeys(Keys.TAB);
        printbody.sendKeys(Keys.TAB);
        printbody.sendKeys(Keys.ENTER);
        uploadFile();
        printbody.sendKeys(Keys.TAB);
        printbody.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
    }

    public void waitForMainPageLoaded() {
        waitForElementPresent(".//div[@class='T-I J-J5-Ji T-I-KE L3']");
    }

    public void uploadFile() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        ClassLoader loader = getClass().getClassLoader();

        File file = new File("C:\\LuxoftTest1\\src\\main\\resources\\files\\test.doc");
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
        clipboard.setContents(stringSelection, null);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(2 * 1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2 * 10000);

    }

    public void clickLogoutButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(".//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']/span"))).click().perform();
        actions.moveToElement(driver.findElement(By.xpath(".//a[@id='gb_71']"))).click().perform();
    }

    public void clickOnSearchButton() {
        driver.findElement(By.xpath(".//button[@id='gbqfb']")).click();
    }

    public void enterSubjectintheSearchDropdown() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='SK ZF-zT']/div[@class='ZZ']/div[4]//input"))).sendKeys("luxofttestrp@gmail.com").perform();
    }

    public void clickOnDropdownButton() {
        driver.findElement(By.xpath(".//div[@class='aoq']")).click();
    }

    public void clickOntheEmail() {
        driver.findElement(By.xpath(".//div[@class='y6']/span[@id=':3k']")).click();
    }

    public void clickOnInboxLink() {
        driver.findElement(By.xpath(".//span[@class='nU n1']/a[@class='J-Ke n0']")).click();
    }

    public String readLinefromFile() {
        String sCurrentLine = null;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\r.popov\\Downloads\\test.doc"))) {

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sCurrentLine;
    }

    public void clickOnDownloadButton() {
        driver.findElement(By.xpath(".//div[@id=':11c']")).click();
    }

    public void downloadFile() throws InterruptedException {
        Thread.sleep(1000L);
        //create robot object
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000L);
        //Click Down Arrow Key to select "Save File" Radio Button
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(1000L);
        // Click 3 times Tab to take focus on "OK" Button
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000L);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000L);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000L);
        //Click "Enter" Button to download file
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(5000L);
        System.out.println("Robot work Complete");
    }

    public void clickOnDocument() {
        driver.findElement(By.xpath(".//div[@id=':ef']")).click();
    }
}


