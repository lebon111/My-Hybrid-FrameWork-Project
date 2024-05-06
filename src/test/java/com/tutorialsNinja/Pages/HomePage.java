package com.tutorialsNinja.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	@FindBy(linkText = "iPhone")
	private WebElement iPhoneLink;
	
	@FindBy(xpath = "//span[text()='Shopping Cart']")
	private WebElement shoppingCartButton;
	
	
	
	@FindBy(linkText = "Wish List")
	private WebElement wishList;
	
	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
	private WebElement shoppingCart;
	
	@FindBy(xpath = "//span[normalize-space()='Checkout']")
	private WebElement checkout;
	
	@FindBy(linkText = "Phones & PDAs")
	private WebElement PhonesPDAs;
	
	@FindBy(linkText = "Mac (1)")
	private WebElement MacLink;
	
	@FindBy(linkText = "Qafox.com")
	private WebElement HomeLink;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement searchProductLink;
	
	
	
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	
	public LoginPage combiningTwoActionsToNavigateToLoginPage() {
		myAccountDropdown.click();	
		loginOption.click();
		return new LoginPage(driver);		
	}
	
	public RegisterPage combiningTwoActionsToNavigateToRegisterPage() {
		myAccountDropdown.click();	
		registerOption.click();
		return new RegisterPage(driver);		
	}
	
	public void enterProductName(String validProductText) {
		searchBox.sendKeys(validProductText);
	}
	
	public ProductPage clickOnSearchButton() {
		searchButton.click();
		return new ProductPage(driver);
	}
	
	public ProductPage navigateToProductPage(String validProductText) {
		searchBox.sendKeys(validProductText);
		searchButton.click();
		return new ProductPage(driver);
	}
	
	public void clickIphoneLink() {
		iPhoneLink.click();
	}
	public void clickShoppingCartButton() {
		shoppingCartButton.click();
		
	}
	
	public void clickWishList() {
		wishList.click();
		
		
	}
	public void clickShoppingCart() {
		shoppingCart.click();
		
	}
	public void clickCheckout() {
		checkout.click();
		
	}
	public void clickPhonesPDAs() {
		PhonesPDAs.click();
	}
	public void clickMacLink() {
		MacLink.click();
	}
	//login Method//
	public void LoginIn() {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
	}
	public void searchValidProduct() {
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		driver.findElement(By.linkText("HP LP3065")).click();
	}
	public void clickHomeLink() {
		HomeLink.click();
	}
	public void searchProduct_Link() {
		searchProductLink.click();
		
	}

}
