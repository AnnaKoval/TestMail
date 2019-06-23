import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class InvalidLog {

        WebDriver driver;

        @Before
        public void setUp() {
            File file = new File(".\\driver\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
             driver = new ChromeDriver();
            driver.get("https://accounts.google.com");
        }

        @Test
        public void userLog() {
             driver = new ChromeDriver();
            driver.get("https://accounts.google.com");
            System.out.print("Enter ");

            WebElement login=driver.findElement(By.xpath(".//input[@id=\"identifierId\"]"));
            login.sendKeys("anykoval1356@gmail.com");
            System.out.print("Input name ");
            driver.findElement(By.xpath(".//*[@id=\"identifierNext\"]")).click();


            WebElement explicitWait = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("password")));

            driver.findElement(By.xpath(".//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("invalid pass");
            System.out.print("Input password ");
            driver.findElement(By.xpath(".//*[@id=\"passwordNext\"]")).click();

            String expectedStr = "Неверный пароль. Повторите попытку или нажмите на ссылку \"Забыли пароль?\", чтобы сбросить его.";


            WebElement waiting = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]/div[2]/div[2]/div")));
            WebElement InvalidPass = driver.findElement(By.xpath("//*[@id=\"password\"]/div[2]/div[2]/div"));
            String strOnPage = InvalidPass.getText();
            System.out.println("");
            System.out.println("Actual result: " + strOnPage);
            System.out.println("Expected result: " + expectedStr);
            Assert.assertEquals(expectedStr, strOnPage);
        }


        @After
        public void tearDown() {
            driver.close();
        }
    }

