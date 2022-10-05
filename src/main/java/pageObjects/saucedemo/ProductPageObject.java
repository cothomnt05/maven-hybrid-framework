package pageObjects.saucedemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucedemo.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemSortInDropdown(String selectItem) {
		waitForElementVisible(driver, ProductPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.SORT_DROPDOWN, selectItem);
	}

	public boolean isListItemSortedByAscName() {
		ArrayList<String> arrayList = new ArrayList<>();
		List<WebElement> elementList = getListWebElement(driver, ProductPageUI.LIST_ITEM_NAME);

		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("============== Day tren UI ============");
		for (String item : arrayList) {
			System.out.print(item + " ");
		}

		ArrayList<String> sortedList = new ArrayList<>();

		for (String item : arrayList) {
			sortedList.add(item);
		}
		Collections.sort(sortedList);

		return sortedList.equals(arrayList);
	}

	public boolean isListItemSortedByDescName() {
		ArrayList<String> arrayList = new ArrayList<>();
		List<WebElement> elementList = getListWebElement(driver, ProductPageUI.LIST_ITEM_NAME);

		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}

		System.out.println("============== Day tren UI ============");
		for (String item : arrayList) {
			System.out.print(item + " ");
		}

		ArrayList<String> sortedList = new ArrayList<>();

		for (String item : arrayList) {
			sortedList.add(item);
		}
		Collections.sort(sortedList);
		Collections.reverse(sortedList);

		return sortedList.equals(arrayList);
	}

	public boolean isListItemSortedByAscPrice() {
		ArrayList<Float> arrayList = new ArrayList<>();
		List<WebElement> elementList = getListWebElement(driver, ProductPageUI.LIST_ITEM_PRICE);

		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "")));
		}

		ArrayList<Float> sortedList = new ArrayList<>();

		for (Float item : arrayList) {
			sortedList.add(item);
		}
		Collections.sort(sortedList);

		return sortedList.equals(arrayList);
	}

	public boolean isListItemSortedByDescPrice() {
		ArrayList<Float> arrayList = new ArrayList<>();
		List<WebElement> elementList = getListWebElement(driver, ProductPageUI.LIST_ITEM_PRICE);

		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "")));
		}

		ArrayList<Float> sortedList = new ArrayList<>();

		for (Float item : arrayList) {
			sortedList.add(item);
		}
		Collections.sort(sortedList);
		Collections.reverse(sortedList);

		return sortedList.equals(arrayList);
	}
}
