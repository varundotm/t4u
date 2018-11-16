package scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.ExcelData;
import generic.MainActivity;
import generic.PropertyFileRead;
import generic.ScreenCapture;
import pages.LoginPage;

public class ValidLogin extends MainActivity {

	LoginPage objLogin;

	@Test(priority=0,dataProvider="Authenticate")
	public void test_Home_Page_Appear_Correct(String userName,String passWord) throws Exception{

		logger = extent.startTest("login as "+userName);

		//Create object

		objLogin = new LoginPage(driver);

		//Verify login page title

		String loginPageTitle = objLogin.getLoginTitle();

		//    System.out.println(loginPageTitle);

		Assert.assertTrue(loginPageTitle.contains(PropertyFileRead.getProperty("loginPageTitle")));

		//login to application

		objLogin.loginTo(userName, passWord);

		//wait until page load

		Thread.sleep(6000);

		ScreenCapture.takeSnapShot(driver, ".//ScreenShot//homepage.png");
		
		logger.log(LogStatus.PASS, "Login Test Case Passed is passTest");
	}
	
	@DataProvider(name="Authenticate")
	public static Object[][] dataset() throws Exception{

		Object[][] datas=ExcelData.getTableArray(".\\src\\data\\T4U_TestData.xls", "Credential",2);

		return datas;

	}

}
