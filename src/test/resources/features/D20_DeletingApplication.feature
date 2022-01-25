@7
Feature: Deleting an application
  Background:
    Given : user login into Kam1n0

  Scenario: Deleting an existing application
    When : an application is created
    Then user can delete the application by providing application name and password
    Then user click confirm or close button and to finish or abort deleting
