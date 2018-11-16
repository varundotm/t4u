package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import generic.MainActivity;
import generic.PropertyFileRead;

public class MasOperPage extends MainActivity {

	WebDriver driver;

	//Customer info table

	@FindAll({ @FindBy(xpath="//thead/tr/td") })
	public List<WebElement> tableCol;

	@FindAll({@FindBy(xpath="//thead/tr")})
	public List<WebElement> tableRow;


	//Customer information add

	@FindBy(xpath="//*[@id='ext-comp-1076']/table/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td[2]/em/button")
	WebElement addbtn;

	//create customer
	@FindBy(xpath="//*[@id='custname']")
	public WebElement custname;

	@FindBy(xpath="//*[@id='custaddress']")
	public	WebElement address;

	@FindBy(xpath="//*[@id='custcountry']")
	public	WebElement country;

	@FindBy(xpath="//*[@id='custstate']")
	public	WebElement state;

	@FindBy(xpath="//*[@id='custcity']")
	public	WebElement city;

	@FindBy(xpath="//*[@id='custphoneno']")
	public	WebElement phone;

	@FindBy(xpath="//*[@id='custzipcode']")
	public	WebElement custzipcode;

	@FindBy(xpath="//*[@id='custmobileno']")
	public	WebElement custmobileno;

	@FindBy(xpath="//*[@id='custfax']")
	public	WebElement custfax;

	@FindBy(xpath="//*[@id='PAYMENTDUE_DATEfield']")
	public	WebElement PAYMENTDUE_DATEfield;

	@FindBy(xpath="//*[@id='custwebsite']")
	public	WebElement custwebsite;

	@FindBy(xpath="//*[@id='PAYMENT_NOTIFICATIONPERIODfield']")
	public	WebElement PAYMENT_NOTIFICATIONPERIODfield;

	@FindBy(xpath="//*[@id='speedLimitId']")
	public	WebElement speedLimitId;

	@FindBy(xpath="//*[@id='custemailid']")
	public	WebElement custemailid;

	@FindBy(xpath="//*[@id='snoozeId']")
	public	WebElement snoozeId;

	@FindBy(xpath="//*[button='Save']/button")
	public	WebElement savebtn;

	//update customer
	@FindBy(xpath="//*[@id='custnewname']")
	public WebElement u_custname;

	@FindBy(xpath="//*[button='Delete']/button")
	WebElement deletebtn;

	@FindBy(id="msg-div")
	WebElement alertmsg;

	@FindBy(xpath="//*[@id='header']")
	public	WebElement alertText;

	@FindBy(xpath="//table/thead/tr/td[4]/div/a")
	WebElement dropColumn;

	@FindBy(xpath="//*[@class='x-menu-list']/li[9]/a")
	WebElement filterbtn;

	@FindBy(xpath="//*[@class='x-menu-list']/li/input")
	WebElement filterin;

	@FindBy(xpath="//table[@id='modifyId']/tbody/tr[2]/td[2]/em/button")
	public WebElement modifbtn;

	@FindBy(xpath="//*[@id='addButtId']/tbody/tr[2]/td[2]/em/button")
	public WebElement updatebtn;

	@FindBy(xpath="//*[button='Cancel']/button")
	public WebElement cancelbtn;

	@FindBy(xpath="//table/thead/tr/td[4]/div/span")
	WebElement NameClmn;

	@FindBy(xpath="//*[button='No']/button")
	WebElement delNoBtn;

	@FindBy(xpath="//*[button='Yes']/button")
	WebElement delYesBtn;


	//login user profile

	@FindBy(xpath="//*[@class='userProfile']/img")
	public	WebElement userProfile;

	@FindBy(xpath="//*[@id='logoutId']/a")
	public	WebElement signout;


	//Product feature

	@FindBy(xpath="//*[span='Product Features']/span/span")
	public WebElement productFeature;

