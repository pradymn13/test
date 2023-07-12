Feature: HeroUK Automation Feature 

@Values
Scenario Outline: Select Multiple values dropdown
  
 Given Enter  URL "http://the-internet.herokuapp.com/"
 When Click on Dropdown
 And Select a value "<dropdown>"
 And Use browser back to return
 Then User Now in HomePage
 Examples: 
 |	dropdown	|
 |  1  |
 |  2  |
 
 @checkbox
 Scenario: Select Checkboxes option
 Given Enter  URL "http://the-internet.herokuapp.com/"
 When Click checkbox value
 | Checkboxes | Context Menu |
 
 And Select checkboxes Value
 And Use browser back to return
 Then User Now in HomePage
 
 @fileupload
 Scenario: Uploading file
 Given Enter  URL "http://the-internet.herokuapp.com/"
 When Click on Fileupload
 Then Verify FileUploaded successfully
 
 
 
 
 