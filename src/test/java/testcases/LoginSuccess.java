package testcases;

import wrappers.OpentapsWrappers;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginSuccess extends OpentapsWrappers{
	
@BeforeClass
public void startTestCase(){
	browserName = "chrome";
	dataSheetName = "TC001A_Login";
	testCaseName = "TC01 - Login (POM)";
	testDescription = "Login to Opentaps using POM framework";
}
	
@Test(dataProvider="fetchData")	
public void loginForSuccess(String username,String password){
	new LoginPage()
	.enterUserName(username)
	.enterPassword(password)
	.clickLogin();
}

}