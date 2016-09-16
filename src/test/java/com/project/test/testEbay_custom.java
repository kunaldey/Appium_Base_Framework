package com.project.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.project.setup.testSetup;

public class testEbay_custom extends testSetup {

	@Test
	public void eBayLogin() throws Exception {

		driver.findElement(By.id("com.ebay.mobile:id/home")).click();
		driver.findElement(By
				.xpath("//android.widget.CheckedTextView[contains(@resource-id,'com.ebay.mobile:id/design_menu_item_text') and @text='Categories']"))
				.click();
		driver.findElement(By
				.xpath("//android.widget.TextView[contains(@resource-id,'com.ebay.mobile:id/category_name') and @text='Books & Magazines']"))
				.click();
	}
	
	@Test
	public void ebayCategory() throws Exception {
		//logger=report.startTest("ebayCategory");
		driver.findElement(By.id("com.ebay.mobile:id/home")).click();
			//logger.log(LogStatus.INFO, "Clicked on Ebay home menu");
		driver.findElement(By
				.xpath("//android.widget.CheckedTextView[contains(@resource-id,'com.ebay.mobile:id/design_menu_item_text') and @text='Categories']"))
				.click();
			//logger.log(LogStatus.PASS, "Opened product categories");
		driver.findElement(By
				.xpath("//android.widget.TextView[contains(@resource-id,'com.ebay.mobile:id/textview_category') and @text='Books & Magazines']"))
				.click();
			//logger.log(LogStatus.PASS, "Opened Books & Magazines category");
		driver.findElement(By.id("com.ebay.mobile:id/home")).click();
			//logger.log(LogStatus.INFO, "Clicked on Ebay home menu");
		driver.findElement(By
				.xpath("//android.widget.CheckedTextView[contains(@resource-id,'com.ebay.mobile:id/design_menu_item_text') and @text='Home']"))
				.click();
			//logger.log(LogStatus.PASS, "Home page is visible");
		
	}
	
	@Test
	public void ebayRegister() throws Exception {
		//logger=report.startTest("ebayRegister");
		String pageHeader = "";
		driver.findElement(By.id("com.ebay.mobile:id/button_register")).click();
			//logger.log(LogStatus.INFO, "Clicked on Register button");
		pageHeader = driver.findElement(By.id("com.ebay.mobile:id/title")).getText();
		if(pageHeader.equalsIgnoreCase("Register")){
			//logger.log(LogStatus.PASS, "Opened Register page");
				driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
					//logger.log(LogStatus.INFO, "Entered email id");
				driver.findElement(By.id("remail")).sendKeys("abcd@gmail.com");
					//logger.log(LogStatus.INFO, "Entered email id again");
				driver.findElement(By.id("PASSWORD")).sendKeys("abcd1234!@#$");
					//logger.log(LogStatus.INFO, "Entered Password");
				driver.findElement(By.id("firstname")).sendKeys("Gullu");
					//logger.log(LogStatus.INFO, "Entered first name");
				driver.findElement(By.id("lastname")).sendKeys("Dada");
					//logger.log(LogStatus.INFO, "Entered last name");
				driver.findElement(By.id("phoneFlagComp1")).sendKeys("2989563656");
					//logger.log(LogStatus.INFO, "Entered mobile number");
				driver.findElement(By.id("com.ebay.mobile:id/home")).click();
				//logger.log(LogStatus.PASS, "Home page is visible");
		}else{
			//logger.log(LogStatus.FAIL, "Register page could not be opened");
		}
	}

	@Test
	public void ebaySelling() throws Exception{
		//logger=report.startTest("ebaySelling");
		String pageHeader = "";
		driver.findElement(By.id("com.ebay.mobile:id/capsule_selling")).click();
		//logger.log(LogStatus.INFO, "Clicked on Selling button");
		pageHeader = driver.findElement(By.id("com.ebay.mobile:id/title")).getText();
		if(pageHeader.equalsIgnoreCase("Selling")){
			//logger.log(LogStatus.PASS, "Opened Selling page");
		}else{
			//logger.log(LogStatus.FAIL, "Selling page could not be opened");
		}
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}
