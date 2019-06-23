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
import java.util.concurrent.TimeUnit;

public class ValidLog {

        WebDriver driver;

        @Before
        public void setUp() {
            File file = new File(".\\driver\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();
            driver.get("https://accounts.google.com");
        }

        @Test
        public void userLogAndSend() {
            System.out.print("Enter ");

            WebElement login=driver.findElement(By.xpath(".//input[@id=\"identifierId\"]"));
            login.sendKeys("anykoval1356@gmail.com");
            System.out.print("Input name ");
            driver.findElement(By.xpath(".//*[@id=\"identifierNext\"]")).click();

//когда я комментирую это неиспользованное ожидание, вылетает ошибка. В чем проблема не пойму, решила оставить
            WebElement explicitWait1 = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("password")));

            driver.findElement(By.xpath(".//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("epam1356");

            System.out.print("Input password ");

            driver.findElement(By.xpath(".//*[@id=\"passwordNext\"]")).click();

            driver.findElement(By.xpath(".//*[@id=\"yDmH0d\"]")).click();


            String expectedStr = "Вітаємо, Анна Коваль!";


            WebElement waiting = (new WebDriverWait(driver, 10))
                   .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/c-wiz/div/div[4]/div/div/header/h1")));
            WebElement Welcome = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/c-wiz/div/div[4]/div/div/header/h1"));
            String strOnPage = Welcome.getText();
            System.out.println("");
            System.out.println("Actual result: " + strOnPage);
            System.out.println("Expected result: " + expectedStr);
            Assert.assertEquals(expectedStr, strOnPage);

        System.out.print("Mail ");
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement explicitWait3 = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.linkText("https://www.google.com.ua/intl/uk/about/products?tab=kh")));

        driver.findElement(By.linkText("https://www.google.com.ua/intl/uk/about/products?tab=kh")).click();
            driver.findElement(By.xpath("/*[@id=\"gb23\"]/span[1]")).click();

        driver.findElement(By.xpath("/*[@id=\":4c\"]/div/div")).click();

        WebElement receiver=driver.findElement(By.xpath("/*[@id=\":a4\"]"));
        receiver.sendKeys("happyunikorn@mailinator.com");
        WebElement subj=driver.findElement(By.xpath("/*[@id=\":9m\"]"));
        subj.sendKeys("epam");

        WebElement letter=driver.findElement(By.xpath("/*[@id=\":ar\"]"));
        subj.sendKeys("It is letter for you!");

        driver.findElement(By.xpath("//*[@id=\":9c\"]")).click();

    }

        @After
        public void tearDown() {
            driver.close();
        }
    }