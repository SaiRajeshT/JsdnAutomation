package com.jamcracker.commonFunctions.customer;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.jamcracker.constants.Constants;
import com.jamcracker.objectRepository.customer.ScriptingPage;
import com.jamcracker.utilities.TestBase;

public class SuccessScriptActions extends TestBase {
	public static void verifySuccessScriptActions(String scriptName) {
		ScriptingPage objScriptPage = new ScriptingPage();

		try {
			objScriptPage.manageLink.click();

			objScriptPage.scriptingLink.click();
			if (getDriver().getTitle().equals(Constants.MANAGE_SCRIPT_PAGE_TITLE)) {
				Reporter.log("Successfully Navigated to Manage Script Page");
			}

			else {
				Reporter.log(
						"<p style='color:red'>Issue while Navigating to Manage script Page. Look in to the issue. </p>");
				Assert.fail();
			}
			
			objScriptPage.scriptSearchTextBox.sendKeys(scriptName);
			Thread.sleep(2000);
			objScriptPage.scriptSearchTextBox.sendKeys(Keys.ENTER);
			objScriptPage.getscriptAction(scriptName).click();
			List<WebElement> list = objScriptPage.getActions();
			for(WebElement element : list)
			{
				if (element.getText().equalsIgnoreCase("View Log"))
						{
						  Reporter.log("View log option displayed for Success Script");
						}
				else if(element.getText().equalsIgnoreCase("View Script")){
					Reporter.log("View Script option displayed for Success Script");
				}
				else if(element.getText().equalsIgnoreCase("Delete")){
					Reporter.log("Delete option displayed for Success Script");
				}
				else{
					Reporter.log("Proper options are not displayed for Saved Script");
					Assert.fail();
					
				}
				
			}
			
		
		} 
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail();

		}
	}

}
