Feature: to validate 
Scenario: to validate the login with invalid UserName and invalid password
Given User have to launch the facebook application through chromeBrowser
When User have to enter the invalid userName and invalid password
And User have to click the LoginButton
Then User have to verify the invalid credential Page

 