package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Mytest {
	WebDriver driver = null;
	WebElement ele = null;
	Boolean flag = null;
	
	@Before
	public void start() {
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com/samples/basiccontact.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	
		
	}
	@Given("User is on home page of contact form")
	public void user_is_on_home_page_of_contact_form() {
		
		ele = driver.findElement(By.xpath("//*[@id=\"header\"]/h1"));
		if(ele.isDisplayed())System.out.println("======User is on home page========");
	}

	@Then("User fills the details {string} and {string}")
	public void user_fills_the_details_and(String string, String string2) {
	    driver.findElement(By.xpath("//input[@name='q[1]']")).sendKeys(string);
	    driver.findElement(By.xpath("//input[@name='email']")).sendKeys(string2);
	    
	    driver.findElement(By.xpath("//textarea[@name='q[2]']")).sendKeys("This is my task");
	    driver.findElement(By.xpath("//input[@name='submit']")).click();
	    
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println("============User details are submitted============ ");
	    
	}
	@After
	public void end() {
		driver.quit();
	}
}
