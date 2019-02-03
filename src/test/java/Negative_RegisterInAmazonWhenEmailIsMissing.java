import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

import java.util.Random;

public class Negative_RegisterInAmazonWhenEmailIsMissing {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/knoldus/Documents/mehak/chromedriver");
        WebDriver driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        WebElement SignInLink = driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]//span[contains(text(), \"Hello, Sign in\")]"));
        SignInLink.click();

        Thread.sleep(5000);

        WebElement CreateYourAmazonAccountBbutton = driver.findElement(By.id("createAccountSubmit"));
        CreateYourAmazonAccountBbutton.click();

        Thread.sleep(3000);

        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        System.out.println("rand_int1: " + rand_int1);


        WebElement NameTextBox = driver.findElement(By.id("ap_customer_name"));
        NameTextBox.sendKeys("Mehak");

        Thread.sleep(3000);

        WebElement PasswordTextBox = driver.findElement(By.id("ap_password"));
        PasswordTextBox.sendKeys("test@123");

        Thread.sleep(3000);

        WebElement ConfirmPasswordTextBox = driver.findElement(By.id("ap_password_check"));
        ConfirmPasswordTextBox.sendKeys("test@123");

        Thread.sleep(3000);

        WebElement CreateYourAmazonAccountButton = driver.findElement(By.id("continue"));
        CreateYourAmazonAccountButton.click();

        WebElement ErrorMessageToEnterEmail = driver.findElement(By.xpath("//div[@id=\"auth-email-missing-alert\"]//div//div"));

        Assertion hardAssert = new Assertion();
        hardAssert.assertEquals("Enter your email", ErrorMessageToEnterEmail.getText());
        System.out.println("The Error message is as expected, as this is the negative test scenario.");

        driver.quit();


    }
}
