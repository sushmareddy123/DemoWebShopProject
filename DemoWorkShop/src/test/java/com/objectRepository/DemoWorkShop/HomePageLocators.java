package com.objectRepository.DemoWorkShop;

import org.openqa.selenium.By;

public class HomePageLocators {

	public static By userAccountId = By.xpath("//div[@class='header-links']//descendant::a[@class='account']");

	public static By shoppingCartLink = By.xpath("//span[text()='Shopping cart']/parent::a");

	public static By demoWorkShopLink = By.xpath("//div[@class='header-logo']/a");

	public static By booksLink = By
			.xpath("//strong[text()='Categories']/parent::div/following-sibling::div//a[contains(text(),'Books')]");

	public static By selectBook = By
			.xpath("//div[@class='page-body']//div[@class='product-grid']//div[@class='picture']/a");

	public static By productName = By.xpath("//h1[@itemprop='name']");

	public static By priceDetails = By.xpath("//div[@class='product-price']//span");

	public static By quantityDetails = By.xpath("//input[@class='qty-input']");

	public static By addToCartButton = By.xpath("//input[@class='qty-input']/following-sibling::input");

	public static By productAddedMess = By.xpath("//p[@class='content']");

}
