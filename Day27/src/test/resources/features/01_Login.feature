Feature: validate login page
Scenario Outline: Check for valid and invalid credentials
Given login page should be open in default browser
When click on username button and enter <username1> and <password1> and click signin button and check <status>
Then login successfully and open home page
Examples:
|username1|password1|status|
|muktha|Devendra@0018|fail|
|devendra|676904|fail|
|dvd34|455354|fail|
|devendrachowdhary805@gmail.com|Devendra@0018|success|
