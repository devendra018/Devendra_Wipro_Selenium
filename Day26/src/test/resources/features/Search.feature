Feature: check user is able to search products
Scenario Outline: successful search
Given home page should be open in default browser
When  enter <service1> and click enter
Then results should be displayed
Examples:
|service1|
|Online Banking|
|Account Activity|
|Transfer Funds|
|My Money|