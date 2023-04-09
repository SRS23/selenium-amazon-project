package in.amazon.DisplayProductsTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class AppTest {
	 
    public WebDriver driver;
   
    
    @BeforeClass
    public void setup() {
      WebDriverManager.chromedriver().setup();
   	   ChromeOptions opt = new ChromeOptions();
   	   opt.addArguments("--remote-allow-origins=*");
   	   driver = new ChromeDriver(opt);

        driver.get("https://www.amazon.in");
    }
    
    
    @Test(priority=-2)
   public void AmazonProductsTest() {
    	
	   driver.get("https://www.amazon.in");
	   driver.manage().deleteAllCookies();
	  
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	   driver.manage().window().maximize();
	   
    }
    
    @Test(priority=-1)
    public void selectiphone13() {
    
    	driver.findElement(By.cssSelector("Select[aria-describedby='searchDropdownDescription']")).click();
 	   WebElement ele = driver.findElement(By.cssSelector("Select[aria-describedby='searchDropdownDescription']"));
 	   Select sel = new Select(ele);
 	   
 	   //sel.selectByIndex(16);
 	   sel.selectByVisibleText("Electronics");
 	   
 	   driver.findElement(By.id("twotabsearchtextbox")).click();
 	   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 13");
 	   driver.findElement(By.id("nav-search-submit-button")).click();
    }
    
	   @Test(priority=0)
	   public void NthProductSearch() {
		   
		   WebElement nthproduct = driver.findElement(By.xpath("//img[@data-image-index=\"12\"]"));
		   String NthProduct = nthproduct.getText();
		   System.out.println(NthProduct);
		   System.out.println();
		   
	   }
	   @Test(priority=1)
	public void ShowallProducts() {
		
		 WebElement allproduct= driver.findElement(By.xpath("//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]"));
		   String AllProducts = allproduct.getText();
		   System.out.println(AllProducts);
		   System.out.println();
		   
	}
	 @Test(priority=2)
	    public void ShowAllProductsWithScrollToEnd() {
	    	
	   JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
       
       WebElement alldisplayproduct= driver.findElement(By.xpath("//div[@class=\"sg-col-20-of-24 s-matching-dir sg-col-16-of-20 sg-col sg-col-8-of-12 sg-col-12-of-16\"]"));
	   String AllDisplayProducts =  alldisplayproduct.getText();
	   System.out.println(AllDisplayProducts);
       System.out.println();
	    }
	    
	    @AfterClass
	    public void closingbrowser() {
	   driver.quit();
	   
   }
  
  
	   
}
