package stepDefs;

import java.io.IOException;
import java.util.Map;

import base.BaseUtil;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.Constants;
import utilities.GenericUtils;

public class ContractIO extends BaseUtil {
	
	public static String account_name_text;
	public GenericUtils refGenericUtils = new GenericUtils(DriverFactory.getDriver());
	public AppGenericUtils refAccountCreation = new AppGenericUtils();
	public LoginPage loginPage = new LoginPage(DriverFactory.getDriver(), envDetails, objectRepository, usernumber);
	
	
	
	@When("User creates new ContractIO for {string} account")
	public void user_creates_Contract_IO(String contractIO_type, DataTable dataTable) throws InterruptedException, IOException {
		loginPage.loginToApplication();
		Map<String, String> map_info = refAccountCreation.feature_file_data(dataTable);
		refAccountCreation.globalSearch("Pipeline", AccountName);
		refGenericUtils.click_using_javaScript(objectRepository.get("NewContractIO.Button"), "NewContractIO.Button");
		refGenericUtils.click_using_javaScript(objectRepository.get("NextButton"), "NextButton");
		refGenericUtils.click_using_javaScript(objectRepository.get("ContractIO.Print.RadioButton"), "ContractIO.Print.RadioButton");
		refGenericUtils.take_screenshot();
		refGenericUtils.click_using_javaScript(objectRepository.get("NextButton"), "NextButton");
		refGenericUtils.waitUntilPageLoads();
		refAccountCreation.enter_values_updated(dataTable);
		refGenericUtils.take_screenshot();
		refGenericUtils.click_using_javaScript(objectRepository.get("NextButton"), "NextButton");
		refGenericUtils.waitUntilPageLoads();
		refGenericUtils.select_dropdown_index(objectRepository.get("ContractIO.Opportunity"), Integer.parseInt(map_info.get("ContractIO.Opportunity")), "ContractIO.Opportunity");
		refGenericUtils.take_screenshot();
		refGenericUtils.click_using_javaScript(objectRepository.get("NextButton"), "NextButton");
		refGenericUtils.waitUntilPageLoads();
		refGenericUtils.waitForElement(objectRepository.get("ContractIO.BillTo.Dropdown"), 10, "ContractIO.BillTo.Dropdown");
		refGenericUtils.select_dropdown_value(objectRepository.get("ContractIO.BillTo.Dropdown"), map_info.get("ContractIO.BillTo.Dropdown"), "ContractIO.BillTo.Dropdown");
		//refGenericUtils.click_using_javaScript(objectRepository.get("ContractIO.Agency"), "ContractIO.Agency");
		//refGenericUtils.toEnterTextValue(objectRepository.get("ContractIO.Agency"), map_info.get("ContractIO.Agency"), "ContractIO.Agency");
		Thread.sleep(3000);
		refGenericUtils.scrollToViewElement(objectRepository.get("ContractIO.Agency"), "ContractIO.Agency");
		//refGenericUtils.sendKeysJS(objectRepository.get("ContractIO.Agency"), map_info.get("ContractIO.Agency"));
		refGenericUtils.toEnterTextValue(objectRepository.get("ContractIO.Agency"), map_info.get("ContractIO.Agency"), "ContractIO.Agency");;
		Thread.sleep(2000);
		refGenericUtils.keyboard_action(objectRepository.get("HomePage.GlobalSearch.SearchType"), "Enter");
		refGenericUtils.click_using_javaScript(objectRepository.get("ContractIO.TestAgencyAccount"), "ContractIO.TestAgencyAccount");
		refGenericUtils.take_screenshot();
		refGenericUtils.click_using_javaScript(objectRepository.get("NextButton"), "NextButton");
		refGenericUtils.waitUntilPageLoads();
		refGenericUtils.select_dropdown_index(objectRepository.get("ContractIO.BillToAddress"), Integer.parseInt(map_info.get("ContractIO.BillToAddress")), "ContractIO.BillToAddress");
		refGenericUtils.take_screenshot();
		refGenericUtils.click_using_javaScript(objectRepository.get("NextButton"), "NextButton");
		Thread.sleep(2000); 
		refGenericUtils.take_screenshot();
		refGenericUtils.click_using_javaScript(objectRepository.get("NextButton"), "NextButton");
		Thread.sleep(2000);
		refGenericUtils.click_using_javaScript(objectRepository.get("ContractIO.Upload Files"), "ContractIO.Upload Files");
		Thread.sleep(2000);
		refGenericUtils.UploadFile(Constants.UPLOAD_PDF_PATH);
		refGenericUtils.take_screenshot();
	}
	
}
