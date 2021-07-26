package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginStep {
	
	WebDriver driver=BaseClass.driver;
	@Given("^User open the SwagLab Application$")
    public void user_open_the_swaglab_application() throws Throwable {
        
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
    }

    @When("^User enter the correct username \"([^\"]*)\"$")
    public void user_enter_the_correct_username_something(String username) throws Throwable {
    	
    	WebElement un=driver.findElement(By.id("user-name"));
        un.sendKeys(username);
        
     
    }

    @When("^User enter the wrong username \"([^\"]*)\"$")
    public void user_enter_the_wrong_username_something(String username) throws Throwable {
    	WebElement un=driver.findElement(By.id("user-name"));
        un.sendKeys(username);
       
    }

    @Then("^User should be navigated to product page successfully$")
    public void user_should_be_navigated_to_product_page_successfully() throws Throwable {
        String actualtxt=driver.findElement(By.xpath("//div[@class='header_secondary_container']/span")).getText();	
        String  Expectedtxt="PRODUCTS";
       
       Assert.assertEquals(Expectedtxt, actualtxt);
    	
    }

    @Then("^User should get error message$")
    public void user_should_get_error_message() throws Throwable {
    	String actualtxt=driver.findElement(By.xpath("//h3[@data-test='error']")).getText();	
        String  Expectedtxt="Epic sadface: Username and password do not match any user in this service";      
       Assert.assertEquals(Expectedtxt, actualtxt);
    	
    	
       
    }

    @And("^User enter the correct password  \"([^\"]*)\"$")
    public void user_enter_the_correct_password_something(String password) throws Throwable {
    	  WebElement pwd=driver.findElement(By.id("password"));
          pwd.sendKeys(password);
    }

    @And("^User click on login button$")
    public void user_click_on_login_button() throws Throwable {
    	  WebElement login=driver.findElement(By.id("login-button"));
    	  login.click();
       
    }

    @And("^User enter the wrong password  \"([^\"]*)\"$")
    public void user_enter_the_wrong_password_something(String password) throws Throwable {
    	WebElement pwd=driver.findElement(By.id("password"));
        pwd.sendKeys(password);
    }

}
