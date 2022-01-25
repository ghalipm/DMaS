@2
Feature:A user should be able sign up to Kam1n0
 # sign up if not done yet
  Background:
    Given user is on kam1n0 home page
  Scenario: user sign up to Kam1n0
    When user clicks login tab
    Then user lands at login page
    Then user click sign up link
    Then user complete signing up
