import java.sql.DriverManager;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertTrue;
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
            GooglePage page = new GooglePage(driver);
            page.clearFieldSearch();
            page.enterTextIntoFieldSearch("Panda wiki");
//            page.clickEmptySpace();
//            page.clickBtnImFeelingLucky();
            page.clickLink();
        }

//        @Test
//        public void testUntitledTestCase() throws Exception {
//            driver.get("https://www.google.cz/");
//            driver.findElement(By.id("lst-ib")).clear();
//            driver.findElement(By.id("lst-ib")).sendKeys("panda");
//            driver.findElement(By.id("lga")).click();
//            driver.findElement(By.name("btnI")).click();
            // Warning: verifyTextPresent may require manual changes
//            try {
//                assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Panda velká[\\s\\S]*$"));
//            } catch (Error e) {
//                verificationErrors.append(e.toString());
//            }
//            // Warning: verifyTextPresent may require manual changes
//            try {
//                assertTrue(Pattern.compile(" *oku 2017*").matcher(driver.findElement(By.cssSelector("BODY")).getText()).find());
//            } catch (Error e) {
//                verificationErrors.append(e.toString());
//            }
//            driver.findElement(By.xpath("//a[@href='/wiki/Zraniteln%C3%BD']")).click();
//            Thread.sleep(5000);
//        }

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