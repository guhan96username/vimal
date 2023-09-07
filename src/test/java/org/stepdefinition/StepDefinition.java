package org.stepdefinition;


import org.base.Base;
import org.pojo.Pojo1;
import org.pojo.Pojo2;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class StepDefinition extends Base {
	Pojo1 p;
	Pojo2 p2;
	@Given("User have to launch the facebook application through chromeBrowser")
	public void user_have_to_launch_the_facebook_application_through_chromeBrowser() {
chromeBrowser();
launchTheUrl("https://www.facebook.com/");
	}

	@When("User have to enter the invalid userName and invalid password")
	public void user_have_to_enter_the_invalid_userName_and_invalid_password() {
Pojo1 p=new Pojo1();
sendTheKeys(p.getUser(), "gree34523@gmail.com");
sendTheKeys(p.getPass(), "1243567");
	}

	@When("User have to click the LoginButton")
	public void user_have_to_click_the_LoginButton() {
Pojo1 p=new Pojo1();
clickTheElement(p.getLogin());		
	}

	@Then("User have to verify the invalid credential Page")
	public void user_have_to_verify_the_invalid_credential_Page() {
	 
	 if (getTheCurrentUrl().contains("privacy_mutation_token")) {
		 System.out.println("invalid page");
		
	} else {
		 System.out.println("valid page");  }
	 }

	@When("User have to click the forgotton password")
	public void user_have_to_click_the_forgotton_password() {
     p2=new Pojo2();
  clickTheElement(p2.getForg());
	}

	@When("User have to enter valid gmail add or ph no")
	public void user_have_to_enter_valid_gmail_add_or_ph_no() {
	  	p2=new Pojo2();
sendTheKeys(p2.getEmail(), "9942811736");
clickTheElement(p2.getSearch());

	}

	@Then("User have to verify the valid credential page")
	public void user_have_to_verify_the_valid_credential_page() {
		

	}


	
	
	
	
	

}
