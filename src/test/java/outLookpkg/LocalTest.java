package outLookpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalTest {

	public static void main(String[] args) throws Exception {
		test();
	}
	public static void test() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		System.out.println("Tittle is "+driver.getTitle());
		
		driver.quit();
	}
}
