
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class SS_Search_Jenkins {
	  private WebDriver driver;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
		  
	//**** Update below driver path accordingly
		  
		  System.setProperty("webdriver.chrome.driver", "/Users/aseth/Downloads/chromedriver");
		  //WebDriver driver = new ChromeDriver();
		 // driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }


	  @Test
	  public void testUntitled() throws Exception {
		  
		  driver.navigate().to("http://www.solesociety.com");
	  
			if (driver.findElement(By.xpath("//div[@id='newsletterPopupContainer']")).isDisplayed()) {
						System.out.println("popup is displayed");
						Thread.sleep(2000);
						driver.findElement(By.xpath("//div[@class='form popupClose']")).click();
						Thread.sleep(2000);
						System.out.println("Closed the popup");
					}
					
					driver.findElement(By.xpath("//input[@id='search']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Necklace");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[@type='submit']")).click();
					Thread.sleep(2000);
					String ConfirmationText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
					Thread.sleep(2000);
					if(ConfirmationText.equalsIgnoreCase("Search results for 'necklace'")){
						
						System.out.println("PASS");
					}
					else{
						System.out.println("Did Not PASS");
					}
					
									
			  }
	
		  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}
