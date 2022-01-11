# Created by Alip Mohammed at 1/6/2022
# Filename: B30_Sym1n0_CloneApplications.feature

Feature: Indexing, FunctionSearch, BinaryComposition for sym1n0-clone
  # Indexing has to be done first before doing FunctionSearch or BinaryComposition
  # The right order: Indexing, FunctionSearch, BinaryComposition.
  # Indexing is different for all 4 types.
  Background:
    Given : user login into Kam1n0
  Scenario: Indexing, FunctionSearch, BinaryComposition for asm-clone applications
    When : an application is created
    And user click a permanent link of Type 3 application

    # To force Kam1n0 work properly for any of FUNCTION-SEARCH, BINARY-COMPOSITION, INDEXING, DELETE-TEMPORARY-FILES
        # make sure to refresh the page and
        # make sure to delete files in "Temporary files!" folder under DeleteTempFiles Tab
        # Then working order: INDEXING, BINARY-COMPOSITION, FUNCTION-SEARCH.
    # For INDEXING and BINARY-COMPOSITION, dropFile fields are different: WebElements are different

    # Deleting Temp Files and Indexing for sym1n0-clone/Type3 app
    Then user click delete temporary files Tab
    Then user click delete button if there is any files
    # Indexing
    Then user see Indexing Tab in the Tasks
    And user click Indexing Tab
    And user drag two files from one of the class types into dropFile area
    # WebElements for dropFile area are different for Indexing and BinaryComposition
    And user click Index button
    And user see Indexing Completed message
    And user click close button

    # FunctionSearch
    # Function search can be done with all types of applications such as Type 1,2,3;
    # but not for ExecutableClassification - Type 4
    When user click Function Search in the Tasks Tab
    And user click the Example field and select available binary file
    And select some options and click search button
    And user see Clone Graph
    And user see different views depending on the type of application
   # BinaryComposition
   # Binary Composition is only for Applications of Type 1,2,3
   # Indexing has to be done first, before doing FunctionSearch or BinaryComposition
   # The right order: Indexing, FunctionSearch, BinaryComposition according to user manual:
   # https://github.com/McGill-DMaS/Kam1n0/blob/master2.x/documentation/server/server.md#executable-classification
    When user click BinaryComposition Tab
    And user drag three files from one of the class types into dropFile area
    And user click Analyze button
    And user see Composition analysis Completed message
    And user click close button for Binary Composition
