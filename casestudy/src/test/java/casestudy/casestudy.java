package casestudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class casestudy {
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	@Given("The browser is opened and URL is typed")
	public void the_browser_is_opened_and_URL_is_typed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\Harii\\chrome driver\\chromedriver.exe");
		
		//create an instance of chrome driver
		driver=new ChromeDriver();
		//Open the URL
		driver.get("http://192.168.40.4:8083/TestMeApp1");
		driver.manage().window().maximize();
	}
	
	@When("I click on the SignUp button")
	public void i_click_on_the_SignUp_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.partialLinkText("SignUp")).click();
	}

	@When("I enter Username {string}")
	public void i_enter_Username(String username) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
	driver.findElement(By.id("userName")).sendKeys(username);
	}

	@When("I enter First Name {string} and Last Name {string}")
	public void i_enter_First_Name_and_Last_Name(String fname, String lname) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
	driver.findElement(By.id("firstName")).sendKeys(fname);
	driver.findElement(By.id("lastName")).sendKeys(lname);
	}

	@When("I enter Password {string} and confirm password {string}")
	public void i_enter_Password_and_confirm_password(String password, String confirmpass) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("pass_confirmation")).sendKeys(confirmpass);
	}

	@When("I enter Male\\/female {string}")
	public void i_enter_Male_female(String gender) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();\
	if (gender=="Male") {
		driver.findElement(By.xpath(".//span[text()='Male']")).click();
	} else {
		driver.findElement(By.xpath(".//span[text()='Female']")).click();
	}
	}

	@When("I enter Email {string} and Mobile number {string}")
	public void i_enter_Email_and_Mobile_number(String email, String mobile) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
	driver.findElement(By.id("emailAddress")).sendKeys(email);
	driver.findElement(By.id("mobileNumber")).sendKeys(mobile);
	}

	@When("I enter DOB {string}")
	public void i_enter_DOB(String dob) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
	driver.findElement(By.id("dob")).sendKeys(dob);
	}

	@When("I enter Address {string}")
	public void i_enter_Address(String address) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
	driver.findElement(By.id("address")).sendKeys(address);
	}

	@When("I Choose Security question {string}")
	public void i_Choose_Security_question(String securityqn) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
	Select secqn=new Select(driver.findElement(By.id("securityQuestion")));
	secqn.selectByVisibleText(securityqn);
	}

	@When("I enter the answer {string}")
	public void i_enter_the_answer(String answer) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
	driver.findElement(By.id("answer")).sendKeys(answer);
	}
	
	@When("I click on Register button")
	public void i_click_on_Register_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.xpath(".//input[@class='btn btn-lg btn-success col-xs-3 col-md-offset-0']")).click();
	}
	
	@When("I click on the SignIn button")
	public void i_click_on_the_SignIn_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.partialLinkText("SignIn")).click();
	}

	@When("I enter the {string} and {string}")
	public void i_enter_the_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.id("userName")).sendKeys(string);
		driver.findElement(By.id("password")).sendKeys(string2);
	}

	@When("I click on Login button")
	public void i_click_on_Login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.name("Login")).click();
	}

	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText("SignOut"))));
		//driver.close();
	}

	@Given("Alex has registered into TestMe App")
	public void alex_has_registered_into_TestMe_App() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	@When("Alex search a particular product like headphones")
	public void alex_search_a_particular_product_like_headphones() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		driver.findElement(By.id("myInput")).sendKeys("Headphone");
		driver.findElement(By.xpath(".//input[@value='FIND DETAILS']")).click();
	}

	@When("try to proceed to payment without adding any item in the cart")
	public void try_to_proceed_to_payment_without_adding_any_item_in_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		if(driver.findElements(By.partialLinkText("Cart")).size()!=0) {
			driver.findElement(By.partialLinkText("Add to cart")).click();
		}
		else {
			System.out.println("\n Cart icon unavailable");
		}
	}

	@Then("TestmeApp doesn't display the cart icon")
	public void testmeapp_doesn_t_display_the_cart_icon() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		Assert.assertEquals(0,driver.findElements(By.partialLinkText("Cart")).size());
	}

	@Then("click on add to cart button")
	public void click_on_add_to_cart_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	@Then("cart icon will be visible")
	public void cart_icon_will_be_visible() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	@Then("click on the cart icon")
	public void click_on_the_cart_icon() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}
}
