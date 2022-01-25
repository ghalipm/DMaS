@A0
Feature:Kam1n0 page.
## Pre-conditions of running following scenarios
  # 1. install jdk11
  # 2. latest Apache Maven is installed
  # 3. Kam1n0 server is installed

  Background:
    Given user is on kam1n0 home page

  Scenario: user access the home page of Kam1n0
    Then user see Kam1n0 header

    #According to Justin Ko's website, order of execution is determined as follows:
    #
    #Alphabetically by feature file directory
    #Alphabetically by feature file name
    #Order of scenarios within the feature file



