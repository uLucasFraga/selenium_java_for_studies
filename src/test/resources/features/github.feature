#language: en

@example
Feature: Access github
  As a QA
  I want to learn how to use selenium
  To be able to automate applications like the github website

  Scenario: Validate access on github website
    Given he accesses the page
    Then he checks the text on the home page: "github"