package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='menu7']")
	WebElement administration;
	
	@FindBy(xpath="//*[@id='menu1']")
	WebElement DASHBOARD;
	
	@FindBy(xpath="//*[@id='menu2']")
	WebElement LIVEVISION;
	
	@FindBy(xpath="//*[@id='menu3']")
	WebElement ALERTS;
	
	@FindBy(xpath="//*[@id='menu4']")
	WebElement ACTIONS;
	
	@FindBy(xpath="//*[@id='menu5']")
	WebElement REPORTS;
	
	@FindBy(xpath="//*[@id='menu6']")
	WebElement PREFERENCES;
	
	@FindBy(xpath="//*[@id='list166']")
	WebElement Masteroperation;
	
	@FindBy(xpath="//*[@id='list167']")
	WebElement AssetOperation;
	
	@FindBy(xpath="//*[@id='list168']")
	WebElement UserAssetAssociation;
	
	@FindBy(xpath="//*[@id='list169']")
	WebElement VehicleDriverAssociation;
	
	@FindBy(xpath="//*[@id='list170']")
	WebElement ClientLocationAssociation;
	
	@FindBy(xpath="//*[@id='list171']")
	WebElement DriverMaster;
	
	@FindBy(xpath="//*[@id='list172']")
	WebElement TripSolution;
	
	@FindBy(xpath="//*[@id='list173']")
	WebElement RouteMaster;
	
	@FindBy(xpath="//*[@id='list174']")
	WebElement OwnerInformation;
	
	@FindBy(xpath="//*[@id='list175']")
	WebElement SCCASSOCIATION;
	
	@FindBy(xpath="//*[@id='list176']")
	WebElement CreateLandmark;
	
	@FindBy(xpath="//*[@id='list177']")
	WebElement EditLandmark;
	
	@FindBy(xpath="//*[@id='list178']")
	WebElement RouteVehicleAssociation;
	
	@FindBy(xpath="//*[@id='list179']")
	WebElement OBdParameterSetting;
	
	@FindBy(xpath="//*[@id='list180']")
	WebElement RouteMasterNew;
	
	@FindBy(xpath="//*[@id='list181']")
	WebElement ReportSchedular;
	
	@FindBy(xpath="//*[@id='list182']")
	WebElement AlertManager;
	
	@FindBy(xpath="//*[@id='list183']")
	WebElement TripCreationNew;
	
	@FindBy(xpath="//*[@id='list184']")
	WebElement TripDashBoard;
	
	@FindBy(xpath="//*[@id='list185']")
	WebElement ServiceRequestModule;
	
	@FindBy(xpath="//*[@id='list186']")
	WebElement GPSDeviceConfigurationManagement;
	
	@FindBy(xpath="//*[@id='list187']")
	WebElement TripCustomerDetails;
	
	@FindBy(xpath="//*[@id='list188']")
	WebElement LegRouteCreation;
	
	@FindBy(xpath="//*[@id='list189']")
	WebElement UserReactivationUnblockWindow;
	
	@FindBy(xpath="//*[@id='list190']")
	WebElement LoggedUser;
	
	@FindBy(xpath="//*[@id='list191']")
	WebElement LegMaster;
	
	@FindBy(xpath="//*[@id='list192']")
	WebElement DriverPerformanceDashboard;
	
	@FindBy(xpath="//*[@id='list193']")
	WebElement UnitVehicleHistory;
	
	@FindBy(xpath="//*[@id='list194']")
	WebElement VehicleMaintenanceWindow;
	
	@FindBy(xpath="//*[@id='list195']")
	WebElement AssetRegistrationCancellationReport;
	
	@FindBy(xpath="//*[@id='list196']")
	WebElement UtilizationDashboard;
	
	@FindBy(xpath="//*[@id='list197']")
	WebElement SmartTruckerBehavior;
	
	@FindBy(xpath="//*[@id='list198']")
	WebElement AlertEscalationMaster;
	
	@FindBy(xpath="//*[@id='list199']")
	WebElement RawDataAnalysis;
	
	@FindBy(xpath="//*[@id='list200']")
	WebElement SmartTruckHealth;
	
	@FindBy(xpath="//*[@id='list201']")
	WebElement ExecutiveStaticView;
	
	@FindBy(xpath="//*[@id='list202']")
	WebElement DataUtilization;
	
	@FindBy(xpath="//*[@id='list203']")
	WebElement ExecutiveLiveView;
	
	@FindBy(xpath="//*[@id='list204']")
	WebElement DayWiseReprocessing;
	
	@FindBy(xpath="//*[@id='list205']")
	WebElement CrewMaster;
	
	@FindBy(xpath="//*[@id='list206']")
	WebElement TripDashboard;
	
	@FindBy(xpath="//*[@id='list207']")
	WebElement UploadViewAssetDocument;
	
	@FindBy(xpath="//*[@id='list208']")
	WebElement UserRouteAssociation;
	
	@FindBy(xpath="//*[@id='list209']")
	WebElement CreateRoute;
	
	@FindBy(xpath="//*[@id='list210']")
	WebElement HubOperationSettingWindow;
	
	@FindBy(xpath="//*[@id='list211']")
	WebElement HubsStandardTime;
	
	@FindBy(xpath="//*[@id='list212']")
	WebElement ModifyRoute;
	
	@FindBy(xpath="//*[@id='list213']")
	WebElement UserHubAssociation;
	
	@FindBy(xpath="//*[@id='list214']")
	WebElement HolidaysInformation;
	
	@FindBy(xpath="//*[@id='list215']")
	WebElement SystemHealth;
	
	@FindBy(xpath="//*[@id='list216']")
	WebElement RouteInformation;
	
	@FindBy(xpath="//*[@id='list217']")
	WebElement CreateLandmarkNew;
	
	@FindBy(xpath="//*[@id='list218']")
	WebElement SMSAlertAssociation;
	
	@FindBy(xpath="//*[@id='list219']")
	WebElement SMSAlertUserAssociation;
	
	@FindBy(xpath="//*[@id='list220']")
	WebElement VehicleMessageAssociation;
	
	@FindBy(xpath="//*[@id='list221']")
	WebElement RouteTemplateCreation;
	
	@FindBy(xpath="//*[@id='list222']")
	WebElement SMSReDistribution;
	
	@FindBy(xpath="//*[@id='list223']")
	WebElement SMSRequestForm;
	
	@FindBy(xpath="//*[@id='list224']")
	WebElement MaterialCreation;
	
	@FindBy(xpath="//*[@id='list225']")
	WebElement VehicleSensorsAssociation;
	
	@FindBy(xpath="//*[@id='list226']")
	WebElement VehicleMobilizeManagement;
	
	@FindBy(xpath="//*[@id='list227']")
	WebElement SandAssetRegistration;
	
	public MasterPage(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}	
}
