# Created by ZipZap at 1/9/2022
Feature: Indexing, Classification for ExecutableClassification
  # Indexing has to be done first before doing Classification
  # The right order: Indexing, Classification.
  # Indexing is different for all 4 types.
  Background:
    Given : user login into Kam1n0
  Scenario: Indexing, Classification for ExecutableClassification applications
    When : an application is created
    And user click a permanent link of Type 4 application

    # To force Kam1n0 work properly for INDEXING, Classification for ExecutableClassification
    # The proper working order: INDEXING and then Classification.

  # Indexing
    Then user see Indexing Tab in the Tasks
    And user click Indexing Tab
    And user drag two files from one of the class types into dropFile area
    # WebElements for dropFile area are different for Indexing and BinaryComposition
    And user click Run button
    And user see Indexing Completed message for ExecutableClassification
    And user click close button

    # Classification
    # Classification can be done only with applications of Type 4;

    When user click Classification in the Tasks Tab
    And user drag three files from one of the class types into dropFile area
    And user click Analyze button
    And user see Classification Completed message
    And user click close button for Classification