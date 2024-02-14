package pageobject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.readexcel;
import utilities.writeexcel;

public class OneCognizant extends BasePage{
	
	public OneCognizant(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Elements
	@FindBy(xpath="//div[@title=\"Join us for the Delivery Summit 2024: Learn more\"]")
	WebElement scroll;
	@FindBy(xpath="//input[@id='oneC_searchAutoComplete']")
	WebElement cgsd;
	@FindBy(xpath="//input[@id='oneC_searchAutoComplete']")
	WebElement serch;
	@FindBy(xpath="//div[@class='appsResultText']")
	WebElement livegsd;

	public void cgsdclick() throws InterruptedException 
	{
		//clicking search box
		Thread.sleep(3000);
		cgsd.click();
	}
	public void serchgsd() throws InterruptedException, IOException 
	{
		//searching for GSD
		Thread.sleep(3000);
		String file = (System.getProperty("user.dir")+"/excelsheet/input.xlsx");
    	serch.sendKeys(readexcel.getCellData(file,"search", 1, 0));
	}
	public void livegsdclick() 
	{
		//clicking on live support GSD
		livegsd.click();
	}
	public void url() throws InterruptedException 
	{
		//verifying navigation from oneC to GSD
		Thread.sleep(1000);
		String p=driver.getCurrentUrl();
		String Url = "https://onecognizant.cognizant.com/Home?GlobalAppId=926";
		Assert.assertEquals(p, Url);
	}
}
