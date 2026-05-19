package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	WebDriver driver;
	
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	   
		driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}

	@When("the user enters valid credentials and then click on login button")
	public void the_user_enters_valid_credentials_and_then_click_on_login_button() {
	   
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//System.out.println(driver.getPageSource());
		
		WebElement un = wait.until(
			    ExpectedConditions.presenceOfElementLocated(By.name("username"))
			);
		
		//WebElement un =  driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement pwd = driver.findElement(By.name("password"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		
	
		/*
		 * System.out.println(driver.findElement(By.xpath(
		 * "//input[@placeholder='Username']")).isDisplayed());
		 * System.out.println(driver.findElement(By.xpath(
		 * "//input[@placeholder='Username']")).isEnabled());
		 */

		
		un.sendKeys("Admin");
		pwd.sendKeys("admin123");
		loginBtn.click();
		
	}

	@Then("the user should be redirected to the home page of the application")
	public void the_user_should_be_redirected_to_the_home_page_of_the_application() throws InterruptedException {
	   
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
		
		Thread.sleep(5000);
		//driver.quit();
	}


	
}
