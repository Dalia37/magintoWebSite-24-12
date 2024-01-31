package MyTestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

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

	@Test(priority = 1)
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

	@Test(priority = 2)
	public void logoutProcess() {
		// interact
		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
		// test
		boolean actual = driver.getCurrentUrl().contains("logoutSuccess");
		assertEquals(actual, true);

	}

	@Test(priority = 3)
	public void loginProcess() throws InterruptedException {
		// interact
		driver.findElement(By.linkText("Sign In")).click();
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		email.sendKeys(emailID);
		password.sendKeys(commonPassword);
		WebElement loginbtn = driver.findElement(By.id("send2"));
		loginbtn.click();
		// test
		Thread.sleep(2000);
		boolean actual = driver.findElement(By.cssSelector(".greet.welcome")).getText().contains("Welcome");
		assertEquals(actual, true);

	}

	@Test(priority = 4)
	public void AddOneRandomItem() throws InterruptedException {
		// interaction
		driver.get("https://magento.softwaretestingboard.com/");

		WebElement ItemsContainer = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));

		int numberofitems = ItemsContainer.findElements(By.tagName("li")).size();
		System.out.println(numberofitems);

		int randomItemToSelect = rand.nextInt(4);
		ItemsContainer.findElements(By.tagName("li")).get(randomItemToSelect).click();
		

		WebElement sizesContainer = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		int theSizes = sizesContainer.findElements(By.className("swatch-option")).size();
		sizesContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theSizes)).click();
		Thread.sleep(2000);

		WebElement colorsContainer = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		int theColors = colorsContainer.findElements(By.className("swatch-option")).size();
		colorsContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theColors)).click();
		Thread.sleep(2000);
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(3000);

		String ActualMsg = driver.findElement(By.cssSelector(".page.messages")).getText();
		//test

		assertEquals(ActualMsg.contains("You added"), true);

	}

}
