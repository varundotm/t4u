package scripts;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.MasOperPage;


public class Logout extends CustomerInfo{
	Actions act;
	MasOperPage objMas;
	@Test(priority=21)
	public void logout() throws InterruptedException {
		logger = extent.startTest("logout");
		driver.switchTo().defaultContent();
		objMas = new MasOperPage(driver);
		act = new Actions(driver);
		act.moveToElement(objMas.userProfile).click().build().perform();
		Thread.sleep(3000);
		act.moveToElement(objMas.signout).click().build().perform();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("Log Out"));
		System.out.println("Logout successfully!!");
		logger.log(LogStatus.PASS, "Logout Test Case Passed is passTest");
	}

}
