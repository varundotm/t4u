package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import generic.PropertyFileRead;

public class HomePage {
	
	@FindBy(id="search-input")
	WebElement searchBox;

	@FindBy(xpath="//table[@class='x-grid3-row-table']/tbody/tr/td[5]/div")
	WebElement launch;

	@FindBy(xpath="//*[@id='gn-menu']/li[11]/a/span/img")
	public	static	WebElement myAcc;

	@FindBy(xpath="//*[@id='login-user']")
	WebElement userName;
	
	@FindBy(xpath="//*[@id='userAuthority']")
	WebElement role;
	
	@FindBy(tagName="iframe")
	public List<WebElement> frames;
	
	private WebDriver driver;
	Actions act;
	
	
	@FindBy(xpath="//*[@id='logoutId']/a")
	public static WebElement logoutelmt;

	public HomePage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void setSearchBox() throws AWTException, InterruptedException, IOException {
		driver.switchTo().frame(0);
		searchBox.sendKeys(PropertyFileRead.getProperty("clientName"));
		Thread.sleep(1000);
		Robot rbt=new Robot();
		rbt.keyPress(40);
		rbt.keyRelease(40);
		Thread.sleep(1000);
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
	}
	public void clickOnLaunch() {
		
		launch.click();
	}
	public void verifyUser() throws InterruptedException, IOException {
		act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(myAcc).click().build().perform();
		Thread.sleep(2000);
		String[] user=userName.getText().split(" ");
		String userNAme=user[1].trim();
		Assert.assertEquals(userNAme, PropertyFileRead.getProperty("Username"));
		Thread.sleep(3000);
		act.moveToElement(myAcc).click().build().perform();
		Thread.sleep(3000);
	}
	public void verifyUserandRole() throws InterruptedException, IOException {
		act = new Actions(driver);
		act.moveToElement(myAcc).click().build().perform();
		Thread.sleep(2000);
		String userNAme=userName.getText();
		String Role=role.getText();
		String[] userRole=Role.split(":");
		String loginRole=userRole[1].trim();
		System.out.println("Username: "+userNAme);
		System.out.println("loginRole: "+loginRole);
		Assert.assertEquals(userNAme, PropertyFileRead.getProperty("Username"));
		Thread.sleep(3000);
		act.moveToElement(myAcc).click().build().perform();
		Thread.sleep(3000);
	}

}