	@FindBy(xpath="//*[@id='custmastcomboId']")
	public	WebElement pfselectCustNameinput;

	//	@FindBy(xpath="//*[@name='custsetcomboId']")
	//	public	WebElement csselectCustNameinput;

	@FindBy(css="#custsetcomboId")
	public	WebElement csselectCustNameinput;

	//	@FindBy(xpath="html/body/div/div/div/div/div/div/table/tbody/tr/td[2]/div/input")
	//	public	WebElement selectCustNameinput;

	@FindBy(xpath="//*[@id='saveButtonId']/tbody/tr[2]/td[2]/em/button")
	public	WebElement pfsavebtn;

	@FindBy(xpath="//*[@id=\"ext-gen191\"]")
	public WebElement verticSave;

	@FindBy(xpath="//*[@id='tabid']/div[2]/div/div/div/div/div/table/tbody/tr/td/div/div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td[div='Essential Monitoring']/div")
	public WebElement essentialMonitor;

	@FindBy(xpath="/html/body/div[2]/div[2]/div[1]/div[1]/div/div/div/table/tbody/tr[1]/td[1]/div/div[2]/div[1]/div/div/div/div/div[1]/div[2]/div/div[1]")
	public WebElement essentialMonitorChek;

	@FindBy(xpath="//*[@id='tabid']/div[2]/div/div/div/div/div/table/tbody/tr/td/div/div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td[div='Advance Monitoring']/div")
	public WebElement advanceMonitor;

	@FindBy(xpath="/html/body/div[2]/div[2]/div[1]/div[1]/div/div/div/table/tbody/tr[1]/td[1]/div/div[2]/div[1]/div/div/div/div/div[1]/div[2]/div/div[2]")
	public WebElement advanceMonitorChek;

	@FindBy(xpath="//*[@id=\"tabid__ext-comp-1029\"]/a[2]")
	public	WebElement verticalizedSolution;

	@FindBy(xpath="//*[div='Car Rental']/div")
	WebElement carRental;

	@FindBy(xpath="//*[div='Sand Mining Administration Regulation Transport System']/div")
	WebElement sandMining;

	@FindBy(xpath="//*[@id='verticalizedpackid']/div/div/table/tbody/tr/td/div/div[2]/div/div/div/div/div/div/div[2]/div/div[7]")
	WebElement sandMiningCheck;

	@FindBy(xpath="//*[@id='tabid']/div[1]/div/ul/li[1]")
	WebElement mandatoryPack;

	@FindBy(xpath="//*[@id='tabid']/div[1]/div/ul/li[3]/a[2]")
	WebElement addonpack;

	@FindBys( {
		@FindBy(xpath = "//*[@id='mandatorypackid']/div/div/table/tbody/tr/td/div/div[2]/div/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td/div")
	} )
	private List<WebElement> advanceEssentialCheckbox;


	//Customization 

	@FindBy(xpath="//*[span='Customization']/span/span")
	public	WebElement customization;

	@FindBy(xpath="//*[@name='custsetcomboId']")
	public	WebElement custsetcomboId;

	@FindBy(xpath="//*[button='Add Image']/button")
	public	WebElement addImage;

	@FindBy(xpath="//*[@id='Ship_BG.png']/div/img")
	public	WebElement selectShip;

	@FindBy(xpath="//*[@id='STOPPAGE_TIME_ALERTfield']")
	WebElement STOPPAGE_TIME_ALERTfield;

	@FindBy(xpath="//*[@id='NON_COMMUNICATING_ALERTfield']")
	WebElement NON_COMMUNICATING_ALERTfield;

	@FindBy(xpath="//*[@id='LIVE_POSITION_ALERTfield']")
	WebElement LIVE_POSITION_ALERTfield;

	@FindBy(xpath="//*[@id='STOPPAGE_ALERT_INSIDE_HUBfield']")
	WebElement STOPPAGE_ALERT_INSIDE_HUBfield;

