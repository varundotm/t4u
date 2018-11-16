package generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;

public class MainActivity {

	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	HomePage objHome;


	@BeforeTest

	public void setup() throws IOException{

		extent = new ExtentReports (System.getProperty("user.dir") +"/extend-output/STMExtentReport.html", true);
		// getProperty("/ExtendReport/STMExtentReport.html", true));
		//extent.addSystemInfo("Environment","Environment Name")
		extent
		.addSystemInfo("Host Name", "https://www.telematics4u.in")
		.addSystemInfo("Environment", "Automation Testing")
		.addSystemInfo("User Name", "Varun M");
		//loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
		//You could find the xml file below. Create xml file in your project and copy past the code mentioned below
		extent.loadConfig(new File(System.getProperty("user.dir")+"/drivers/extent-config.xml"));


		String browserName=PropertyFileRead.getProperty("browserName");

		if("Chrome".equals(browserName)) {

			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(PropertyFileRead.getProperty("URL"));

		driver.manage().window().maximize();

	}

	//@Test(priority=9,dependsOnMethods= {"login"})
	public void clickLaunch()  {
		try{
			//BrokenLinks.finBrokenlink(driver);
			objHome= new HomePage(driver);
			objHome.setSearchBox();
			Thread.sleep(3000);
			objHome.clickOnLaunch();
			Thread.sleep(5000);
			objHome.verifyUser();

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void failScreenShot(ITestResult result) {

		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);

		if(ITestResult.FAILURE==result.getStatus()){
			try{
				String filePath=".//ScreenShot//SN"+LocalDateTime.now()+".png";
				ScreenCapture.takeSnapShot(driver, filePath);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}

	@AfterTest
	public void closeCon() throws InterruptedException {
		extent.flush();
		extent.close();
		Thread.sleep(2000);
		//driver.quit();
	}

	public void sendKey(WebElement element,String string) throws InterruptedException {
		element.clear();
		if(string.isEmpty()||string==null) {
			element.sendKeys("   ");
		}else {
		element.sendKeys(string);
		}
		Thread.sleep(1000);
	}
	
	
	
	public void comboBox(WebElement element,String string) throws InterruptedException {

		element.clear();
		Thread.sleep(800);
		element.sendKeys(string);
		Thread.sleep(1200);
		element.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(300);
		element.sendKeys(Keys.ENTER);
	}
	
	public void checkBox(WebElement element) {
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void clickOnElement(WebElement element) {
		
		element.click();
		
	}
	
	public boolean isElementPresent(WebElement element){
        try{
        	element.isEnabled();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
	public static void chechboxSelect(WebElement element1,WebElement element2) {
		System.out.println(element1.getAttribute("class").contains("selected"));
		if(!element1.getAttribute("class").contains("selected")) {
			element2.click();
		}
	}
	
	public void clickdisplayedBtn(List<WebElement> element) throws InterruptedException {
		Thread.sleep(3000);
		for(WebElement ele: element) {
			if(ele.isDisplayed()) {
				ele.click();
				break;
			}
		}
	}
	public void sendTodisplayedTxt(List<WebElement> element,String input) throws InterruptedException {
		Thread.sleep(3000);
		for(WebElement ele: element) {
			if(ele.isDisplayed()) {
				ele.clear();
				ele.sendKeys(input);
				break;
			}
		}
	}
	
	public void sendTodisplayedCombo(List<WebElement> element,String string) throws InterruptedException {
		Thread.sleep(3000);
		for(WebElement ele: element) {
			if(ele.isDisplayed()) {
				ele.clear();
				Thread.sleep(800);
				ele.sendKeys(string);
				Thread.sleep(1200);
				ele.sendKeys(Keys.ARROW_DOWN);
				ele.sendKeys(Keys.ENTER);
				break;
			}
		}
	}
	public void clrDisEle(List<WebElement> element) {
		for(WebElement ele: element) {
			if(ele.isDisplayed()) {
				ele.clear();
				break;
	}
		}
	}
	public void scrollTo(WebElement element) {
	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void loggerInfo(String name,String address,String country,String state,String city,String phoneNo,String zipcode, String mobileNo, String fax, String mail,String webSite, String date,String notificationPeriod, String speedLimit,String snooze) {
		logger.log(LogStatus.INFO, "Name: "+name);
		logger.log(LogStatus.INFO, "Address: "+address);
		logger.log(LogStatus.INFO, "Country: "+ country);
		logger.log(LogStatus.INFO, "State: "+state);
		logger.log(LogStatus.INFO, "City: "+city);
		logger.log(LogStatus.INFO, "Phone Number: "+phoneNo);
		logger.log(LogStatus.INFO, "Zip code: "+zipcode);
		logger.log(LogStatus.INFO, "Mobile Number: "+mobileNo);
		logger.log(LogStatus.INFO, "Fax Number: "+fax);
		logger.log(LogStatus.INFO, "Mail: "+mail);
		logger.log(LogStatus.INFO, "Website: "+webSite);
		logger.log(LogStatus.INFO, "Date: "+date);
		logger.log(LogStatus.INFO, "Notification period: "+notificationPeriod);
		logger.log(LogStatus.INFO, "Speed Limit: "+speedLimit);
		logger.log(LogStatus.INFO, "Snooze: "+snooze);
	}
	
	public void checkFrames() {
		int i=0;
		for(WebElement ele:objHome.frames) {
			System.out.println(i+": "+ele.getAttribute("src"));
			i++;		
		}
	}
}
