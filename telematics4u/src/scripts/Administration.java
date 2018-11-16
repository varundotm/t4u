package scripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.PropertyFileRead;
import pages.DashboardPage;

public class Administration extends ValidLogin {
	DashboardPage objDB;
	
	@Test(priority=1)
	public void verifyLoginUser() throws IOException, InterruptedException {
		logger = extent.startTest("verifyLoginUser");
		objDB= new DashboardPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(objDB.loginProfile));
		objDB.loginProfile.click();
		String[] welcmUser=objDB.loginuser.getText().split(" ");
		String userName=welcmUser[1].trim();		
		Assert.assertEquals(userName, PropertyFileRead.getProperty("Username"));
		objDB.loginProfile.click();
		logger.log(LogStatus.INFO, "Login user:"+ userName);
		logger.log(LogStatus.PASS, "verifyLoginUser operation Test Case is passTest");
		
	}
	
	@Test(priority=2)
	public void navigateMasterOp() throws InterruptedException {
		logger = extent.startTest("navigateMasterOp");
		clickOnMasterOperation();
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "Navigate to Master operation Test Case Passed is passTest");
		}
	public void clickOnMasterOperation() {
		clickOnElement(objDB.masterAdmnistration);
		clickOnElement(objDB.masterOperation);
	}
	public void clickOnAssetOperation() {
		clickOnElement(objDB.masterAdmnistration);
		clickOnElement(objDB.assetOperation);
	}

}
