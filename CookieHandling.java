package TestByPOm;

import org.openqa.selenium.*;
import org.openqa.selenium.Cookie;


public class CookieHandling {
	WebDriver driver;
	
	public CookieHandling(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean isCookieHAndlinkPage() {
		return driver.getCurrentUrl().equals("http://10.0.1.86/tatoc/basic/cookie");
	}
	
	public boolean isCookieSuccessfullyAdded() {
		 driver.findElement(By.linkText("Generate Token")).click();
		    String token_text = driver.findElement(By.id("token")).getText();
		    String token = token_text.substring(token_text.indexOf(":")+2);
		    Cookie cookie=new Cookie("Token",token);
		    driver.manage().addCookie(cookie);
		    driver.findElement(By.linkText("Proceed")).click();
		    return driver.getCurrentUrl().equals("http://10.0.1.86/tatoc/end");
	}
	
	public boolean isErrorPageWithoutCreatingCookie() {
		 driver.findElement(By.linkText("Proceed")).click();
		 String url = driver.getCurrentUrl();
		 driver.navigate().back();
		 return url.equals("http://10.0.1.86/tatoc/error");
	}

}
