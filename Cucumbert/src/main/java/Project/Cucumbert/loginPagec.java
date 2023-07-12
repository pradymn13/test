package Project.Cucumbert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPagec {
	WebDriver driver;
	GenericFunction genericFunction;
	
	@FindBy(xpath="//a[text()=\"Practice\"]")
	private WebElement practicelink;
	
	@FindBy(xpath="//a[text()=\"Test Login Page\"]")
	private WebElement loginpagelink;
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement pwd;
	
	@FindBy(id="submit")
	private WebElement submit;
	
	@FindBy(xpath="//div[@class=\"post-header\"]/h1")
	private WebElement verifyT;
	
	public loginPagec(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		genericFunction=new GenericFunction(driver);
	}
	
	public void enterUrl(String url) {
		try {
    		driver.get(url); 		
    		
    	}catch(Exception e) {
    		e.getMessage();
    	}
		
	}
		
    public void clickPractice() {
    	try {
    		genericFunction.waitforElement(practicelink);
    		practicelink.click();   		
    		
    	}catch(Exception e) {
    		e.getMessage();
    	}
    }
    public void clicktestLogin() {
    	try {
    		genericFunction.waitforElement(loginpagelink);
    		loginpagelink.click(); 
    		Thread.sleep(1000);
    		
    	}catch(Exception e) {
    		e.getMessage();
    	}
    }
    public void enterDetails(String usern,String pwd1) {
    	try {
    		genericFunction.waitforElement(username);
    		username.sendKeys(usern);
    		Thread.sleep(1000);
    		genericFunction.waitforElement(pwd);
    		pwd.sendKeys(pwd1);
    		    		
    	}catch(Exception e) {
    		e.getMessage();
    	}
    }
    public void clickSubmit() {
    	try {
    		genericFunction.waitforElement(submit);
    		submit.click(); 
    		Thread.sleep(2000);
    		
    	}catch(Exception e) {
    		e.getMessage();
    	}
    }
    public void verifysubmit() {
    	try {
    		genericFunction.waitforElement(verifyT);
    		Assert.assertEquals(verifyT.getText(), "Logged In Successfully","Not equal");
    		
    	}catch(Exception e) {
    		e.getMessage();
    	}
    }
    
	}
	


