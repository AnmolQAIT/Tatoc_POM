package TestByPOm;

import org.openqa.selenium.*;

public class Gridgate {
	WebDriver driver;

	public Gridgate(WebDriver driver)
	{
		this.driver=driver;
	}
	public FrameDungeon isClickOnGreenBox()
	{
		driver.findElement(By.className("greenbox")).click();
		return new FrameDungeon(driver);
	}
	
	public boolean isGridGatePage() {
		return driver.getCurrentUrl().equals("http://10.0.1.86/tatoc/basic/grid/gate");
	}
	
	public boolean isErrorByClickOnRedbox() {
		driver.findElement(By.className("redbox")).click();
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		return url.equals("http://10.0.1.86/tatoc/error");
	}
}
