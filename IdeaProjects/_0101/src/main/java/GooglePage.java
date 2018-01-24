import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePage {
    private String FieldSearch = "lst-ib";
    private String BtnSearch = "btnI";
    private String LinkZnic = "//a[@href='/wiki/Zraniteln%C3%BD']";
    private WebDriver driver;
//    private WebDriver driver = new ChromeDriver()
    GooglePage (WebDriver driver2) {
        driver = driver2;
        }

    private WebElement getFieldSearch (){
        return driver.findElement(By.id(FieldSearch));
    }
    private WebElement getBtnSearch (){
        return driver.findElement(By.name(BtnSearch));
    }
    private WebElement getLinkZnic (){
        return driver.findElement(By.xpath(LinkZnic));
    }
    public void clearFieldSearch (){
        getFieldSearch().clear();
    }
    public void enterTextIntoFieldSearch (String ImportantText){
        getFieldSearch().sendKeys(ImportantText);
    }
    public void clickBtnSearch (){
        getBtnSearch().click();
    }
    public void clickLink (){
        getLinkZnic().click();
    }
}
