package com.project.test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.project.setup.testSetup;

public class testCalc extends testSetup {

	@Test
	public void Sum() throws Exception {

		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02")).click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add")).click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_05")).click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal")).click();

		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/history_button")).click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_00")).click();

		// Get result from result text box.
		String result = driver.findElement(By.className("android.widget.EditText")).getText();
		System.out.println("Number sum result is : " + result);

	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}
