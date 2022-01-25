@A3
Feature:user login to Kam1n0 application page
 # sign up if not done yet
  Background:
    Given user is on kam1n0 home page

  Scenario: user login to Kam1n0
    When user clicks login tab
    Then user lands at login page
    # login directly
    Then with username and password user login to Kam1n0.

    # mark the Examples lines and ctr+alt+l makes lines aligned.









