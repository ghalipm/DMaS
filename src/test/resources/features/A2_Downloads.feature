@A2
Feature: user should be able to download Kam1n0 Server
## Pre-conditions of running following scenarios
  # 1. install jdk11
  # 2. latest Apache Maven is installed
  # 3. Kam1n0 server is installed
  # 4. Manual login into Kam1n0 is successful
  Background:
    Given user is on kam1n0 home page

  Scenario: user downloading Kam1n0 Server
    When user click on downloads tab
    And user click download Kam1n0-Server button
    Then user lands at Kam1n0 Community releases page on GitHub
    When user click on Latest version of Kam1n0
    And user click Kam1n0-Server Exec link
    Then user either confirm or cancel download