	@FindBy(xpath="//*[@id='IDLETIME_ALERTfield']")
	WebElement IDLETIME_ALERTfield;

	@FindBy(xpath="//*[@id='SUBSEQUENENT_REMAINDERIDfield']")
	WebElement SUBSEQUENENT_REMAINDERIDfield;

	@FindBy(xpath="//*[@id='SUBSEQUENENT_NOTIFICATIONIDfield']")
	WebElement SUBSEQUENENT_NOTIFICATIONIDfield;

	@FindBy(xpath="//*[@id=\"tabid__ext-comp-1126\"]/a[2]")
	WebElement cus_advanceMoni;


	//Restrictive Movement Alert

	@FindBy(xpath="//*[@id='dateId']")
	WebElement rma_dateId;

	@FindBy(xpath="//*[@id='dateId2']")
	WebElement rma_dateId2;

	@FindBy(xpath="//*[@id='RESTRICTIVE_MOMENT_DISTANCEfield']")
	WebElement RESTRICTIVE_MOMENT_DISTANCEfield;

	@FindBy(xpath="//*[@id='TUESDAY1field']")
	WebElement rma_TUESDAY1field;

	@FindBy(xpath="//*[@id='ACIDLE_TIME_ALERTfield']")
	WebElement ACIDLE_TIME_ALERTfield;

	@FindBy(xpath="//*[@id='NEARTO_BOARDER_DISTANCEfield']")
	WebElement NEARTO_BOARDER_DISTANCEfield;

	@FindBy(xpath="//*[@id='SEAT_BELT_INTERVALfield']")
	WebElement SEAT_BELT_INTERVALfield;

	@FindBy(xpath="//*[@id='SEATBELT_DISTANCEfield']")
	WebElement SEATBELT_DISTANCEfield;

	@FindBy(xpath="//*[@id='Door_Sensor_Intervalfield']")
	WebElement Door_Sensor_Intervalfield;

	@FindBy(xpath="//*[@id='DOOR_SENSOR_ALERT_INSIDE_HUBfield']")
	WebElement DOOR_SENSOR_ALERT_INSIDE_HUBfield;


	//Work Week

	@FindBy(xpath="//*[@id='MONDAYfield']")
	WebElement MONDAYfield;

	@FindBy(xpath="//*[@id='FIRST_DAY_WEEKfield']")
	WebElement FIRST_DAY_WEEKfield;

	@FindBy(xpath="//*[@id='START_TIMEfield']")
	WebElement START_TIMEfield;

	@FindBy(xpath="//*[@id='END_TIMEfield']")
	WebElement END_TIMEfield;

	@FindBy(xpath="//*[button='Save']/button")
	List<WebElement> ultimat_savebtn;


	//User Management

	@FindBy(xpath="//*[span='User Management']/span/span")
	public WebElement userManagement;

	@FindBy(xpath="//*[@id='usercustocomboId']")
	public	WebElement usercustocomboId;

	@FindBy(xpath="//*[button='Add']/button")
	List<WebElement> ultimat_addbtn;



	//Add user

	@FindBy(xpath="//*[@id='unamefieldid']")
	public	WebElement unamefieldid;

	@FindBy(xpath="//*[@id='unametfid']")
	public	WebElement unametfid;

	@FindBy(xpath="//*[@id='unametmid']")
	public	WebElement unametmid;

	@FindBy(xpath="//*[@id='unametlid']")
	public	WebElement unametlid;

	@FindBy(xpath="//*[@id='userauthcomboid']")
	public	WebElement userauthcomboid;

	@FindBy(xpath="//*[@id='emVisionstorecomboid']")
	public	WebElement emVisionstorecomboid;

	@FindBy(xpath="//*[@id='userphoneno']")
	public	WebElement userphoneno;

	@FindBy(xpath="//*[@id='userfax']")
	public	WebElement userfax;

