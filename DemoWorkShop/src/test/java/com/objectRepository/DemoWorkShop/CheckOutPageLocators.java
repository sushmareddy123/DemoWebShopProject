package com.objectRepository.DemoWorkShop;

import org.openqa.selenium.By;

public class CheckOutPageLocators {

	public static By billingAddressDropDown = By.name("billing_address_id");

	public static By billingFirstName = By.id("BillingNewAddress_FirstName");
	
	public static By billingLastName = By.id("BillingNewAddress_LastName");
	
	public static By billingemail = By.id("BillingNewAddress_Email");
	
	public static By billingCountry = By.id("BillingNewAddress_CountryId");
	
	public static By billingCity = By.id("BillingNewAddress_City");
	
	public static By billingAddress = By.id("BillingNewAddress_Address1");
	
	public static By billingPostal = By.id("BillingNewAddress_ZipPostalCode");
	
	public static By billingPhone = By.id("BillingNewAddress_PhoneNumber");
	
	public static By continueButton = By.xpath("//div[@id='billing-buttons-container']//input[@value='Continue']");

	public static By shippingAddressDropDown = By.name("shipping_address_id");
	
	public static By shippingAddressContinueButton = By
			.xpath("//div[@id='shipping-buttons-container']/input[@class='button-1 new-address-next-step-button']");

	public static By nextDayAirRadioButton = By.xpath("//input[@id='shippingoption_1']");
	
	public static By shippingMethodContinueButton = By.xpath("//div[@id='shipping-method-buttons-container']/input");
	
	public static By paymentMethodCod = By.xpath("//input[@value='Payments.CashOnDelivery']");
	
	public static By paymentMethodContinueButton = By.xpath("//div[@id='payment-method-buttons-container']/input");
	
	public static By paymentInformationTExt = By.xpath("//p[text()='You will pay by COD']");
	
	public static By paymentInformationContinueButton = By.xpath("//div[@id='payment-info-buttons-container']/input");
	
	public static By confirmButton = By.xpath("//input[@value='Confirm']");
	
	public static By successMessage = By.xpath("//div[@class='section order-completed']//strong");
	
	public static By logout = By.xpath("//a[text()='Log out']");

}
