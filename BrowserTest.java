import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;

public class BrowserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver_win32\\New\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement m=driver.findElement(By.xpath("//input[@title='Search']"));//
		m.sendKeys("COVID-19");
		m.sendKeys(Keys.ENTER);
		WebElement newsElement = driver.findElement(By.linkText("News"));
		newsElement.click();
		List<WebElement> c=driver.findElements(By.xpath("//div[@role='main']//a"));
		Set<String> StrNewsAgency = new HashSet<String>();
		for ( WebElement i : c ) {			
			try {
				if(!i.findElement(By.tagName("span")).getText().trim().isEmpty()) {
					StrNewsAgency.add(i.findElement(By.tagName("span")).getText())	;
					//System.out.println(i.findElement(By.tagName("span")).getText());
				}
			}catch (NoSuchElementException e) {}

		}

		if(StrNewsAgency.size()<3) {
			System.out.println("Missing Leading News Agencies");
		}
		else {
			System.out.println("Total no. of news Agencies: "+ StrNewsAgency.size());
		}
		System.out.println(StrNewsAgency);
		driver.close();

	}

}
