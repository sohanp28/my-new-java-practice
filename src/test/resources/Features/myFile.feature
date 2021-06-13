Feature: Filling contact form
Scenario Outline: User fills the contact form
Given User is on home page of contact form
Then User fills the details "<name>" and "<email>"

Examples:
|name|email|
|Sohan|sohan@email.com|