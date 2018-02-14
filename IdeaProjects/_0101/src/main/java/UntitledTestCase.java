import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

    public class UntitledTestCase {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {
            Class<? extends WebDriver> driverClass = ChromeDriver.class;
            WebDriverManager.getInstance(driverClass).setup();
            driver = new ChromeDriver();
            baseUrl = "https://www.google.cz";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(baseUrl);
        }

        @Test
        public void run () {
            GooglePage page = new GooglePage();
            page.clearFieldSearch();
            page.enterTextIntoFieldSearch("Panda wiki");
            page.clickEmptySpace();
            page.clickBtnImFeelingLucky();
            page.clickLink();

//            wiki part
            page.clearFieldSearchWiki();
            page.enterTextWiki("panda");
            page.extractThePageTitleString();

        }

        @After
        public void tearDown() throws Exception {
//            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
    }