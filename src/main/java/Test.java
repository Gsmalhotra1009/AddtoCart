import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
		public static void main(String str[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gundeep_Singh\\eclipse-workspace\\AddToCart\\src\\main\\resources\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
	       // Launch Website  
	driver.get("http://www.ebay.com");
	}
	}


