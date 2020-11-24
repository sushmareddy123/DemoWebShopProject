package com.scripts.DemoWorkShop;

import org.testng.annotations.Test;

import com.main.DemoWorkShop.ApplicationReusableFunctions;
import com.main.DemoWorkShop.ExcelReader;
import com.objectRepository.DemoWorkShop.CheckOutPageLocators;
import com.objectRepository.DemoWorkShop.HomePageLocators;
import com.objectRepository.DemoWorkShop.LoginPageLocators;
import com.objectRepository.DemoWorkShop.ShoppingCartPageLocators;

import junit.framework.Assert;

public class DemoWorkShopFunction extends ApplicationReusableFunctions {

	@Test
	public void endToEndScenario() throws Throwable {
		eReader = new ExcelReader("TestData//DemoWorkShopTestData.xlsx", "BillingAddress", 0);

		// click on Login button
		driver.findElement(LoginPageLocators.loginButton).click();

		// Avoiding hardcoded waits
		waitForVisibilityOfElement(LoginPageLocators.emailfield, "Email field");

		// Fetching the welcome text from page
		String welcomeText = driver.findElement(LoginPageLocators.welcomeMessage).getText();
		System.out.println("Welcome Test message : " + welcomeText);

		// Validate “Welcome, Please Sign In!” message
		Assert.assertEquals(prop.getProperty("welcomemessage"), welcomeText);

		// login functionality, username and password are fetching from
		// properties file
		logIn(prop.getProperty("username"), prop.getProperty("password"));

		// get text of account id
		String accountIdText = driver.findElement(HomePageLocators.userAccountId).getText();
		System.out.println("Account id Text " + accountIdText);

		// validate the account id
		Assert.assertEquals(prop.getProperty("username"), accountIdText);

		// clear shopping cart
		clearShoppingCart();

		// clicking on Demoworkshop link to navigate to home page
		driver.findElement(HomePageLocators.demoWorkShopLink).click();

		waitForVisibilityOfElement(HomePageLocators.booksLink, "Books link under Categories");

		// Select “Books” from Categories
		driver.findElement(HomePageLocators.booksLink).click();

		waitForVisibilityOfElement(HomePageLocators.selectBook, "Select product for list of products");

		// Select a book from the list displayed
		driver.findElement(HomePageLocators.selectBook).click();

		waitForVisibilityOfElement(HomePageLocators.productName, "Product Details");

		// Get the price details
		String priceDetails = driver.findElement(HomePageLocators.priceDetails).getText();
		System.out.println(" price details " + priceDetails);

		// Enter quantity
		driver.findElement(HomePageLocators.quantityDetails).clear();
		driver.findElement(HomePageLocators.quantityDetails).sendKeys(eReader.getColData("QuantityDetails", 1));

		// Click on add to cart button
		driver.findElement(HomePageLocators.addToCartButton).click();

		String productAddedToCartMes = driver.findElement(HomePageLocators.productAddedMess).getText();
		System.out.println("Product added to cart message :" + productAddedToCartMes);

		// Validate the product added to cart message
		Assert.assertEquals(eReader.getColData("Cartmessage", 1), productAddedToCartMes);

		// click on shopping cart
		driver.findElement(HomePageLocators.shoppingCartLink).click();

		waitForVisibilityOfElement(ShoppingCartPageLocators.productName, "Product Details");

		// verify the sub total details
		String subtotalDetails = driver.findElement(ShoppingCartPageLocators.subtotal).getText();
		System.out.println("Shopping sub total details :" + subtotalDetails);

		// validate the “Sub-Total” Price for selected book
		if (subtotalDetails.equalsIgnoreCase("40.00")) {
			System.out.println("Proudct details matched");
		} else {
			System.out.println("Product details not matched");
		}

		// select terms of service
		driver.findElement(ShoppingCartPageLocators.termsOfService).click();

		// click on checkout button
		driver.findElement(ShoppingCartPageLocators.checkoutButton).click();

		waitForVisibilityOfElement(CheckOutPageLocators.billingAddressDropDown, "Billing address dropdown");

		// Select “New Address” From “Billing Address” drop down.
		selectByVisibleText(CheckOutPageLocators.billingAddressDropDown, "New Address");

		// Fill all mandatory fields in “Billing Address”
		billingAddressSelect(eReader.getColData("BillingAddressDetails", 1),
				eReader.getColData("BillingAddressDetails", 2), eReader.getColData("BillingAddressDetails", 3),
				eReader.getColData("BillingAddressDetails", 4), eReader.getColData("BillingAddressDetails", 5),
				eReader.getColData("BillingAddressDetails", 6), eReader.getColData("BillingAddressDetails", 7),
				eReader.getColData("BillingAddressDetails", 8));

		// click on continue button
		driver.findElement(CheckOutPageLocators.continueButton).click();

		// Select the “Shipping Address”
		shippingSameAsBillingAddress(CheckOutPageLocators.shippingAddressDropDown);

		// click on continue button
		driver.findElement(CheckOutPageLocators.shippingAddressContinueButton).click();

		// click on Next day air
		driver.findElement(CheckOutPageLocators.nextDayAirRadioButton).click();

		// click on shipping method continue button
		driver.findElement(CheckOutPageLocators.shippingMethodContinueButton).click();

		if (driver.findElement(CheckOutPageLocators.paymentMethodCod).isSelected()) {
			System.out.println("Default option is COD");
		} else {
			driver.findElement(CheckOutPageLocators.paymentMethodCod).click();
		}

		// click on payment method continue button
		driver.findElement(CheckOutPageLocators.paymentMethodContinueButton).click();

		// validate the payment method information
		Assert.assertEquals(eReader.getColData("CodText", 1),
				driver.findElement(CheckOutPageLocators.paymentInformationTExt).getText());

		// click on continue button
		driver.findElement(CheckOutPageLocators.paymentInformationContinueButton).click();

		// click on confirm order
		driver.findElement(CheckOutPageLocators.confirmButton).click();

		// validate the order success message
		Assert.assertEquals(eReader.getColData("OrderSuccessMessage", 1),
				driver.findElement(CheckOutPageLocators.successMessage).getText());

		// click on logout button
		driver.findElement(CheckOutPageLocators.logout).click();

	}

}
