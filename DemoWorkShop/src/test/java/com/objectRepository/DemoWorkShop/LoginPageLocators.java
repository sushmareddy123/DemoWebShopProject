package com.objectRepository.DemoWorkShop;

import org.openqa.selenium.By;

public class LoginPageLocators {

	public static By loginButton = By.xpath("//a[text()='Log in']");

	public static By welcomeMessage = By.xpath("//div[@class='page-title']/h1");

	public static By emailfield = By.id("Email");

	public static By passwordfield = By.id("Password");

	public static By loginSubmitButton = By.xpath("//input[@value='Log in']");
}
