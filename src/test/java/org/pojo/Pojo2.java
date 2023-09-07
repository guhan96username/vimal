package org.pojo;

import org.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo2 extends Base {
	
	public Pojo2() {
PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=("//a[text()='Forgotten password?']"))
	private WebElement forg;
	
	@FindBy(xpath=("//input[@placeholder='Email address or mobile number']"))
	private WebElement email ;
	
	@FindBy(xpath=("//button[@value='1']"))
	private WebElement search;

	public WebElement getForg() {
		return forg;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSearch() {
		return search;
	}
	
	
	

}
