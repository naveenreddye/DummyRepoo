package outLookpkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
    	
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.google.com/");
    	Thread.sleep(5000);
    	List<WebElement> elements = driver.findElements(By.name("q"));
    	System.out.println(elements.size());
    	driver.close();
    
	}

}
