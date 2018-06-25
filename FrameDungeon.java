package TestByPOm;

import org.openqa.selenium.*;

public class FrameDungeon {
	WebDriver driver;
	public FrameDungeon(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public DragAround MatchtheColorInBoxes() 
	{
		driver.switchTo().frame(0);
		WebElement box1 = driver.findElement(By.id("answer"));
		String Box1_color = box1.getAttribute("class");
		String Box2_color = "";
	   while(!Box1_color.equals(Box2_color)){
		  
		   driver.switchTo().defaultContent();
		    driver.switchTo().frame(0);
		    driver.findElement(By.cssSelector("a")).click();
		    driver.switchTo().frame(0);
		    Box2_color=driver.findElement(By.id("answer")).getAttribute("class");
		     }
	   driver.switchTo().defaultContent();
	   driver.switchTo().frame(0).findElement(By.linkText("Proceed")).click();
	   return new DragAround(driver);
	}
	
	public boolean isErrorByClickProceedWithoutMatch() 
	{
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("Proceed")).click();
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		return url.equals("http://10.0.1.86/tatoc/error");
	}
	
	
	public boolean isFrameDungeonPage() {
		
		return driver.getCurrentUrl().equals("http://10.0.1.86/tatoc/basic/frame/dungeon");
	}

}
