Feature: PractceAutomation Login Feature 
@Regressionp
 Scenario Outline: Log-in with valid username and password
 
 Given Enter the URLl "https://practicetestautomation.com/" 
 When Click on Practice
 And Click on Test Login Page
 And Enter valid username "<username>" and password "<password>"  
 And Click on Submit Button
 Then Verify logged in successfully
 
 Examples:
 | username | password |
 | student | Password123 |