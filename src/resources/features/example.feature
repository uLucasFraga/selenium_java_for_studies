#language: en

@example
Feature: Learning to use selenium with java 
As a QA
I want to learn how to use selenium 
To be able to automate applications 
 
Scenario: Validate access on concrete.com.br website
	Given Im on the page
	Then I check the home page text as "Nós Movemos O Mundo."
 
Scenario: Validate search on concrete.com.br website
	Given Im on the page
	When I fill in the text and select "Utilizando async/await com Protractor"
	Then I check the search for "Utilizando async/await com Protractor" exists

Scenario Outline: Validate texts in concrete.com.br website
	Given Im on the page
	When I fill in the text field with "<name>"
	Then I checked if the text "<expected>" was successfully validated

  Examples: 
  | name        | expected															|
  | Concrete		| A Concrete no QCon SP 2011 – parte 1		|
  | Lucas Fraga	| Utilizando async/await com Protractor	|