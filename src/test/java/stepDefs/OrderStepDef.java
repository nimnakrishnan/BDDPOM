package stepDefs;

import org.junit.Assert;

import base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class OrderStepDef extends TestBase{

	
	HomePage homePage;
	SearchResultPage resultPage;
	
	@Before 
	public void setup()
	{
		initialize();
		homePage = new HomePage();
		resultPage = new SearchResultPage();
		
	}
	
		@Given("User is on Home Page")
		public void user_is_on_home_page() {
		  String pageTitle = homePage.isHomepage();
		  Assert.assertEquals("Your Store", pageTitle);
		}


		@When("User search {string}")
		public void user_search(String stringItem) {
			homePage.searchItem(stringItem);
		   
		}
		@When("Add Item to cart")
		public void add_item_to_cart() {
			resultPage.addToCart();
			System.out.println("add_item_to_cart");
		}
		@Then("Item must be in Cart")
		public void item_must_be_in_cart() throws InterruptedException {
			Thread.sleep(2000);
			boolean isItemAdded = resultPage.isItemAdded();
			Assert.assertTrue(isItemAdded);
		}



			
}
