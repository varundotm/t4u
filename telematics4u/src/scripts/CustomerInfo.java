package scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import generic.ExcelData;
import generic.PropertyFileRead;
import pages.MasOperPage;

public class CustomerInfo extends Administration{
	MasOperPage objMas;
	List<String> names=new ArrayList<String>();
	List<String> users=new ArrayList<String>();
	List<String> assetGrp=new ArrayList<String>();
	SoftAssert softAssertion;
	String actual;

	public void tableInfo() {
		objMas= new MasOperPage(driver);
		objMas.tableCol=new ArrayList<WebElement>();
		objMas.tableRow=new ArrayList<WebElement>();
		int totCol=objMas.tableCol.size();
		int totRow=objMas.tableRow.size();
		System.out.println("No. of rows:"+totRow);
		System.out.println("No. of columns:"+totCol);
	}

	@Test(priority=3,enabled=true)
	public void navigateCustomerInfoADD() {
		logger = extent.startTest("navigateCustomerInfo");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		objMas=new MasOperPage(driver);
		objMas.clickAddbtn();	
		logger.log(LogStatus.PASS, "Navigate to Customer info Add Test Case is passTest");
	}

	@Test(priority=4,dataProvider="Customer",enabled=true)
	public void validateCustomerAdd(String name,String address,String country,String state,String city,String phoneNo,String zipcode, String mobileNo, String fax, String mail,String webSite, String date,String notificationPeriod, String speedLimit,String snooze, String  expected) throws InterruptedException {
		logger = extent.startTest("validateCustomerAdd");
		loggerInfo( name, address, country, state, city, phoneNo, zipcode,  mobileNo,  fax,  mail, webSite,  date, notificationPeriod,  speedLimit, snooze);
		sendKey(objMas.custname,name);
		sendKey(objMas.address,address);
		comboBox(objMas.country, country);
		comboBox(objMas.state, state);		
		sendKey(objMas.city, city);
		sendKey(objMas.phone, phoneNo);
		sendKey(objMas.custzipcode, zipcode);
		sendKey(objMas.custmobileno, mobileNo);
		sendKey(objMas.custfax, fax);
		sendKey(objMas.custemailid, mail);
		sendKey(objMas.custwebsite, webSite);
		sendKey(objMas.PAYMENTDUE_DATEfield, date);
		sendKey(objMas.PAYMENT_NOTIFICATIONPERIODfield, notificationPeriod);
		sendKey(objMas.speedLimitId, speedLimit);
		sendKey(objMas.snoozeId, snooze);
		clickSave();
		softAssertion= new SoftAssert();
		actual=objMas.getAlertText();
		softAssertion.assertTrue(expected.equalsIgnoreCase(actual));
		logger.log(LogStatus.INFO, "Result: "+actual);
		if(actual.equalsIgnoreCase("Duplicate Customer Name")||actual.equalsIgnoreCase("Saved Successfully")) {
			names.add(name);
			objMas.clickAddbtn();
		}
		logger.log(LogStatus.PASS, "Validation of customer add Passed is passTest");
	}



	@Test(priority=5,dataProvider="onlyonecustomer",enabled=true)
	public void addCustomer(String name,String address,String country,String state,String city,String phoneNo,String zipcode, String mobileNo, String fax, String mail,String webSite, String date,String notificationPeriod, String speedLimit,String snooze,  String expected) throws InterruptedException {
		this.validateCustomerAdd(name, address, country, state, city, phoneNo, zipcode,  mobileNo,  fax,  mail, webSite,  date, notificationPeriod,  speedLimit, snooze,  expected);
		if(actual.equalsIgnoreCase("Duplicate Customer Name")||actual.equalsIgnoreCase("Saved Successfully")) {
			objMas.cancelbtn.click();
		}
	}



