import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "../SeleniumLatest/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> str = driver.getWindowHandles();
		Iterator<String> it = str.iterator();
		String parentId =  it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com/");
		
		String c1 = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		driver.switchTo().window(parentId);
		WebElement nm = driver.findElement(By.name("name"));
		nm.sendKeys(c1);
		
		System.out.println(nm.getRect().getDimension().getHeight());
		System.out.println(nm.getRect().getDimension().getWidth());
		
		File f = nm.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("name.jpg"));
		
	}

}
