package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by r.popov on 8/9/2016.
 */
public class RegistrationPage extends BasePage {


    public RegistrationPage(WebDriver dr) {
        super(dr);
    }

    public List<WebElement> getListOfFieldsWithTypeText() {
        return driver.findElements(By.xpath(".//input[@type= 'text']"));
    }

    public void fillTextFields(String name, String lastName, String email,
                               String day, String month, String currentEmail) {

        for (WebElement el : getListOfFieldsWithTypeText()) {
            if (el.getAttribute("name").equals("FirstName")) {
                el.sendKeys(name);
            }
            if (el.getAttribute("name").equals("LastName")) {
                el.sendKeys(lastName);
            }
            if (el.getAttribute("name").equals("GmailAddress")) {
                el.sendKeys(email);
            }
            if (el.getAttribute("name").equals("BirthDay")) {
                el.sendKeys(day);
            }
            if (el.getAttribute("name").equals("BirthYear")) {
                el.sendKeys(month);
            }
            if (el.getAttribute("name").equals("RecoveryEmailAddress")) {
                el.sendKeys(currentEmail);
            }
        }
    }

    public void inputPassword(String pass) {
        driver.findElement(By.xpath(".//input[@id='Passwd']")).sendKeys(pass);
    }

    public void inputConfirmPass(String cpass) {
        driver.findElement(By.xpath(".//input[@id='PasswdAgain']")).sendKeys(cpass);
    }

    public void chooseMonth(String month) {
        driver.findElement(By.xpath(".//label[@id='month-label']")).click();
        driver.findElement(By.xpath(".//div[@class='goog-menu goog-menu-vertical']//div[contains(text(),'" + month + "')]")).click();
    }
    public void chooseGender(String gender){
        driver.findElement(By.xpath(".//label[@id='gender-label']")).click();
        driver.findElement(By.xpath(".//div[@class='goog-menu goog-menu-vertical']//div[contains(text(),'"+gender+"')]"));
    }
    public void clickSubmitButton() {
        driver.findElement(By.xpath(".//input[@id='submitbutton']")).click();
    }
}
