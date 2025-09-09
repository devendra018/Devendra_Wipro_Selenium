Feature: validate login page
Scenario: Check for valid and invalid credentials
Given login page should be open in default browser
When click on username button and enter <username1> and <password1>
And click on signin button check <status>
Then login successfully and open home page
Examples:
|username1|password1|status|
|67975|password|fail|
|username|asdf|fail|
|smdnfkr3|ddfma3|fail|
|username|password|success|