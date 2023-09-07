package org.pojo;

import org.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Pojo1 extends Base {

	public Pojo1() {
PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	private WebElement user;
	
	
	@FindBy(name="pass")
	private WebElement pass;
	
	@FindBy(name="login")
	private WebElement login;

	public WebElement getUser() {
		return user;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLogin() {
		return login;
	}

	

	
	
	
	
	
	
	
	
	
}
