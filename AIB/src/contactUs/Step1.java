package contactUs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Step1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String browser = "Chrome";
		WebDriver driver = null;
		
		if(browser.equals("Chrome")){
			driver = new ChromeDriver();
		}else if (browser.equals("Firefox")){
			driver = new FirefoxDriver();
		}else if (browser.equals("IE")){
			driver = new InternetExplorerDriver();
		}else if (browser.equals("MSEdge")){
			driver = new EdgeDriver();
		}
		
		//Launch the browser and navigate to AIB Contact Us Form
		driver.get("https://aib.ie/personal-forms/contactusform");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Accepting and Closing the Cookies pop-up
		driver.findElement(By.id("acceptCookies")).click();
		
		//Selecting an option from "Contact us regarding" drop down
		WebElement dropDown = driver.findElement(By.id("personal_contactus_personalform_contactus"));
		Select contact = new Select (dropDown);
		contact.selectByIndex(3);
		
		//Selecting an option from "Preferred Contact Time" drop down
		WebElement dropDown2 = driver.findElement(By.id("personal_contactus_personalform_preferredtime"));
		Select time = new Select (dropDown2);
		time.selectByIndex(2);
		
		//Selecting an option from "Title" drop down
		WebElement dropDown3 =driver.findElement(By.id("personal_contactus_personalform_title"));
		Select title = new Select (dropDown3);
		title.selectByValue("Mrs");
		
		//Set the First Name value
		driver.findElement(By.id("personal_contactus_personalform_firstname")).sendKeys("John");
		
		//Set the Surname value
		driver.findElement(By.id("personal_contactus_personalform_surname")).sendKeys("Cook");
		
		//Set the Email Address value
		driver.findElement(By.id("personal_contactus_personalform_email")).sendKeys("aib@test.com");
		
		//Set the Address value
		driver.findElement(By.id("personal_contactus_personalform_address")).sendKeys("London,UK");
		
		//Set the Contact number value
		driver.findElement(By.id("personal_contactus_personalform_contactnumber_home")).sendKeys("447843456789");
		
		//Set the Comments value
		driver.findElement(By.id("personal_contactus_personalform_comments")).sendKeys("Please contact me");
		
		//Click on the Submit button
		driver.findElement(By.id("personal_contactus_submit")).click();
		
		Thread.sleep(4000);
		
		//Validates Email Address
		if(driver.findElement(By.id("fmsg_personalform_email")).isDisplayed())
		{System.out.println("Fail");
		driver.quit();
		}else if (driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div/div/div[1]/div[1]/h3")).isDisplayed())
		{System.out.println("Pass");
		driver.quit();
		}
		
	}

}
