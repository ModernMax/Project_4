package seleniumtests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class AbstractTest {

        private WebDriver driver;
        private static String url = "https://qa-scooter.praktikum-services.ru/";

        @Before
        public void setup() {
            driver = new ChromeDriver();
            getWebDriver().get(url);
        }

        @After
        public void teardown() {
            driver.quit();
        }

        public WebDriver getWebDriver() {
            return driver;
        }
    }
