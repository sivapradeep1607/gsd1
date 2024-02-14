package stepdefinition;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import factory.baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.BeCognizant;
import pageobject.GSD;
import pageobject.OneCognizant;

public class gsd {
	
	BeCognizant b;
	OneCognizant o;
	GSD g;
	
	public static WebDriver driver =baseclass.getDriver();
	@Given ("open the link")
	public void Given_open_the_link() throws InterruptedException {
	  b=new BeCognizant(baseclass.getDriver());
	  b.EleClick();

	}
	@Then("capture user information")
	public void capture_user_information() throws InterruptedException {
		Thread.sleep(3000);
		b.GetUserVerify();
	    }

	@When("OneCognizant is present or not")
	public void one_cognizant_is_present_or_not() throws InterruptedException {
	   b.Getonec();
	   Thread.sleep(3000);
	}

	@Then("Navigate to one cognizant")
	public void navigate_to_one_cognizant() throws InterruptedException {
	    b.oneclick();
	}

	@Given("clicking of serch box")
	public void clicking_of_serch_box() throws InterruptedException {
		o=new OneCognizant(baseclass.getDriver());
		Set<String> windowids = driver.getWindowHandles();
		  List<String> windis = new ArrayList<String>(windowids);
		  String parent = windis.get(0);
		  String child = windis.get(1);
		  driver.switchTo().window(child);
		Thread.sleep(6000);
		o.cgsdclick();
	}

	@When("Serching of GSD")
	public void serching_of_gsd() throws InterruptedException, IOException {
	    o.serchgsd();
	}

	@Then("Clicking of GSD Live Support")
	public void clicking_of_gsd_live_support() {
	  o.livegsdclick();  
	}

	@Then("Verify for successful navigation to GSD module")
	public void verify_for_successful_navigation_to_gsd_module() throws InterruptedException {
	 Thread.sleep(1000);
      o.url();
	}

	@Given("verify if welcome message id displayed or not")
	public void verify_if_welcome_message_id_displayed_or_not() throws InterruptedException {
		Thread.sleep(5000);
		g=new GSD(baseclass.getDriver());
		g.wmessage();
	}

	@Then("Print default selected language")
	public void print_default_selected_language() throws InterruptedException, IOException {
	    g.dlang();
	}

	@Then("Print all languages from drop down")
	public void print_all_languages_from_drop_down() throws InterruptedException, IOException {
	    g.listoflanguage();
	}

	@When("Print the default country")
	public void print_the_default_country() throws InterruptedException, IOException {
	    g=new GSD(baseclass.getDriver());
	    g.defaultcountry();

	}

	@When("Print the list of country")
	public void print_the_list_of_country() throws InterruptedException, IOException {
	    g.listofcountries();
	}
	
	@When("Print the defaulr country info")
	public void print_the_info_in_defcountry() throws InterruptedException, IOException {
	    g.defaultcountryinfo();
	}

	@Then("Find the random number and print the list of query")
	public void find_the_random_number_and_print_the_list_of_query() throws InterruptedException, IOException {
		g.randomcountryinfo();
	}
}