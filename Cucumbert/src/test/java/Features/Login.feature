Feature: MyAccount-Login Feature 

@Sanity
Scenario: Log-in with valid username and password
 Given Open the browser 
 When Enter the URL "http://practice.automationtesting.in/"
 And Click on My Account Menu 
 And Enter registered username and password 
 And Click on login button 
 Then User must successfully login to the web page
 
 

#simple login with Datadriven testing using Scenario outline and Examples keyword
@Regression
 Scenario Outline: Log-in with sets of username and password 
 Given Open the browser 
 When Enter the URL "http://practice.automationtesting.in/" 
 And Click on My Account Menu 
 And Enter registered username "<username>" and password "<password>" 
 And Click on login button 
 Then Verify login 

Examples: 
|	username	|	password	|
|	pavanoltraining	|	Test@selenium	|
|	pavanoltraining	|	Test@selenium123	|
|	pavanol	|	Test@123	|

 #Simple login with Data table with single parameters

@Datatable
 Scenario: Log-in with valid username and password
 Given Open the browser 
 When Enter the URL "http://practice.automationtesting.in/" 
 And Click on My Account Menu 
 And Enter registered username and passwords
 | pavanoltraining | Test@selenium123 |
 And Click on login button 
 Then User must successfully login to the web page
 
 # Simple login with Data table with Multiple parameters-Header
@Header
Scenario: Log-in with valid username and password
Given Open the browser 
When Enter the URL "http://practice.automationtesting.in/" 
And Click on My Account Menu 
And Enter registered username and passwordd
		| username | password |
		| pavanoltraining | Test@selenium123 |
		
#| pavanoltraining | Test@selenium123 | -- If this particular step requires multiple input--- only this method executes with multiple sets of data
And Click on login button 
Then User must successfully login to the web page
 
 
 
 
 
 
 
 
 