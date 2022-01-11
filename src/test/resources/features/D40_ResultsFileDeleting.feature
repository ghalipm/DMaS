@7
Feature: Deleting a ResultFile
  Background:
    Given : user login into Kam1n0

  Scenario: Deleting an existing result file
    When : a result file is available
    Then user can delete the result file by clicking the DELETE button and
    Then click confirm button of the warning alert
    Then user confirm that the result file is no longer in the list
