package com.project.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.project.setup.testSetup;

public class testEbay extends testSetup {

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
	public void ebayAll() throws Exception {

		driver.findElement(By.id("com.ebay.mobile:id/home")).click();
		driver.findElement(By
				.xpath("//android.widget.CheckedTextView[contains(@resource-id,'com.ebay.mobile:id/design_menu_item_text') and @text='Categories']"))
				.click();
		driver.findElement(By
				.xpath("//android.widget.TextView[contains(@resource-id,'com.ebay.mobile:id/category_name') and @text='Books & Magazines']"))
				.click();
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}