	@Test(priority=6,enabled=true,dataProvider="onlyonecustomer")
	public void updateCus(String name,String address,String country,String state,String city,String phoneNo,String zipcode, String mobileNo, String fax, String mail,String webSite, String date,String notificationPeriod, String speedLimit,String snooze,  String expected) throws InterruptedException {
		logger = extent.startTest("Update");
		for(int i=0;i<names.size();i++) {
			String input=names.get(i).toUpperCase();
			//objMas.filter(input);
			objMas.setSelectedRow(input);
			objMas.modifbtn.click();
			Thread.sleep(3000);
			sendKey(objMas.u_custname,name);
			sendKey(objMas.address,address);
			comboBox(objMas.country, country);
			comboBox(objMas.state, state);		
			sendKey(objMas.city, city);
			sendKey(objMas.phone, phoneNo);
			sendKey(objMas.custzipcode, zipcode);
			sendKey(objMas.custmobileno, mobileNo);
			sendKey(objMas.custfax, fax);
			sendKey(objMas.custemailid, mail);
			sendKey(objMas.custwebsite, webSite);
			sendKey(objMas.PAYMENTDUE_DATEfield, date);
			sendKey(objMas.PAYMENT_NOTIFICATIONPERIODfield, notificationPeriod);
			sendKey(objMas.speedLimitId, speedLimit);
			sendKey(objMas.snoozeId, snooze);
			objMas.updatebtn.click();
			Thread.sleep(800);
			actual=objMas.getAlertText();
			softAssertion.assertTrue("Saved successfully".equalsIgnoreCase(actual));
			logger.log(LogStatus.INFO, actual);
			Thread.sleep(3000);
		}
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	@Test(priority=7,dependsOnMethods= {"updateCus"},enabled=true)
	public void deleteNoBtn() throws InterruptedException {
		logger = extent.startTest("Delete No Button");
		for(int i=names.size();i<=names.size();i++) {
			String input=names.get(i-1).toUpperCase();
			objMas.setSelectedRow(input);
			objMas.deleteSelectNoRow();
			actual=objMas.getAlertText();
			softAssertion.assertTrue("Customer not deleted".equalsIgnoreCase(actual));
			logger.log(LogStatus.INFO, actual);
			Thread.sleep(3000);
		}
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	@Test(priority=8,dependsOnMethods= {"deleteNoBtn"},enabled=true)
	public void deleteYesBtn() throws InterruptedException {
		logger = extent.startTest("Delete");
		for(int i=0;i<names.size();i++) {
			String input=names.get(i).toUpperCase();
			if(!input.equals("AUTOMATE10")) {
				objMas.setSelectedRow(input);
				objMas.deleteSelectCustomer();
				actual=objMas.getAlertText();
				softAssertion.assertTrue("deleted".equalsIgnoreCase(actual));
				logger.log(LogStatus.INFO, actual);
				Thread.sleep(3000);
			}
		}
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}

	public void clickSave() throws InterruptedException {

		clickOnElement(objMas.savebtn);
		Thread.sleep(1000);

	}

	@DataProvider(name="Customer")
	public static Object[][] customerinfo() throws Exception{

		Object[][] datas=ExcelData.getTableArray(".\\src\\data\\T4U_TestData.xls", "customerinfo",16);

		return datas;

	}

	@DataProvider(name="onlyonecustomer")
	public static Object[][] onecustomerinfo() throws Exception{

		Object[][] datas=ExcelData.getTableArray(".\\src\\data\\T4U_TestData.xls", "onlyonecustomer",16);

		return datas;

	}

	@Test(priority=9,enabled=true)
	public void navigateToPF() throws IOException {
		logger = extent.startTest("Navigate to product Feature");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jspPageId");
		clickOnElement(objMas.productFeature);
		logger.log(LogStatus.PASS, "Navigate to product Feature Test is passTest");
	}

	@Test(priority=10,enabled=true)
	public void productFeatureCheck() throws InterruptedException, IOException {
		logger = extent.startTest("productFeatureCheck");
		String input;
		if(names.size()>0) {
			input=names.get(names.size()-1).toUpperCase();
		}else {
			input="A";
		}
		objMas.selectCustomr();
		comboBox(objMas.pfselectCustNameinput,input);
		objMas.selectMandatoryCheck();
		objMas.productSave();
		if(!PropertyFileRead.getProperty("browserName").equals("Chrome")) {
			objMas.clickVertical();
			objMas.selectVerticalCheck();
			objMas.verticSave.click();
		}
		actual=objMas.getAlertText();
		softAssertion.assertTrue(actual.equalsIgnoreCase("Saved successfully"));
		logger.log(LogStatus.PASS, "Product Feature checkBox enable Test is passTest");
	}
	@Test(priority=11,enabled=true)
	public void navigateToCustomization() {
		logger = extent.startTest("navigateToCustomization");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jspPageId");
		clickOnElement(objMas.customization);
		logger.log(LogStatus.PASS, "Navigate to customization Test is passTest");
	}

	@Test(priority=12,enabled=true)
	void customizationSet() throws InterruptedException, IOException {
		logger = extent.startTest("customizationSet");
		String input;
		if(names.size()>0) {
			input=names.get(names.size()-1).toUpperCase();
		}else {
			input="A";
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jspPageId");
		driver.switchTo().frame(2);
		comboBox(objMas.custsetcomboId,input);
		clickOnElement(objMas.addImage);
		clickOnElement(objMas.selectShip);
		objMas.fill_cus_essen();
		objMas.cus_essen_save();
		objMas.clickAdvance();
		objMas.fill_cus_adv();
		objMas.click_cus_adv_savbtn();
		logger.log(LogStatus.PASS, "customization value set Test is passTest");
	}

	@Test(priority=13,dataProvider="user",enabled=true)
	public void userMange(String userName,String	firstName,String	middleName,String	lastName,String	userAuthority,String	eMVision,String	mobileNumber,String	phoneNumber,String	fax,String	email) throws InterruptedException, IOException {
		logger = extent.startTest("Validate User Management");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jspPageId");
		clickOnElement(objMas.userManagement);
		driver.switchTo().frame(3);
		String input;
		if(names.size()>0) {
			input=names.get(names.size()-1).toUpperCase();
		}else {
			input="A";
		}
		comboBox(objMas.usercustocomboId, input);
		objMas.click_userAdd_btn();

		//user add validation
		String actual;
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Enter User Name"));
		logger.log(LogStatus.INFO, "User Name validation is passTest");
		sendKey(objMas.unamefieldid, userName);
		logger.log(LogStatus.INFO, "User Name: "+userName);    	
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Enter First Name"));
		logger.log(LogStatus.INFO, "First Name validation is passTest");
		sendKey(objMas.unametfid, firstName);
		sendKey(objMas.unametmid, middleName);
		logger.log(LogStatus.INFO, "First Name: "+firstName);
		logger.log(LogStatus.INFO, "Middle Name: "+middleName);
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Enter Last Name"));
		logger.log(LogStatus.INFO, "Last Name validation is passTest");
		sendKey(objMas.unametlid, lastName);
		logger.log(LogStatus.INFO, "Last Name:"+lastName);    	
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Select User Authority"));
		logger.log(LogStatus.INFO, "User Authority validation is passTest");
		comboBox(objMas.userauthcomboid, userAuthority);
		comboBox(objMas.emVisionstorecomboid, eMVision);
		logger.log(LogStatus.INFO, "User Authority: "+userAuthority);
		logger.log(LogStatus.INFO, "eMVision: "+eMVision);
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Enter Mobile No"));
		logger.log(LogStatus.INFO, "Mobile number validation is passTest");
		sendKey(objMas.userphoneno, mobileNumber);
		sendKey(objMas.usermobileno, phoneNumber);
		sendKey(objMas.userfax, fax);
		logger.log(LogStatus.INFO, "Mobile number: "+mobileNumber);
		logger.log(LogStatus.INFO, "Phone number: "+phoneNumber);
		logger.log(LogStatus.INFO, "Fax: "+fax);
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		logger.log(LogStatus.INFO, "Result: "+actual);
		Assert.assertTrue(actual.equalsIgnoreCase("Enter Email"));
		logger.log(LogStatus.INFO, "Email validation is passTest");
		sendKey(objMas.useremailid, email);
		logger.log(LogStatus.INFO, "Email: "+email);
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		logger.log(LogStatus.INFO, "Result :",actual);
		if(actual.equalsIgnoreCase(actual)) {
			users.add(userName);}
		Assert.assertTrue(actual.equalsIgnoreCase(actual));
		logger.log(LogStatus.PASS, "User Management Test is passTest");
	}

	@Test(dataProvider="user",priority=14,enabled=true)
	public void updateUser(String userName,String	firstName,String	middleName,String	lastName,String	userAuthority,String	eMVision,String	mobileNumber,String	phoneNumber,String	fax,String	email) throws InterruptedException {
		logger = extent.startTest("Update user");
		for(int i=0;i<users.size();i++) {
			String input=users.get(i);
			//objMas.filter(input);
			objMas.setSelectedRow(input);
			objMas.click_userModi_btn();
			Thread.sleep(1000);

			//user modify validation

			String actual;
			objMas.m_unamefieldid.clear();
			objMas.click_cus_adv_savbtn();
			actual=objMas.getAlertText();
			logger.log(LogStatus.INFO, "Result: "+actual);
			Assert.assertTrue(actual.equalsIgnoreCase("Enter First Name"));
			logger.log(LogStatus.INFO, "First Name validation is passTest");
			sendKey(objMas.m_unamefieldid, firstName);
			sendKey(objMas.unametmid, middleName);
			logger.log(LogStatus.INFO, "First Name: "+firstName);
			logger.log(LogStatus.INFO, "Middle Name: "+middleName);
			objMas.unametlid.clear();
			objMas.click_cus_adv_savbtn();
			actual=objMas.getAlertText();
			logger.log(LogStatus.INFO, "Result: "+actual);
			Assert.assertTrue(actual.equalsIgnoreCase("Enter Last Name"));
			logger.log(LogStatus.INFO, "Last Name validation is passTest");
			sendKey(objMas.unametlid, lastName);
			logger.log(LogStatus.INFO, "Last Name:"+lastName);
			comboBox(objMas.userauthcomboid, userAuthority);
			comboBox(objMas.emVisionstorecomboid, eMVision);
			logger.log(LogStatus.INFO, "User Authority: "+userAuthority);
			logger.log(LogStatus.INFO, "eMVision: "+eMVision);
			objMas.userphoneno.clear();
			objMas.click_cus_adv_savbtn();
			actual=objMas.getAlertText();
			logger.log(LogStatus.INFO, "Result: "+actual);
			Assert.assertTrue(actual.equalsIgnoreCase("Enter Mobile No"));
			logger.log(LogStatus.INFO, "Mobile number validation is passTest");
			sendKey(objMas.userphoneno, mobileNumber);
			sendKey(objMas.usermobileno, phoneNumber);
			sendKey(objMas.userfax, fax);
			logger.log(LogStatus.INFO, "Mobile number: "+mobileNumber);
			logger.log(LogStatus.INFO, "Phone number: "+phoneNumber);
			logger.log(LogStatus.INFO, "Fax: "+fax);
			objMas.useremailid.clear();
			objMas.click_cus_adv_savbtn();
			actual=objMas.getAlertText();
			logger.log(LogStatus.INFO, "Result: "+actual);
			Assert.assertTrue(actual.equalsIgnoreCase("Enter Email"));
			logger.log(LogStatus.INFO, "Email validation is passTest");
			sendKey(objMas.useremailid, email);
			logger.log(LogStatus.INFO, "Email: "+email);
			objMas.click_cus_adv_savbtn();
			actual=objMas.getAlertText();
			logger.log(LogStatus.INFO, "Result :"+actual);
			Assert.assertTrue(actual.equalsIgnoreCase("User Details Updated Successfully."));
			logger.log(LogStatus.PASS, "User Update Test is passTest");

		}
	}

	@DataProvider(name="user")
	public static Object[][] userinfo() throws Exception{

		Object[][] datas=ExcelData.getTableArray(".\\src\\data\\T4U_TestData.xls", "user",10);

		return datas;

	}

	@Test(priority=15,enabled=true)
	void userGroupAssociation() throws InterruptedException {
		logger = extent.startTest("Validate User Management");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jspPageId");
		clickOnElement(objMas.userGroupAssociation);
		driver.switchTo().frame(4);
		String customer,user;
		if(names.size()>0) {
			customer=names.get(names.size()-1).toUpperCase();
		}else {
			customer="A";
		}
		if(users.size()>0) {
			user=users.get(users.size()-1).toUpperCase();
		}else {
			user="tillu";
		}
		comboBox(objMas.grpAssocCustomer, customer);
		comboBox(objMas.grpAssocUser, user);

		if(isElementPresent(objMas.disAssociateCus)) {
			chechboxSelect(objMas.disAssociateCusChecker, objMas.disAssociateCusCheckBox);
			clickOnElement(objMas.associateBtn);
			actual=objMas.getAlertText();
			softAssertion.assertTrue(actual.equalsIgnoreCase("Associated successfully."));
			Thread.sleep(2000);
			chechboxSelect(objMas.AssociateCusChecker, objMas.AssociateCusCheckBox);
			clickOnElement(objMas.disassociateBtn);
			actual=objMas.getAlertText();
			softAssertion.assertTrue(actual.equalsIgnoreCase("Disassociated successfully."));
			Thread.sleep(2000);
			chechboxSelect(objMas.disAssociateCusChecker, objMas.disAssociateallCheck);
			clickOnElement(objMas.associateBtn);
			actual=objMas.getAlertText();
			softAssertion.assertTrue(actual.equalsIgnoreCase("Associated successfully."));
			Thread.sleep(2000);
		}else {
			chechboxSelect(objMas.AssociateCusChecker, objMas.AssociateCusCheckBox);
			clickOnElement(objMas.disassociateBtn);
			actual=objMas.getAlertText();
			softAssertion.assertTrue(actual.equalsIgnoreCase("Disassociated successfully."));
			Thread.sleep(2000);
			chechboxSelect(objMas.disAssociateCusChecker, objMas.disAssociateallCheck);
			clickOnElement(objMas.associateBtn);
			actual=objMas.getAlertText();
			softAssertion.assertTrue(actual.equalsIgnoreCase("Associated successfully."));
		}
		logger.log(LogStatus.PASS, "User Group manage Test is passTest");

	}

	@Test(priority=16)
	public void defaultAssetGroupModify() throws InterruptedException {
		logger = extent.startTest("default Asset Group Modify");
		try {
			objMas.navigateToAsserGrp();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("jspPageId");
			Thread.sleep(2000);
			driver.switchTo().frame(5);
			String input;
			if(names.size()>0) {
				input=names.get(names.size()-1).toUpperCase();
			}else {
				input="Automate10";
			}
			Thread.sleep(2000);
			scrollTo(objMas.assetgrpCustomerId);
			comboBox(objMas.assetgrpCustomerId, input);
			objMas.setSelectedRow(input);
			objMas.click_userModi_btn();
			actual=objMas.getAlertText();
			softAssertion.assertTrue(actual.equalsIgnoreCase("Cannot modify default Asset Group"));
		}catch(StaleElementReferenceException e) {
			System.out.println("Stale element exception: "+e);
		}
		logger.log(LogStatus.PASS, "Default asset group modify Test is passTest");

	}

	@Test(priority=17)
	public void validateAssetGroupAlreadyExist() throws InterruptedException {
		logger = extent.startTest("Validate Asset Group Already Exist");
		objMas.click_userAdd_btn();
		Thread.sleep(2000);
		sendKey(objMas.assetgroupnameid, names.get(names.size()-1).toUpperCase());
		comboBox(objMas.assetsupcomboId,"tillu");
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		softAssertion.assertTrue(actual.equalsIgnoreCase("Group Name Already Exist"));
		logger.log(LogStatus.PASS, "Asset Group Already Exist Test is passTest");
	}

	@Test(priority=18,dataProvider="assetGroup")
	public void addAssertGroup(String assetGrpName,String state, String city) throws InterruptedException {
		logger = extent.startTest("Add New Assert Group");
		objMas.click_userAdd_btn();
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		softAssertion.assertTrue(actual.equalsIgnoreCase("Enter Asset Group"));
		sendKey(objMas.assetgroupnameid,assetGrpName);
		comboBox(objMas.statecomboId, state);
		comboBox(objMas.cityComboId, city);
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		softAssertion.assertTrue(actual.equalsIgnoreCase("Select Supervisor"));
		comboBox(objMas.assetsupcomboId,"tillu");
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		if(actual.equalsIgnoreCase("Asset Group Added")||actual.equalsIgnoreCase("Group Name Already Exist")) {
			assetGrp.add(assetGrpName);
		}
		softAssertion.assertTrue(actual.equalsIgnoreCase("Asset Group Added"));
		logger.log(LogStatus.PASS, "Asset group added Test is passTest");
	}

	@DataProvider(name="assetGroup")
	public static Object[][] assetGroup() throws Exception {
		Object[][] datas=ExcelData.getTableArray(".\\src\\data\\T4U_TestData.xls", "asset",3);
		return datas;
	}

	@Test(priority=19,dataProvider="assetGroup",enabled=true)
	public void updateGroup(String assetGrpName,String state, String city) throws InterruptedException {
		logger = extent.startTest("Update Assert Group");
		try {
			String input=assetGrp.get(assetGrp.size()-1).toUpperCase();
			objMas.setSelectedRow(input);
			objMas.click_userModi_btn();
			clickdisplayedBtn(objMas.assetgroupnamenewid);
			clrDisEle(objMas.assetgroupnamenewid);
			objMas.click_cus_adv_savbtn();
			actual=objMas.getAlertText();
			if(actual.equalsIgnoreCase("Asset Group Modified")) {
				objMas.click_userModi_btn();
			}else {
				softAssertion.assertTrue(actual.equalsIgnoreCase("Enter Asset Group"));
			}
			sendTodisplayedTxt(objMas.assetgroupnamenewid,assetGrpName);
			sendTodisplayedCombo(objMas.u_statecomboId, state);
			sendTodisplayedCombo(objMas.u_cityComboId, city);
			clrDisEle(objMas.u_assetsupcomboId);
			objMas.click_cus_adv_savbtn();
			actual=objMas.getAlertText();
			softAssertion.assertTrue(actual.equalsIgnoreCase("Select Supervisor"));
			sendTodisplayedCombo(objMas.u_assetsupcomboId,"tillu");
			objMas.click_cus_adv_savbtn();
			actual=objMas.getAlertText();
			softAssertion.assertTrue(actual.equalsIgnoreCase("Asset Group Modified"));
		}catch(StaleElementReferenceException e) {
			System.out.println("Stale exception: "+e);
		}catch (TimeoutException e) {
			System.out.println("Timeout exception: "+e);
		}
		logger.log(LogStatus.PASS, "Asset group update Test is passTest");
	}

	@Test(priority=20)
	public void assertGrpFeature() throws InterruptedException {
		logger = extent.startTest("Assert Group Feature");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jspPageId");
		clickOnElement(objMas.assetGroupFeatures);
		driver.switchTo().frame(6);
		String customer,groupName;
		if(names.size()>0) {
			customer=names.get(names.size()-1).toUpperCase();
		}else {
			customer="A";
		}
		if(assetGrp.size()>0) {
			groupName=assetGrp.get(assetGrp.size()-1).toUpperCase();
		}else {
			groupName="asset";
		}
		scrollTo(objMas.custmastcomboId);
		comboBox(objMas.custmastcomboId, customer);
		Thread.sleep(2000);
		comboBox(objMas.assetgroupcomboId, groupName);
		Thread.sleep(2000);
		chechboxSelect(objMas.essentialMonitorChek,objMas.essentialMonitor);
		chechboxSelect(objMas.advanceMonitorChek,objMas.advanceMonitor);
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		softAssertion.assertTrue(actual.equalsIgnoreCase("Select any one Package"));
		clickOnElement(objMas.vertSol);
		chechboxSelect(objMas.sandMiningCheck_asset,objMas.sandMining_asset);
		objMas.click_cus_adv_savbtn();
		actual=objMas.getAlertText();
		softAssertion.assertTrue(actual.equalsIgnoreCase("Saved successfully."));
		logger.log(LogStatus.PASS, "Asset group Feature Test is passTest");
	}
}
