package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;

	@FindBy(id="admin_id")
	public	WebElement masterAdmnistration;

	@FindBy(linkText="Master Operation")
	public WebElement masterOperation;
	
	@FindBy(linkText="Asset Operation")
	public WebElement assetOperation;
	
	@FindBy(xpath="//*[@class='userProfile']/img")
	public
	WebElement loginProfile;
	
	@FindBy(xpath="//*[@id='login-user']")
	public WebElement loginuser;
	
	

	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	
}
