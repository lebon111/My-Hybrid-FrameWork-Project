package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Pages.CheckOutPage;
import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.LoginPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.TestData.ExcelCode;

public class CheckOutTest extends TestBase {

	public CheckOutTest() throws Exception {
		super();
		
	}
	public WebDriver driver;
	public HomePage ShoppingC;
	public LoginPage loginpage;
	public HomePage homepage;
	public CheckOutPage checkout;
	public HomePage loginin;
	public HomePage searchProduct;
	
	
	@BeforeMethod
	public void CheckOutsetup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		loginpage = homepage.combiningTwoActionsToNavigateToLoginPage();
		loginin = new HomePage(driver);
		ShoppingC = new HomePage(driver);
		checkout = new CheckOutPage(driver);
		searchProduct = new HomePage(driver);
		
	}

	@Test(priority = 1)
	public void validateNavigatingToCheckoutPageFromShoppingCartPage()  {
		
		loginin.LoginIn();
		searchProduct.searchValidProduct();
		ShoppingC.clickShoppingCart();
		ShoppingC.clickCheckout();
		checkout.selectExistingAddress();
		checkout.clickStep2Continue();
		checkout.clickStep3Continue();
		checkout.clickStep4Continue();
		checkout.clickTermsCheckBox();
		checkout.clickStep5Continue();
		checkout.confirmOrder();	
	}
	@Test(priority = 2)
	public void validateCheckoutAsSignedInUserUsingExistingAddress () {
		
		loginin.LoginIn();
		ShoppingC.clickShoppingCart();
		ShoppingC.clickCheckout();
		checkout.selectExistingAddress();
		checkout.clickStep2Continue();
		checkout.clickStep3Continue();
		checkout.clickStep4Continue();
		checkout.clickTermsCheckBox();
		checkout.clickStep5Continue();
		checkout.confirmOrder();	
	}
	
	@Test(priority = 3 , dataProvider = "TNNewAddress", dataProviderClass = ExcelCode.class)
    public void validateCheckoutAsSignedInUserByEnteringMandatoryNewAddress(String firstName,String lastName,String address1, String city, String postcode,  String country, String state) {
		
		loginin.LoginIn();
		ShoppingC.clickShoppingCart();
		ShoppingC.clickCheckout();
		checkout.selectNewAddress();
		checkout.enterBillingDetails( firstName, lastName, address1, city, postcode,  country, state);
		checkout.clickStep3Continue();
		checkout.clickStep4Continue();
		checkout.clickTermsCheckBox();
		checkout.clickStep5Continue();
		checkout.confirmOrder();
		
		
		
		
	}
    @Test(priority = 5)
    public void validateCheckoutAsSignedInUserByEnteringAllFieldsNewAddress(String firstName,String lastName,String address1, String city, String postcode,  String country, String state) {
    		loginin.LoginIn();
    		ShoppingC.clickShoppingCart();
    		ShoppingC.clickCheckout();
    		checkout.selectNewAddress();
    		checkout.enterBillingDetails( firstName, lastName, address1, city, postcode,  country, state);
    		checkout.clickStep3Continue();
    		checkout.clickStep4Continue();
    		checkout.clickTermsCheckBox();
    		checkout.clickStep5Continue();
    		checkout.confirmOrder();
		
	}
    @Test(priority = 4)
    public void validateCheckoutAsSignedInUserWithoutEnteringAnyCredentialsNewAddress() {
    	loginin.LoginIn();
    	checkout.selectNewAddress();
    	checkout.clickStep2Continue();
    	Assert.assertTrue(checkout.retrieveAllWarningMessages(dataProp.getProperty("firstNameWarningMessage"),
    			dataProp.getProperty("lastNameWarningMessage"), 
    			dataProp.getProperty("address1WarningMessage"), 
    			dataProp.getProperty("cityWarningMessage"), 
    			dataProp.getProperty("postCodeWarningMessage"), 
    			dataProp.getProperty("regionStateWarningMessage")));
    	
    	
    	
    		
    		
		
	}
    
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
