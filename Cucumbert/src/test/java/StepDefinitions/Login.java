package StepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
//import cucumber.api.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	public WebDriver driver;
	@Given("Open the browser")
	public void open_the_browser() {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	    
	}

	@When("Enter the URL {string}")
	public void enter_the_URL(String url) {
		driver.get(url);
	    
	}

	@When("Click on My Account Menu")
	public void click_on_my_account_menu() {
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
	  
	}

	@When("Enter registered username and password")
	public void enter_registered_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("pavanoltraining");
		driver.findElement(By.id("password")).sendKeys("Test@selenium123"); 
	    
	}
	
	@And("Enter registered username {string} and password {string}") 
	public void enter_registered_username_and_password(String user, String pwd) {
	  driver.findElement(By.id("username")).sendKeys(user);
	  driver.findElement(By.id("password")).sendKeys(pwd); 
	  }
	
	@When("Enter registered username and passwords")
	public void enter_registered_username_and_password(DataTable credentials){
		List<List<String>> data=credentials.cells();
		driver.findElement(By.id("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));		
	}

	@When("Click on login button")
	public void click_on_login_button() {
		driver.findElement(By.name("login")).click();
	  
	}

	@Then("User must successfully login to the web page")
	public void user_must_successfully_login_to_the_web_page() {
		 String capText= driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/p[1]/strong")).getText();
		  System.out.println(capText);
		  Assert.assertEquals(true,capText.contains("pavanoltraining"));
	   
	}
	
	@Then("^Verify login$")
	public void very_login() throws Throwable {
		String capText=driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li/strong")).getText();
		if(capText.contains("Error")) // Test for invalid inputs
		{
			Assert.assertTrue(true,"Invalid input - Error Page");
			
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	
	//Datadriven testing using datatable List
		//LOGIN WITH DATATABLE METHOD USING HEADER--MAP Table
			//Note:credentials.raw method is deprecated instead we can use cells() method
			@And("Enter registered username and passwordd")
			public void enter_registered_username_and_password1(DataTable credentials){
				List<Map<String, String>> data=credentials.asMaps(String.class,String.class);
				driver.findElement(By.id("username")).sendKeys(data.get(0).get("username"));
				driver.findElement(By.id("password")).sendKeys(data.get(0).get("password"));
				
//				for(Map<String, String> data : credentials.asMaps(String.class, String.class)){
//					driver.findElement(By.id("username")).sendKeys(data.get("username"));
//					driver.findElement(By.id("password")).sendKeys(data.get("password"));
//				}
				
				
			}
	
//	@After
//	public void tearDown() {
//		driver.close();
//		System.out.println("Browser Closed ");
//	}


}
