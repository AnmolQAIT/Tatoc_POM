package TestByPOm;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class Basic {
	WebDriver driver;
	
	public Basic(WebDriver driver)
	{
		this.driver=driver;
	}

	public Gridgate isclickonbasicworking()
	{
		driver.findElement(By.linkText("Basic Course")).click();
		return new Gridgate(driver);
	}
	
	public boolean isbasicpage()
	{
		return driver.getCurrentUrl().equals("http://10.0.1.86/tatoc");
	}
	
    public boolean isErrorByClickingonBasicCourseLink() 
    {
    	driver.findElement(By.linkText("Basic Course")).click();
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		return url.equals("http://10.0.1.86/tatoc/basic/hover/menu");
	}
    
    public boolean isErrorByClickingonAdvanceCourseLink() 
     {
		driver.findElement(By.linkText("Advanced Course")).click();
		String url = driver.getCurrentUrl();
		driver.navigate().back();
		return url.equals("http://10.0.1.86/tatoc/advanced/hover/menu");
		
	}
}
