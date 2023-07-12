package Project.Cucumbert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericFunction {
	public WebDriver driver;
	
	
	
	
	public GenericFunction(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public static String getProperty(String property) throws FileNotFoundException, IOException {
		Properties pro=new Properties();
		pro.load(new FileInputStream("PropertyFile.properties"));
		return pro.getProperty(property);
	}
	public void scrolltoElement(WebElement element) {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500);
		}catch(Exception e) {
			System.out.println("Exception in scroll " + e.getMessage());
		}
	}
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
	}
	
	public void waitforAlert() {
	//	WebElement locator=element;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public boolean waitforElement(WebElement element) {
		try {
			WebElement locator=element;
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(locator));
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
			
		}
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	public void alertextenteraccept() {
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("papps");				
		alert.accept();
	}

}
