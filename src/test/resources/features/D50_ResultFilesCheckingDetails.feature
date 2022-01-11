@6
Feature: Checking Details of a Result File
  Background:
    Given : user login into Kam1n0

  Scenario: Checking Details of a Result File
    When : a result file is available
    Then user click a result file link
    And user click details and click one of the functions in the list
    And user see the effective address