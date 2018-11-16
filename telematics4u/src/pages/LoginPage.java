package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(name="userName")

	WebElement userName;

	@FindBy(name="password")

	WebElement password;
	
	@FindBy(xpath="//input[@type='button']")

	WebElement login;


	public LoginPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//Set user name in textbox

	public void setUserName(String strUserName){

		userName.sendKeys(strUserName);

	}

	//Set password in password textbox

	public void setPassword(String strPassword){

		password.sendKeys(strPassword);

	}

	//Click on login button

	public void clickLogin(){

		login.click();

	}

	//Get the title of Login Page

	public String getLoginTitle(){
    
		return    driver.getTitle();

	}

	public void loginTo(String strUserName,String strPasword){

		//Fill user name

		this.setUserName(strUserName);

		//Fill password

		this.setPassword(strPasword);

		//Click Login button

		this.clickLogin();        

	}
}
