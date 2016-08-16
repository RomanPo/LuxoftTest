package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by r.popov on 8/9/2016.
 */
public class LoginPage extends BasePage {


    public LoginPage(WebDriver dr) {
        super(dr);
    }

    public void enterEmail(String email) {
        driver.findElement(By.xpath(".//input[@id='Email']")).sendKeys(email);
    }

    public void clickNextButton() {
        driver.findElement(By.xpath(".//input[@id='next']")).click();
    }

    public void enterPassword(String pass) {
        driver.findElement(By.xpath(".//input[@id='Passwd']")).sendKeys(pass);
    }

    public void clickSignInButton() {
        driver.findElement(By.xpath(".//input[@id='signIn']")).click();
    }

    public void waitForPasswordField() {
        waitForElementPresent(".//input[@id='Passwd']");
    }



    public void clickOnSignInWithDifferentAccount() {
        waitForElementPresent(".//a[@id='account-chooser-link']");
        driver.findElement(By.xpath(".//a[@id='account-chooser-link']")).click();
    }

    public void clickOnAddAccount(){
        driver.findElement(By.xpath(".//a[@id='account-chooser-add-account']")).click();
    }

}
