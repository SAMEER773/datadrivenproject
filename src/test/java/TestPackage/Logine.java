package TestPackage;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Base;
import Util.DataUtil;
import Util.MyXLSReader;
import pageobject.AccountPage;
import pageobject.HomePage;
import pageobject.LoginPage;

public class Logine extends Base {
	
	WebDriver driver;
	MyXLSReader reder;
	
	@Test(dataProvider="dataSupplier")
	public void TestLogin(HashMap<String, String>hMap) throws IOException {
		
		if(!DataUtil.isRunnable(reder, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			throw new SkipException("run mode is set to N,hence not executed");
			
		}
		
		driver =openBrowser(hMap.get("Browser"));
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		LoginPage loginpage=homePage.selectLoginOption();
		loginpage.enterEmail(hMap.get("Username"));
		loginpage.enterPassword(hMap.get("Password"));
		AccountPage accountPage=loginpage.clickOnLoginButton();
		
		String expectedResult=hMap.get("ExpectedResult");
		
		boolean exeptedConvertedResult = false;
		if(expectedResult.equalsIgnoreCase("Success")) {
			exeptedConvertedResult=true;
		}
		else if(expectedResult.equalsIgnoreCase("Failure")) {
			exeptedConvertedResult=false;
			
		}
		
		boolean actualResult=false;
		
		actualResult=accountPage.verifyTheDisplayOfEditYourAccountInformationOpetion();
		
		Assert.assertEquals(exeptedConvertedResult,exeptedConvertedResult);
		
		driver.quit();
	}
	
	public void Quit() {
		driver.quit();
		
		
	}
	@DataProvider
	public Object [] [] dataSupplier()  {
		Object [] [] data=null;
		
		
		try {
			reder = new MyXLSReader("src\\main\\resources\\data\\TutorialsNinja.xlsx");
			data=DataUtil.getTestData(reder, "LoginTest", "Data");
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		
		return data;
		
		
	}

}