	@FindBy(xpath="//*[@id='useremailid']")
	public	WebElement useremailid;

	@FindBy(xpath="//*[@id='userstatuscomboId']")
	WebElement userstatuscomboId;

	@FindBy(xpath="//*[@id='usermobileno']")
	public	WebElement usermobileno;

	//update user

	@FindBy(xpath="//*[button='Modify']/button")
	List<WebElement> ultimat_modifybtn;

	@FindBy(xpath="//*[@id='unametfid']")
	public	WebElement m_unamefieldid;

	@FindBy(xpath="//*[button='Delete']/button")
	List<WebElement> ultimat_delt_btn;

	//user group association

	@FindBy(xpath="//*[span='User Group Association']/span/span")
	public WebElement userGroupAssociation;

	@FindBy(xpath="//*[@id='custcomboId']")
	public WebElement grpAssocCustomer;

	@FindBy(xpath="//*[@id='usercomboId']")
	public WebElement grpAssocUser;

	@FindBy(xpath="//*[@id=\"ext-gen74\"]/div/table/tbody/tr/td[3]")
	public WebElement disAssociateCus;

	@FindBy(xpath="//*[@id=\"ext-gen74\"]/div")
	public WebElement disAssociateCusChecker;

	@FindBy(xpath="//*[@id=\"ext-gen74\"]/div/table/tbody/tr/td[2]/div")
	public WebElement disAssociateCusCheckBox;
	
	@FindBy(xpath="//*[@id=\"ext-gen73\"]/div/table/thead/tr/td[2]/div")
	public WebElement disAssociateallCheck;

	@FindBy(xpath="//*[span='Associate']/span")
	public WebElement associateBtn;	

	@FindBy(xpath="//*[@id=\"ext-gen113\"]/div/table/tbody/tr/td[3]/div")
	public WebElement AssociateCus;

	@FindBy(xpath="//*[@id=\"ext-gen113\"]/div")
	public WebElement AssociateCusChecker;

	@FindBy(xpath="//*[@id=\"ext-gen113\"]/div/table/tbody/tr/td[2]/div")
	public WebElement AssociateCusCheckBox;

	@FindBy(xpath="//*[b='Disassociate']/b")
	public WebElement disassociateBtn;	

	//Asset group
	@FindBy(xpath="//*[span='Asset Group']/span/span")
	public WebElement assetGroup;

	@FindBy(xpath="//*[@name='custmastcomboId']")
	public WebElement assetgrpCustomerId;

	//add group

	@FindBy(xpath="//*[@id='assetgroupnameid']")
	public WebElement assetgroupnameid;

	@FindBy(xpath="//*[@id='statecomboId']")
	public WebElement statecomboId;
	
	@FindBy(xpath="//*[@id='cityComboId']")
	public WebElement cityComboId;

	@FindBy(xpath="//*[@id='assetsupcomboId']")
	public WebElement assetsupcomboId;
	
	//update asset
	@FindBy(xpath="//*[@name='assetgroupnamenewid']")
	public List<WebElement> assetgroupnamenewid;
	
	@FindBy(xpath="//*[@id='statecomboId']")
	public List<WebElement> u_statecomboId;
	
	@FindBy(xpath="//*[@id='cityComboId']")
	public List<WebElement> u_cityComboId;
	
	@FindBy(xpath="//*[@id='assetsupcomboId']")
	public List<WebElement> u_assetsupcomboId;
	
	//asset group feature
	@FindBy(xpath="//*[span='Asset Group Features']/span/span")
	public WebElement assetGroupFeatures;
	
	@FindBy(xpath="//*[@name='custmastcomboId']")
	public WebElement custmastcomboId;
	
	@FindBy(xpath="//*[@name='assetgroupcomboId']")
	public WebElement assetgroupcomboId;
	
	@FindBy(xpath="//*[a='Verticalized Solution']/a[2]")
	public WebElement vertSol;
	
