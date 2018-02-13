import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GooglePage {
    private String FieldSearch = "lst-ib";
    private String BtnImFeelingLucky = "btnI";
    private String LinkZranitelne = "//*[@id=\"mw-content-text\"]/div/p[1]/a[15]";
    private String EmptySpace = "gb";
    private WebDriver driver;

//    Wiki part
    private String FieldSearchWiki = "searchInput";
    private String Title = "Giant panda - Wikipedia";

    GooglePage (WebDriver driver2) {
        driver = driver2;
        }

    GooglePage () {
        Class<? extends WebDriver> driverClass = ChromeDriver.class;
        WebDriverManager.getInstance(driverClass).setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
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

//    Wiki part
    private WebElement getFieldSearchWiki (){
        return driver.findElement(By.id(FieldSearchWiki));
    }


    public void clearFieldSearch (){
        getFieldSearch().clear();
    }
    public void enterTextIntoFieldSearch (String ImportantText){
        getFieldSearch().sendKeys(ImportantText);
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
    public void goURL (String URL) {
        driver.get(URL);
    }
    public void close () {
        driver.close();
    }

//    Wiki part
    public void clearFieldSearchWiki (){
        getFieldSearchWiki().clear();
    }
    public void enterTextWiki (String Text){
        getFieldSearchWiki().sendKeys(Text, Keys.DOWN, Keys.ENTER);
    }
    public String extractThePageTitleString() {
        return driver.getTitle();
    }
}
