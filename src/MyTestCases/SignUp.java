package MyTestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends Parameters {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test
	public void myFirstTest() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.linkText("Create an Account")).click();

		// Find elements

		WebElement firstName = driver.findElement(By.id("firstname"));
		WebElement secoundName = driver.findElement(By.id("lastname"));
		WebElement email = driver.findElement(By.id("email_address"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement createAnAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account'] span"));

		// interact with element

		firstName.sendKeys(firstNames[randomindex]);
		secoundName.sendKeys(lastNames[randomindex]);
		email.sendKeys(emailID);
		password.sendKeys(commonPassword);
		confirmPassword.sendKeys(commonPassword);

		createAnAccountButton.click();

		// Test
		String welcomeMsg = driver.findElement(By.className("message-success")).getText();
		String expectedMsg = "Thank you for registering with Main Website Store.";

		assertEquals(welcomeMsg, expectedMsg);

	}
}
