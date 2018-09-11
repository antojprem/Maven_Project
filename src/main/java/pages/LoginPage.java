package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class LoginPage extends OpentapsWrappers{
	
	public LoginPage(){
		if(!verifyTitle("Leaftaps - TestLeaf Automation Platform")){
			Reporter.reportStep("This is NOT login page", "FAIL");
		}
	}
	
	//Enter the user name
	public LoginPage enterUserName(String userdata){
		enterById(prop.getProperty("Login.UserName.Id"),userdata);
		return this;
	}
	
	//Enter the password
	public LoginPage enterPassword(String password){
		enterById(prop.getProperty("Login.Password.Id"),password);
		return this;
	}

	//Click Login
	public HomePage clickLogin(){
		clickByClassName(prop.getProperty("Login.LoginButton.Class"));
		return new HomePage();
	}
	
	//Click Login for failure
	public LoginPage clickLoginForFailure(){
		clickByClassName(prop.getProperty("Login.LoginButton.Class"));
		return this;
	}
	
	public LoginPage getErrorMessage(){
		System.out.println(getTextByXpath("//*[@id='errorDiv']"));
		return this;
	}
}
