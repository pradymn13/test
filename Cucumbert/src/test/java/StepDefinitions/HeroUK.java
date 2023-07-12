package StepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HeroUK {
	public WebDriver driver;
	
	@Before
	public void open_browser() {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    
	}
	
	@After
	public void tearDown() {
		driver.close();
		System.out.println("Browser Closed ");
	}	  
	  
	

	@Given("Enter  URL {string}")
	public void enter_url(String url) {
		driver.get(url);
	    
	}

	@When("Click on Dropdown")
	public void click_on_dropdown() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()=\"Dropdown\"]")).click();
		Thread.sleep(1000);
		System.out.println("clicked");
	   
	}
	@When("Click checkbox value")
	public void click_checkbox_value(DataTable credentials){
		List<List<String>> data=credentials.cells();		
		driver.findElement(By.xpath("//a[text()='"+data.get(0).get(1)+"']")).click();
				
	}

	@When("Select a value {string}")
	public void select_a_value(String dropdwn) throws InterruptedException {
		Select drop =new Select(driver.findElement(By.xpath("//select[@id=\"dropdown\"]")));
		drop.selectByValue(dropdwn);
		Thread.sleep(1000);
	    
	}
	@When("Select checkboxes Value")
	public void select_checkboxes_Value() {
		driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input")).click();
	    
	}
	@When("Click on Fileupload")
	public void click_on_FileUpload() throws InterruptedException{
		driver.findElement(By.xpath("//a[text()=\"File Upload\"]")).click();  
		WebElement fileuploadbuton=driver.findElement(By.xpath("//input[@id=\"file-upload\"]")); 
		fileuploadbuton.sendKeys("C:\\Users\\pradyumna.mishra\\OneDrive - ascendion\\Desktop\\test.txt");
		WebElement filesubmit=driver.findElement(By.xpath("//input[@id=\"file-submit\"]"));    	
    	//Thread.sleep(1000);
    	filesubmit.click();
    	Thread.sleep(1000);
				
	}

	@When("Use browser back to return")
	public void use_browser_back_to_return() {
	    driver.navigate().back();
	}

	@Then("User Now in HomePage")
	public void user_now_in_home_page() {
		WebElement header = driver.findElement(By.xpath("//h2"));
		Assert.assertEquals(header.getText(), "Available Examples","not in home");
	   
	}
	@Then("Verify FileUploaded successfully")
	public void verify_file_uploaded() {
		WebElement header = driver.findElement(By.xpath("//h3"));
		Assert.assertEquals(header.getText(), "File Uploaded!","File uplaoded failed");
	   
	}
	
	

}
