@6
Feature: Editing an application
  Background:
    Given : user login into Kam1n0

  Scenario: Editing an existing application
    When : an application is created
    Then user can edit the application by changing the name of the application, providing username and type of access
    Then user click update button and finish editing