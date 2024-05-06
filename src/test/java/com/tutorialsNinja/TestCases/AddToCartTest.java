package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsNinja.Pages.AddToCartPage;
import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.ProductPage;
import com.tutorialsNinja.TestBase.TestBase;

public class AddToCartTest extends TestBase  {

	public AddToCartTest() throws Exception {
		super();
		
	}
	public WebDriver driver; 
	public HomePage iPhoneLink;
	public AddToCartPage addToCart;
	public HomePage addToCartFromWishList;
	public ProductPage addToCartFromSearchResult;
	public HomePage loginin;
	public HomePage searchProduct;
	
	
	@BeforeMethod
	public void addToCartSetup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		addToCart = new AddToCartPage(driver);
		iPhoneLink = new HomePage(driver);
		searchProduct = new HomePage(driver);
		addToCartFromWishList = new HomePage(driver);
		loginin = new HomePage(driver);
			
	}
	@Test(priority = 1)
	public void validateAddingTheProductToCartFromHomePage() {
		iPhoneLink.clickIphoneLink();
		addToCart.getAddedItemText();
		addToCart.quantityTextBox();
		addToCart.clickAddToCardButton();
		addToCart.successMessageText();
		
		
		
	}
	@Test(priority = 2)
	public void validateAddingTheProductToCartWishListPage() {
		
		loginin.LoginIn();
		addToCartFromWishList.clickHomeLink();
		iPhoneLink.clickIphoneLink();
		addToCart.clickWishListButton();
		addToCart.successMessageTextWishList();	
		
		
		
	}
	@Test(priority = 3)
	public void validateAddingTheProductToCartFromSearchResultsPage() {
		
		
		searchProduct.searchValidProduct();
		searchProduct.searchProduct_Link();
		addToCart.retrieveItemCartTextSP();
		addToCart.deliveryDateTextBox();
	    addToCart.calendarButtonDate();
		addToCart.quantityTextBox();
		addToCart.clickAddToCardButton();
		addToCart.successMessageText();
		
		
	
	}
	
	@Test(priority = 4)
	public void validateAddingTheProductToCartFromTheProductsDisplayedIntheCategoryPage() {
		iPhoneLink.clickPhonesPDAs();
		iPhoneLink.clickIphoneLink();
		addToCart.getAddedItemText();
		addToCart.quantityTextBox();
		addToCart.successMessageText();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
