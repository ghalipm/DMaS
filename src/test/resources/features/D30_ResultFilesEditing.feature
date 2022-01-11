@6
Feature: Result File Editing
  Background:
    Given : user login into Kam1n0

  Scenario: Editing of an existing Result File
    When : a result file is available
    Then user can edit a result file by changing the name of the file
    Then user see the name of the file is changed