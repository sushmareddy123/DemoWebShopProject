package com.objectRepository.DemoWorkShop;

import org.openqa.selenium.By;

public class ShoppingCartPageLocators {

	public static By removeFromCart = By.xpath("//tr[@class='cart-item-row']//input[@name='removefromcart']");

	public static By updateShoppingCartButton = By.xpath("//input[@name='updatecart']");

	public static By emptyShoppingCart = By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]");
	public static By productName = By.xpath("//a[@class='product-name']");

	public static By subtotal = By
			.xpath("//span[text()='Sub-Total:']/parent::td//following-sibling::td//span[@class='product-price']");

	public static By checkoutButton = By.xpath("//button[@name='checkout']");

	public static By termsOfService = By.id("termsofservice");

}
