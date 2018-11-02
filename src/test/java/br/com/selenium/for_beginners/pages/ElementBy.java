package br.com.selenium.for_beginners.pages;

import org.openqa.selenium.By;

public abstract class ElementBy extends By {

	public static By dataAttribute(String data) {
		return By.cssSelector("[data-test='" + data + "']");
	}
}