package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Project.Cucumbert.loginPagec;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class practicelogin {
	
	public WebDriver driver;
	loginPagec login;
	
	
	 
	
	@Before
	public void open_browser() {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	
		login=new loginPagec(driver);
	    
	}
	
	@After
	public void tearDown() {
		driver.close();
		System.out.println("Browser Closed ");
	}
	
	@Given("Enter the URLl {string}")
	public void enter_the_URLl(String url) {
		login.enterUrl(url);	
	    
	}
	
	@When("Click on Practice")
	public void click_on_practice() {
		login.clickPractice();
	   
	}

	@When("Click on Test Login Page")
	public void click_on_test_login_page() {
	 login.clicktestLogin();
	}

	@When("Enter valid username {string} and password {string}")
	public void enter_valid_username_and_password(String username, String password) {
	    login.enterDetails(username, password);
	}

	@When("Click on Submit Button")
	public void click_on_submit_button() {
		login.clickSubmit();
		
	    
	}

	@Then("Verify logged in successfully")
	public void verify_logged_in_successfully() {
		login.verifysubmit();
	    
	}

}
