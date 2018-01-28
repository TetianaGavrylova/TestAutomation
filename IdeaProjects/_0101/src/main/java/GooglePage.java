import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

import static org.junit.Assert.assertTrue;

public class GooglePage {
    private String FieldSearch = "lst-ib";
    private String BtnImFeelingLucky = "btnI";
    private String LinkZranitelne = "//*[@id=\"mw-content-text\"]/div/p[1]/a[15]";
    private String EmptySpace = "gb";
//    private StringBuffer verificationErrors = new StringBuffer();
    private WebDriver driver;

    GooglePage (WebDriver driver2) {
        driver = driver2;
        }

    private WebElement getFieldSearch (){
        return driver.findElement(By.id(FieldSearch));
    }
    private WebElement getBtnImFeelingLucky (){
        return driver.findElement(By.name(BtnImFeelingLucky));
    }
    private WebElement getLinkZranitelne () {
        return driver.findElement(By.xpath(LinkZranitelne));
    }
    private WebElement getEmptySpace () {
        return driver.findElement(By.id(EmptySpace));

    }
//
//    try {
//        assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("Panda velká");
//    }
//    catch (Error e) {
//        verificationErrors.append(e.toString());
//    }

    public void clearFieldSearch (){
        getFieldSearch().clear();
    }
    public void enterTextIntoFieldSearch (String ImportantText){
        getFieldSearch().sendKeys(ImportantText + Keys.ARROW_DOWN + Keys.ARROW_DOWN +Keys.ENTER);
    }
    public void clickBtnImFeelingLucky (){
        getBtnImFeelingLucky().click();
    }
    public void clickLink (){
        getLinkZranitelne().click();
    }
    public void clickEmptySpace () {
        getEmptySpace().click();
    }

}
