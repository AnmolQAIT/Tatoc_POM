package TestByPOm;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Tatoc {
	WebDriver driver;
	Basic basic;
	Gridgate gridgate;
	FrameDungeon framedungeon;
	DragAround dragaround;
	PopupWindow popupwindow;
	CookieHandling cookiehandling;
	
	@BeforeClass
	public void Launch_driver() {
	driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		basic = new Basic(driver);
	}
	
	@Test()
	public void NotClickOnBasicCourse() {
		Assert.assertTrue(basic.isErrorByClickingonAdvanceCourseLink());
	}
	
	@Test(dependsOnMethods= {"NotClickOnBasicCourse"})
	public void ClickOnBasicCourse() {
		gridgate = basic.isclickonbasicworking();
        Assert.assertFalse(basic.isbasicpage());
	}
	
	@Test(dependsOnMethods= {"ClickOnBasicCourse"})
	public void ClickOnRedBoxinGridGate() {
		Assert.assertTrue(gridgate.isErrorByClickOnRedbox());
	}
	
	@Test(dependsOnMethods= {"ClickOnRedBoxinGridGate"})
	public void ClickOnGreenboxInGridGAte() {
		framedungeon = gridgate.isClickOnGreenBox();
		Assert.assertFalse(gridgate.isGridGatePage());
		
	}
	
	@Test(dependsOnMethods= {"ClickOnGreenboxInGridGAte"})
	public void NotMatchColor() {
		Assert.assertTrue(framedungeon.isErrorByClickProceedWithoutMatch());
	}
	
	@Test(dependsOnMethods= {"NotMatchColor"})
	public void MatchColorInBoxes() {
		dragaround = framedungeon.MatchtheColorInBoxes();
		Assert.assertFalse(framedungeon.isFrameDungeonPage());
	}
	
	@Test(dependsOnMethods= {"MatchColorInBoxes"})
	public void ProceedWithoutDragingTheBox() {
		Assert.assertTrue(dragaround.isErrorPageByProceedingWihoutDraging());
	}
	
	
	@Test(dependsOnMethods= {"ProceedWithoutDragingTheBox"})
	public void DragAndDropBoxToCorrectDropbox() {
		popupwindow = dragaround.DragAndDropbox();
		Assert.assertFalse(dragaround.isDragAroundPage());
	}
	
	@Test(dependsOnMethods= {"DragAndDropBoxToCorrectDropbox"})
	public void ClickProceedWithoutOpeningPopupWindow() {
		Assert.assertTrue(popupwindow.isErrorPageOnClickOfProceed());
	}
	
	@Test(dependsOnMethods= {"ClickProceedWithoutOpeningPopupWindow"})
	public void ClickOnPopupLinkAndFillTheName() {
		cookiehandling = popupwindow.ClickOnPopupAndFilltheField();
		Assert.assertFalse(popupwindow.isPopUpPage());
		
	}
	
	@Test(dependsOnMethods= {"ClickOnPopupLinkAndFillTheName"})
	public void ClickProceedWithoutCreatingCookie() {
		Assert.assertTrue(cookiehandling.isErrorPageWithoutCreatingCookie());
	}
	
	@Test(dependsOnMethods= {"ClickProceedWithoutCreatingCookie"})
	public void CreateCookieOnpage() {
		Assert.assertTrue(cookiehandling.isCookieSuccessfullyAdded());
	} 
  
}
