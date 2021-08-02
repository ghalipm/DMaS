Feature: Accessing modules
  Agile Story: As a user, when I am on the Podium home page,
  I should be able to see the list of the modules:
  Products, Solutions, Enterprise, Pricing, Login

  Background: Access to Podium Home Page
    Given User is on the home page

  Scenario: User verify modules on the podium home page
    Then User should see the podium logo
    And User should see the modules
      | Products   |
      | Solutions  |
      | Enterprise |
      | Resources  |
      | Pricing    |
      | Login      |
      | Watch Demo |

  Scenario: User verify submodules of the Products module
    When User hover over the Products module
    Then User should see the submodules
      | Reviews                                |
      | Feedback                               |
      | Payments                               |
      | Teamchat                               |
      | Videochat                              |
      | Webchat                                |
      | Inbox                                  |
      | Campaigns                              |
      | Interested in trying our free version? |