	@FindBy(xpath="//*[div='Sand Mining Administration Regulation Transport System']/div")
	public WebElement sandMining_asset;

	@FindBy(xpath="//*[@id='verticalizedpackid']/div/div/table/tbody/tr/td/div/div[2]/div/div/div/div/div/div/div[2]/div/div[1]")
	public WebElement sandMiningCheck_asset;
	

//	
//	@FindBy(xpath="//iframe[@src=\"/Telematics4uApp/Jsps/Admin/AssetGroup.jsp\"]")
//	public WebElement frame;
	
	

	public MasOperPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddbtn()
	{
		addbtn.click();
	}

	public void setSelectedRow(String input) throws InterruptedException {
		
		String path="//*[@id='grid']/div/div/div/div/div[2]/div/div/table/tbody/tr/td[div='"+input+"']";
		List<WebElement> elements=driver.findElements(By.xpath(path));		
		clickdisplayedBtn(elements);
	}

	public String getAlertText() {
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(alertText));
		return alertText.getText();
	}

	public void filter(String input) {

		Actions act=new Actions(driver);
		act.moveToElement(NameClmn).build().perform();
		act.moveToElement(dropColumn).build().perform();
		dropColumn.click();
		act.moveToElement(filterbtn).moveToElement(filterin).build().perform();
		filterin.click();
		filterin.clear();
		filterin.sendKeys(input);
		filterin.sendKeys(Keys.ENTER);
	}

	public void deleteSelectNoRow() throws InterruptedException {
		deletebtn.click();
		Thread.sleep(1000);
		delNoBtn.click();
		Thread.sleep(2000);
	}

	public void deleteSelectCustomer() throws InterruptedException {
		deletebtn.click();
		Thread.sleep(1000);
		delYesBtn.click();
		Thread.sleep(2000);
	}

	public void selectCustomr() throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jspPageId");
		driver.switchTo().frame(1);
	}

	public void productSave() {
		scrollTo(pfsavebtn);
		pfsavebtn.click();

	}
	public void clickVertical() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jspPageId");
		driver.switchTo().frame(1);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollTo(74, 101);");
		Actions action=new Actions(driver);
		action.moveToElement(verticalizedSolution, 74, 101).click(verticalizedSolution).build().perform();
	}

	public void selectMandatoryCheck() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jspPageId");
		driver.switchTo().frame(1);
		MainActivity.chechboxSelect(essentialMonitorChek,essentialMonitor);
		MainActivity.chechboxSelect(advanceMonitorChek,advanceMonitor);
	}

	public void selectVerticalCheck() {
		MainActivity.chechboxSelect(sandMiningCheck,sandMining);
	}

	public void clickMandatory() {
		// TODO Auto-generated method stub
		mandatoryPack.click();
	}

	public void fill_cus_essen() throws InterruptedException, IOException {
		Thread.sleep(2000);
		sendKey(STOPPAGE_TIME_ALERTfield, PropertyFileRead.getProperty("STOPPAGE_TIME_ALERTfield"));
		sendKey(NON_COMMUNICATING_ALERTfield, PropertyFileRead.getProperty("NON_COMMUNICATING_ALERTfield"));
		sendKey(SUBSEQUENENT_REMAINDERIDfield, PropertyFileRead.getProperty("SUBSEQUENENT_REMAINDERIDfield"));
		sendKey(IDLETIME_ALERTfield, PropertyFileRead.getProperty("IDLETIME_ALERTfield"));
		sendKey(SUBSEQUENENT_NOTIFICATIONIDfield, PropertyFileRead.getProperty("SUBSEQUENENT_NOTIFICATIONIDfield"));
		checkBox(STOPPAGE_ALERT_INSIDE_HUBfield);
		comboBox(LIVE_POSITION_ALERTfield, PropertyFileRead.getProperty("LIVE_POSITION_ALERTfield"));
	}

	public void cus_essen_save() throws InterruptedException {

		clickdisplayedBtn(ultimat_savebtn);
	}

	public void clickAdvance() {

		cus_advanceMoni.click();

	}

	public void fill_cus_adv() throws InterruptedException, IOException {
		Thread.sleep(2000);
		sendKey(rma_dateId, PropertyFileRead.getProperty("rma_dateId"));
		sendKey(rma_dateId2, PropertyFileRead.getProperty("rma_dateId2"));
		sendKey(RESTRICTIVE_MOMENT_DISTANCEfield, PropertyFileRead.getProperty("RESTRICTIVE_MOMENT_DISTANCEfield"));
		checkBox(rma_TUESDAY1field);
		sendKey(ACIDLE_TIME_ALERTfield, PropertyFileRead.getProperty("ACIDLE_TIME_ALERTfield"));
		sendKey(NEARTO_BOARDER_DISTANCEfield, PropertyFileRead.getProperty("NEARTO_BOARDER_DISTANCEfield"));
		comboBox(SEAT_BELT_INTERVALfield, PropertyFileRead.getProperty("SEAT_BELT_INTERVALfield"));
		sendKey(SEATBELT_DISTANCEfield, PropertyFileRead.getProperty("SEATBELT_DISTANCEfield"));
		sendKey(Door_Sensor_Intervalfield, PropertyFileRead.getProperty("Door_Sensor_Intervalfield"));
		checkBox(DOOR_SENSOR_ALERT_INSIDE_HUBfield);
		checkBox(MONDAYfield);
		comboBox(FIRST_DAY_WEEKfield, PropertyFileRead.getProperty("FIRST_DAY_WEEKfield"));
		comboBox(START_TIMEfield, PropertyFileRead.getProperty("START_TIMEfield"));
		comboBox(END_TIMEfield, PropertyFileRead.getProperty("END_TIMEfield"));

	}
	public void click_cus_adv_savbtn() throws InterruptedException {
		Thread.sleep(3000);
		clickdisplayedBtn(ultimat_savebtn);
	}

	public void click_userAdd_btn() throws InterruptedException {
		Thread.sleep(1000);
		clickdisplayedBtn(ultimat_addbtn);
	}

	public void addUser(String userName,String	firstName,String	middleName,String	lastName,String	userAuthority,String	eMVision,String	mobileNumber,String	phoneNumber,String	fax,String	email) throws InterruptedException {
		String actual;
		logger = extent.startTest("User Name validation");
		click_userAdd_btn();
		actual=getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Enter User Name"));
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		sendKey(unamefieldid, userName);

		logger = extent.startTest("First Name validation");
		click_userAdd_btn();
		actual=getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Enter First Name"));
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		sendKey(unametfid, firstName);
		sendKey(unametmid, middleName);


		logger = extent.startTest("Last Name validation");
		click_userAdd_btn();
		actual=getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Enter Last Name"));
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		sendKey(unametlid, lastName);

		logger = extent.startTest("User Authority validation");
		click_userAdd_btn();
		actual=getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Select User Authority"));
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		comboBox(userauthcomboid, userAuthority);

		comboBox(emVisionstorecomboid, eMVision);


		logger = extent.startTest("Mobile Name validation");
		click_userAdd_btn();
		actual=getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Enter Mobile No"));
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		sendKey(userphoneno, mobileNumber);
		sendKey(usermobileno, phoneNumber);
		sendKey(userfax, fax);

		logger = extent.startTest("Email validation");
		click_userAdd_btn();
		actual=getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Enter Email"));
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		sendKey(useremailid, email);

	}

	public void click_userModi_btn() throws InterruptedException {
		Thread.sleep(1000);
		clickdisplayedBtn(ultimat_modifybtn);
	}

	public void navigateToAsserGrp() throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jspPageId");
		clickOnElement(assetGroup);
		}

	
}
