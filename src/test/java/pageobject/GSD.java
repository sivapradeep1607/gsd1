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

public class GSD extends BasePage{
	
	public GSD(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Elements
	@FindBy(xpath="//p[text()='Welcome to the all-in-one Live Support!']")
	WebElement message;
	@FindBy(xpath="//a[@id='menu1']")
	WebElement dlang;
	@FindBy(xpath="//*[@class=\"dropdown-menu langList show\"]")
	List<WebElement> listlang;
	@FindBy(xpath="//a[@id='menu2']")
	WebElement dcountry;
	@FindBy(xpath="/html/body/nav[1]/div/form/div[2]/ul/li/a")
	List<WebElement> lcountry;
	@FindBy (xpath="//a[@id=\"menu2\"]")
	WebElement c2;
	@FindBy (xpath="//div[text()=\"IT Infra Support\"]")
	WebElement info1;
	@FindBy (xpath="(//div[@class=\"eachTileRow\"])[1]//div[@class=\"col-md-12 application-tiles\"]") 
	List<WebElement> tool1;
	@FindBy (xpath="//div[text()=\"Human Resources\"]")
	WebElement info2;
	@FindBy (xpath="(//div[@class=\"eachTileRow\"])[2]//div[@class=\"col-md-12 application-tiles\"]")
	List<WebElement> tool2;
	@FindBy (xpath="//div[text()=\"IT Application Support\"]")
	WebElement info3;
	@FindBy (xpath="(//div[@class=\"eachTileRow\"])[3]//div[@class=\"col-md-12 application-tiles\"]")
	List<WebElement> tool3;
	@FindBy (xpath="//div[text()=\"Policy & Process Support\"]")
	WebElement info4;
	@FindBy (xpath="(//div[@class=\"eachTileRow\"])[4]//div[@class=\"col-md-12 application-tiles\"]")
	List<WebElement> tool4;
	@FindBy (xpath="/html/body/nav[1]/div/form/div[2]/ul/li/a")
	List<WebElement> Conlist1;	
	
	public String wmessage() throws InterruptedException 
	{
		//switching to welcome message frame
		Thread.sleep(5000);
		driver.switchTo().frame(1);
		String welcome = message.getText();
		return welcome;
	}	
	public void welmsg() throws InterruptedException
	{
		//verifying welcome message
		Thread.sleep(8000);
		Assert.assertEquals(wmessage(),"Welcome to the all-in-one Live Support!");
	}
	public void dlang() throws InterruptedException, IOException
	{
		//printing default language
		dlang.click();
		String deflang=dlang.getText();
		System.out.println("Default Language:");
		System.out.println("-----------------");
		System.out.println(deflang);
		writeexcel.getCellData("Sheet1", 0, 0, deflang);
		Thread.sleep(5000);
	}	
	public void listoflanguage() throws InterruptedException, IOException 
	{
		//printing all languages from drop down
		String langNames;
		int row=2;
		 for(WebElement a:listlang) 
		 {
			langNames =a.getText();
			System.out.println("List of available Languages:");
			System.out.println("----------------------------");
			writeexcel.getCellData("Sheet1", row, 0, langNames);
			System.out.println(langNames);
			row++;
		    Thread.sleep(5000);
		}
	}
	public void defaultcountry() throws InterruptedException, IOException 
	{
		//printing default country
		dcountry.click();
		String defcountry=dcountry.getText();
		System.out.println("Default Country:");
		System.out.println("----------------");
		System.out.println(defcountry);
		writeexcel.getCellData("Sheet1", 0, 1, defcountry);
		Thread.sleep(6000);
	}
	public void listofcountries() throws InterruptedException, IOException 
	{
		//printing all countries from drop down
		int row=2;
		for(WebElement c:lcountry) {
			String countryName=c.getText();
			System.out.println("List of available Countries:");
			System.out.println("----------------------------");
			System.out.println(countryName);
			writeexcel.getCellData("Sheet1", row, 1, countryName);
			row++;
			}
	}
	public void defaultcountryinfo() throws InterruptedException, IOException 
	{
		//printing all information for default country
		System.out.println("Default Country information:");
		System.out.println("----------------------------");
		toolTipinfo("Sheet2");
		Thread.sleep(6000);
	}
	public void randomcountryinfo() throws InterruptedException, IOException 
	{
		//printing all information for 2 randomly selected countries 
	    int r1 = (int)Math.ceil(55*Math.random()),r2;
	    do {
	    	r2 = (int)Math.ceil(55*Math.random());
	    }while(r1==r2);
	    System.out.println("Random No1:"+r1);
	    System.out.println("Random No2:"+r2);
	    Thread.sleep(2000);
	    Conlist1.get(r1).click();
	    System.out.println("Random Country information:");
		System.out.println("---------------------------");
		System.out.println(" ");
	    toolTipinfo("Sheet3");
	    driver.findElement(By.xpath("(//a[@id='menu2'])[1]")).click();
	    Thread.sleep(6000);
	    Conlist1.get(r2).click();
	    System.out.println("Random Country information:");
		System.out.println("---------------------------");
		System.out.println(" ");
		toolTipinfo("Sheet4");
		captureScreenshot();
		Thread.sleep(6000);
	}
    
	public void toolTipinfo(String sheetname) throws IOException 
	{
		//getting information
	    String c22 = c2.getText();
	    System.out.println(c22);
	    System.out.println(" ");
	    writeexcel.getCellData(sheetname, 0, 0, c22);
	    //
	    int row1=2;
	    int row2=2;
		String tool = info1.getText();
		System.out.println(tool);
		writeexcel.getCellData(sheetname, 1, 0, tool);
	    for(WebElement comments:tool1) {
	    	System.out.println("----------------------------");
	    	System.out.println(comments.getText());
	    	writeexcel.getCellData(sheetname, row1, 0, comments.getText());
	    	row1++;
	    	System.out.println(comments.getAttribute("data-bs-original-title"));
	    	writeexcel.getCellData(sheetname, row2, 1, comments.getAttribute("data-bs-original-title"));
	    	row2++;
	    	System.out.println(" ");
	    }
	    //
	    row1=2;
	    row2=2;
		String too2 = info2.getText();
		System.out.println(too2);
		writeexcel.getCellData(sheetname, 1, 2, too2);
	    for(WebElement com2:tool2) {
	    	System.out.println("----------------------------");
	    	System.out.println(com2.getText());
	    	writeexcel.getCellData(sheetname, row1, 2, com2.getText());
	    	row1++;
	    	System.out.println(com2.getAttribute("data-bs-original-title"));
	    	writeexcel.getCellData(sheetname, row2, 3, com2.getAttribute("data-bs-original-title"));
	    	row2++;
	    	System.out.println(" ");
	    }
	    //
	    row1=2;
	    row2=2;
		String too3 = info3.getText();
		System.out.println(too3);
		writeexcel.getCellData(sheetname, 1, 4, too3);
	    for(WebElement com3:tool3) {
	    	System.out.println("----------------------------");
	    	System.out.println(com3.getText());
	    	writeexcel.getCellData(sheetname, row1, 4, com3.getText());
	    	row1++;
	    	System.out.println(com3.getAttribute("data-bs-original-title"));
	    	writeexcel.getCellData(sheetname, row2, 5, com3.getAttribute("data-bs-original-title"));
	    	row2++;
	    	System.out.println(" ");
	    }
	    //
	    row1=2;
	    row2=2;
		String too4 = info4.getText();
		System.out.println(too4);
		writeexcel.getCellData(sheetname, 1, 6, too4);
	    for(WebElement com4:tool4) {
	    	System.out.println("----------------------------");
	    	System.out.println(com4.getText());
	    	writeexcel.getCellData(sheetname, row1, 6, com4.getText());
	    	row1++;
	    	System.out.println(com4.getAttribute("data-bs-original-title"));
	    	writeexcel.getCellData(sheetname, row2, 7, com4.getAttribute("data-bs-original-title"));
	    	row2++;
	    	System.out.println(" ");
	    }
    }
	private static void captureScreenshot() throws IOException, InterruptedException {
    	// Capture the results screenshot
    	Thread.sleep(5000);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourcePath = screenshot.getScreenshotAs(OutputType.FILE);
        File targetPath = new File("C:\\Users\\2303798\\Downloads\\sample (2)\\sample\\screenshot\\i.png");
        FileUtils.copyFile(sourcePath, targetPath);
    }
	
}
