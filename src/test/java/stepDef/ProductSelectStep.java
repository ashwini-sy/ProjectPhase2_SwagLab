package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSelectStep {

	WebDriver driver = BaseClass.driver;

	@Given("^User is on the  SwagLab Application$")
	public void user_is_on_the_swaglab_application() throws Throwable {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@When("^Enters the username \"([^\"]*)\"$")
	public void enters_the_username_something(String strArg1) throws Throwable {
		WebElement un = driver.findElement(By.id("user-name"));
		un.sendKeys(strArg1);
	}

	@When("^User select the product \"([^\"]*)\"$")
	public void user_select_the_product_something(String product) throws Throwable {

		WebElement addtocart = driver.findElement(By.xpath("//*[text()='" + product + "']/following::button[1]"));
		addtocart.click();
	}

	@When("^User select the list of product$")
	public void user_select_the_list_of_product(DataTable table) throws Throwable {

		String Product1 = table.cell(1, 1);
		String Product2 = table.cell(2, 1);
		String Product3 = table.cell(3, 1);

		WebElement addprd1 = driver.findElement(By.xpath("//*[text()='" + Product1 + "']/following::button[1]"));
		addprd1.click();
		WebElement addprd2 = driver.findElement(By.xpath("//*[text()='" + Product2 + "']/following::button[1]"));
		addprd2.click();
		WebElement addprd3 = driver.findElement(By.xpath("//*[text()='" + Product3 + "']/following::button[1]"));
		addprd3.click();

	}

	@Then("^User able to see the selected product in cart item$")
	public void user_able_to_see_the_selected_product_in_cart_item() throws Throwable {
		WebElement Shoppingcart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		Shoppingcart.click();

		System.out.println("Shopping cart page");
		/*WebElement openmenu=driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
		openmenu.click();
		WebElement logout=driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		logout.click();*/
	}

	@And("^Enters the password \"([^\"]*)\"$")
	public void enters_the_password_something(String strArg1) throws Throwable {
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys(strArg1);
	}

}
