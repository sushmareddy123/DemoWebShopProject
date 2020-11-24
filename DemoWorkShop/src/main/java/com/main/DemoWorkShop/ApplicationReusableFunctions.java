package com.main.DemoWorkShop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.objectRepository.DemoWorkShop.CheckOutPageLocators;
import com.objectRepository.DemoWorkShop.HomePageLocators;
import com.objectRepository.DemoWorkShop.LoginPageLocators;
import com.objectRepository.DemoWorkShop.ShoppingCartPageLocators;

public class ApplicationReusableFunctions extends TestBase {

	public static ExcelReader eReader;

	/**
	 * This method waits for the element to be visible till 20 seconds.
	 * 
	 * @param by:
	 *            Action to be performed on element
	 * @param LocatorName
	 *            : Meaningful name to the element
	 * @throws Throwable
	 * 
	 */
	public static void waitForVisibilityOfElement(By by, String LocatorName) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element " + LocatorName + " not visible");
		}
	}

	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator:
	 *            Action to be performed on element
	 * 
	 * @param index:
	 *            Value wish to select from dropdown list.
	 * 
	 */

	public static void selectByIndex(By locator, int index) {
		try {
			Select s = new Select(driver.findElement(locator));
			s.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * select value from Dropdown by using value
	 * 
	 * @param locator:
	 *            Action to be performed on element
	 * 
	 * @param value:
	 *            Value wish to select from dropdown list.
	 * 
	 */
	public static void selectByValue(By locator, String value) {
		try {
			Select s = new Select(driver.findElement(locator));
			s.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator:
	 *            Action to be performed on element
	 * 
	 * @param value:
	 *            Value wish to select from dropdown list.
	 * 
	 */
	public static void selectByVisibleText(By locator, String value) {
		try {
			Select s = new Select(driver.findElement(locator));
			s.selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to Log-in into application
	 * 
	 * @param username
	 * @param password
	 * @throws Throwable
	 */

	public static void logIn(String userName, String password) throws Throwable {

		boolean flag = driver.findElement(LoginPageLocators.emailfield).isDisplayed();
		if (flag) {

			driver.findElement(LoginPageLocators.emailfield).sendKeys(userName);
			driver.findElement(LoginPageLocators.passwordfield).sendKeys(password);
			driver.findElement(LoginPageLocators.loginSubmitButton).click();
		} else {
			System.out.println("Element not displayed in the page");
		}
	}

	/**
	 * This method will enter the text in billing address section.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param country
	 * @param city
	 * @param address1
	 * @param zip
	 * @param phonenumber
	 * 
	 */
	public static void billingAddressSelect(String firstName, String lastName, String email, String country,
			String city, String address1, String zip, String phonenumber) {

		driver.findElement(CheckOutPageLocators.billingFirstName).clear();
		driver.findElement(CheckOutPageLocators.billingFirstName).sendKeys(firstName);
		driver.findElement(CheckOutPageLocators.billingLastName).clear();
		driver.findElement(CheckOutPageLocators.billingLastName).sendKeys(lastName);
		driver.findElement(CheckOutPageLocators.billingemail).clear();
		driver.findElement(CheckOutPageLocators.billingemail).sendKeys(email);
		selectByVisibleText(CheckOutPageLocators.billingCountry, country);
		driver.findElement(CheckOutPageLocators.billingCity).clear();
		driver.findElement(CheckOutPageLocators.billingCity).sendKeys(city);
		driver.findElement(CheckOutPageLocators.billingAddress).sendKeys(address1);
		driver.findElement(CheckOutPageLocators.billingPostal).sendKeys(zip);
		driver.findElement(CheckOutPageLocators.billingPhone).sendKeys(phonenumber);

	}

	/**
	 * select value same as Billing address
	 * 
	 * @param locator:
	 *            Action to be performed on element
	 * 
	 */
	public void shippingSameAsBillingAddress(By locator) {
		Select sel = new Select(driver.findElement(locator));
		List<WebElement> dropDownOptions = sel.getOptions();
		int modifiedSize = dropDownOptions.size() - 2;
		sel.selectByIndex(modifiedSize);

	}

	/**
	 * This method is used to clear the shopping cart.
	 */
	public static void clearShoppingCart() {

		driver.findElement(HomePageLocators.shoppingCartLink).click();
		try {

			if (driver.findElement(ShoppingCartPageLocators.emptyShoppingCart).isDisplayed()) {
				System.out.println("Shopping Cart is empty no products to clear");
			}
		}

		catch (NoSuchElementException exc) {
			List<WebElement> removefromcartlist = driver.findElements(ShoppingCartPageLocators.removeFromCart);
			for (WebElement removeInputCheckbox : removefromcartlist) {
				removeInputCheckbox.click();
			}
			driver.findElement(ShoppingCartPageLocators.updateShoppingCartButton).click();
			System.out.println("Shopping cart cleared");

		}

	}

}
