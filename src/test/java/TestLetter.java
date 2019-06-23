import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
public class TestLetter {
    private WebDriver driver;

    public TestLetter(WebDriver driver) {
        this.driver = driver;
    }

    private By inputField = By.xpath("/*[@id='inboxfield']");
    private By OkeyButton = By.xpath("/*[@id=\"header-1\"]/nav/div/div[1]/div[1]/div[3]/div/span/button");
    private By ReadButton = By.xpath("/*[@id=\"row_happyunikorn-1561280690-5014292\"]/td[3]");

    public TestLetter typeEmail(String email) {
        driver.findElement(inputField).sendKeys(email);
        return this;
    }

    public TestLetter ClickOkeyButton() {
        driver.findElement(OkeyButton).click();
        return this;
    }

    public String GetSenderName() {
        String senderOnPage= driver.findElement(By.xpath("/*[@id=\"row_happyunikorn-1561280690-5014292\"]/td[3]")).getText();

        return senderOnPage;
    }
    public String GetSubjectName() {
        String subjectOnPage= driver.findElement(By.xpath("/*[@id=\"row_happyunikorn-1561280690-5014292\"]/td[4]")).getText();
        return subjectOnPage;
    }
    public String GetText() {
        String textOnPage= driver.findElement(By.xpath("/*[@id=\"row_happyunikorn-1561280690-5014292\"]/td[3]")).getText();

        return textOnPage;
    }

    public TestLetter ReadLeter() {

        String Sender = "Анна Коваль";
        String SenderOnPage = driver.findElement(By.xpath("/*[@id=\"row_happyunikorn-1561280690-5014292\"]/td[3]")).getText();
        String Subject = "epam";
        String SubjectOnPage = driver.findElement(By.xpath("/*[@id=\"row_happyunikorn-1561280690-5014292\"]/td[4]")).getText();
        driver.findElement(By.xpath("/*[@id=\"row_happyunikorn-1561280690-5014292\"]/td[4]")).click();

        System.out.println("Actual result: " + SenderOnPage);
        System.out.println("Expected result: " + Sender);
        Assert.assertEquals(Sender, SenderOnPage);
        System.out.println("Actual result: " + SubjectOnPage);
        System.out.println("Expected result: " + Subject);
        Assert.assertEquals(Subject, SubjectOnPage);

        String TextOnPage = driver.findElement(By.xpath("/html/body/div")).getText();
        String textLetter = "It is letter fot you!";
        System.out.println("Actual result: " + TextOnPage);
        System.out.println("Expected result: " + textLetter);
        Assert.assertEquals(TextOnPage, textLetter);

        return this;
    }
}