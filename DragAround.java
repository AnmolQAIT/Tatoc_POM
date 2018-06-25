package TestByPOm;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class DragAround {
	WebDriver driver;
	
	public DragAround(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean isDragAroundPage() {
		return driver.getCurrentUrl().equals("http://10.0.1.86/tatoc/basic/drag");
	}
	
	public PopupWindow DragAndDropbox() 
	{
		WebElement dragbox = driver.findElement(By.id("dragbox"));
		WebElement dropbox = driver.findElement(By.id("dropbox"));
		Actions actions  = new Actions(driver);
		actions.dragAndDrop(dragbox, dropbox).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
		return new PopupWindow(driver);
	}

	public boolean isErrorPageByProceedingWihoutDraging() 
	{
		driver.findElement(By.linkText("Proceed")).click();
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		return url.equals("http://10.0.1.86/tatoc/error");

	}
	
}
