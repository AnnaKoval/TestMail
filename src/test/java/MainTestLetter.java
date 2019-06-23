import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class MainTestLetter {
    static WebDriver driver;
    public static void main(String[] args) {
        File file = new File(".\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.get("https://www.mailinator.com");
        TestLetter testLetter=new TestLetter(driver);
        testLetter.typeEmail("anykoval1356@gmail.com");
        testLetter.ClickOkeyButton();
        testLetter.ReadLeter();
    }
}