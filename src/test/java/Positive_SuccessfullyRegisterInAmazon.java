import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.util.Random;
//import java.util.concurrent.TimeUnit;

public class Positive_SuccessfullyRegisterInAmazon {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/home/knoldus/Documents/mehak/chromedriver");
        WebDriver driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        WebElement SignInLink = driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]//span[contains(text(), \"Hello\")]"));
        SignInLink.click();

        Thread.sleep(5000);

        WebElement CreateYourAmazonAccountBbutton = driver.findElement(By.id("createAccountSubmit"));
        CreateYourAmazonAccountBbutton.click();

        Thread.sleep(3000);

        Random rand = new Random();
        int randomInteger = rand.nextInt(1000);

        WebElement NameTextBox = driver.findElement(By.id("ap_customer_name"));
        NameTextBox.sendKeys("Mehak");

        Thread.sleep(3000);

        WebElement EmailTextBox = driver.findElement(By.id("ap_email"));
        EmailTextBox.sendKeys(String.format("mjuneja%d@gmail.com", randomInteger));

        Thread.sleep(3000);

        WebElement PasswordTextBox = driver.findElement(By.id("ap_password"));
        PasswordTextBox.sendKeys("test@123");

        Thread.sleep(3000);

        WebElement ConfirmPasswordTextBox = driver.findElement(By.id("ap_password_check"));
        ConfirmPasswordTextBox.sendKeys("test@123");

        Thread.sleep(3000);

        WebElement CreateYourAmazonAccountButton = driver.findElement(By.id("continue"));
        CreateYourAmazonAccountButton.click();


        new WebDriverWait(driver, 50)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//a[@id=\"nav-link-accountList\"]//span[contains(text(), \"Hello\")]")));
        Assertion hardAssert = new Assertion();
        hardAssert.assertEquals("Hello, Mehak", SignInLink.getText());
        System.out.println("The Registration has been done successfully.");

        driver.quit();

    }
}
