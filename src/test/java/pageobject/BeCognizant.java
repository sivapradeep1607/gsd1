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

public class BeCognizant extends BasePage{

	public BeCognizant(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Elements
	@FindBy(xpath= "//div[@id=\"O365_HeaderRightRegion\"]")
	WebElement usericon;
	@FindBy(xpath="//div[@id='mectrl_currentAccount_primary']")
	WebElement user;
	@FindBy(xpath="//div[@title='OneCognizant']")
	WebElement onecognizant;
	@FindBy(xpath="//div[text()='OneCognizant']")
	WebElement onecc;
	@FindBy(xpath = "//div[@id=\"89c5ffca-2ffb-4052-a723-e99c8c9a14ef\"]")
	WebElement AppandTools;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
	
	
	
	
	public void EleClick() throws InterruptedException
	{
		//clicking user icon
		usericon.click();
		Thread.sleep(3000);
	}	
	public String userverify() 
	{
		//getting user information
		String username = user.getText();
		return username;
	}	
	public void GetUserVerify() throws InterruptedException
	{
		//verifying the user details
		Thread.sleep(7000);
		Assert.assertEquals(userverify(), "S, Pradeep Kumar (Cognizant)");
		usericon.click();
		Thread.sleep(7000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments [0].scrollIntoView();", AppandTools);
	    wait.until(ExpectedConditions.visibilityOf(AppandTools));
	}
	public String onec() 
	{
		//get text of oneC
		String oc=onecognizant.getText();
		return oc;
	}
	public void Getonec() 
	{
		//verifying OneC
		Assert.assertEquals(onec(),"OneCognizant");
	}
	public void oneclick() throws InterruptedException
	{
		//clicking the oneC
		onecc.click();
		Thread.sleep(3000);
	}
	
}