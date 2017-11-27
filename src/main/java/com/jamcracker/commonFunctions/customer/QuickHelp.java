package com.jamcracker.commonFunctions.customer;

import java.util.ArrayList;

import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.QuickHelpPage;
import com.jamcracker.utilities.TestBase;
import com.jamcracker.utilities.TwoWindowsSwitch;

public class QuickHelp extends TestBase {

	public static void verifyquickHelp(ArrayList<String> linksList, ArrayList<String>helpText)
	{
		QuickHelpPage objQuickHelp = new QuickHelpPage();
		objQuickHelp.quickHelpLink.click();
		int count  =0;
		for(String str : linksList)
		{
			if(driver.getPageSource().contains(str))
			{
				Reporter.log(str+ " Is displayed in " +driver.getTitle()+ "Page.");
				objQuickHelp.getLink(str).click();
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TwoWindowsSwitch.getWindowHandles();
			TwoWindowsSwitch.switchToChild();
			if(driver.getPageSource().contains(helpText.get(count)))
			{
				System.out.println(driver.getTitle());
				Reporter.log("Navigated to "+driver.getTitle()+" Page." );
				Reporter.log(helpText.get(count) + " Is Displayed in online help document");
			}
			driver.close();
			TwoWindowsSwitch.switchToParent();
			count++;
		}
		
	}
	
}
