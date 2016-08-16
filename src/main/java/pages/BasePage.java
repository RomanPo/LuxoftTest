package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by r.popov on 8/9/2016.
 */
public class BasePage {

    public WebDriver driver;
    public static WebDriverWait waitForElement;
    static final Logger log = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver dr) {
        driver = dr;
        waitForElement = new WebDriverWait(dr, 10);
    }
    public boolean openPage(String url){
        try{
            log.info("Start open page");
            driver.get(url);
        } catch (Exception e) {
            log.error("Error in open page");
            return false;
        }
        log.info("Page open successfully");
        return true;
    }
    public boolean waitForElementPresent(String elementLocator) {
        try {
            waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementLocator)));
            log.info("WaitForElement _" + elementLocator + "_ Present");
        } catch (NoSuchElementException no) {
            log.error("Waiting for the appearance of the element _" + elementLocator + "_ was not successful " +
                    "WaitForElement _" + elementLocator + "_ Present");
            return false;
        }
        return true;
    }
}
