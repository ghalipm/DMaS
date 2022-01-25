@b1
Feature: Creating applications
  Background:
    Given : user login into Kam1n0

  Scenario: Creating application with ams2vec-clone type(1)
    When : user click CREATE AN APPLICATION module
    And user choose ams2vec-clone application type, provide name, description and instruction set
    And click the create button
    Then user lands at application list page and see the options to edit or delete existing applications

  Scenario: Creating application with ams-clone type(2)
    When : user click CREATE AN APPLICATION module
    And user choose ams-clone application type, provide name, description and instruction set
    And click the create button
    Then user lands at application list page and see the options to edit or delete existing applications

  Scenario: Creating application with sym1n0-clone type(3)
    When : user click CREATE AN APPLICATION module
    And user choose sym1n0-clone application type, provide name and description
    And click the create button
    Then user lands at application list page and see the options to edit or delete existing applications

  Scenario: Creating application with ExecutableClassification type(4)
    When : user click CREATE AN APPLICATION module
    And user choose ExecutableClassification application type, provide name and description and instruction set
    And choose folder names of class list files
    And click the create button
    Then user lands at application list page and see the options to edit or delete existing applications

  Scenario: Creating application with random type
    When : user click CREATE AN APPLICATION module
    And user choose Application Type, provide application name and description and choose instruction set
    And click the create button
    Then user lands at application list page and see the options to edit or delete existing applications
