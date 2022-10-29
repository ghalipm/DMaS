@A4
Feature: user should be able access Kam1n0 on GitHub.
## Pre-conditions of running following scenarios
  # 1. install jdk11
  # 2. latest Apache Maven is installed
  # 3. Kam1n0 server is installed
  # 4. Manual login into Kam1n0 is successful
  Background:
    Given user is on kam1n0 home page

  Scenario: user landing on GitHub page of Kam1n0
    When user clicks GitHub button
    Then user lands at GitHub page of Kam1n0 Community
    When user clicks releases page link of Kam1n0-Server
    Then user lands at Kam1n0 Community releases page on GitHub
    When user click on Latest version of Kam1n0
    And user click Kam1n0-Server Exec link
    Then user either confirm or cancel download





