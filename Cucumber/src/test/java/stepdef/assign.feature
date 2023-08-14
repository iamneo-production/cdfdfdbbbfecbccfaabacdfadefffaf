Feature: Search Google Images
  As a user
  I want to search for images on Google
  So that I can find relevant visual content

  Scenario: Adding a new search for images
    Given I am on the Google Images website
    When I enter "beautiful landscapes" in the search bar
    And I click on the search button
    Then I should see a page with search results for "beautiful landscapes"
    And the images on the page should be related to beautiful landscapes

Feature: Perform Google Searches using URL query parameters
  As a user
  I want to perform Google searches using URL query parameters
  So that I can quickly access search results

  Scenario: Performing a search with a single term
    Given I am on the Google search page
    When I enter the URL "https://www.google.com/search?q=cats"
    Then I should see search results related to "cats"

  Scenario: Performing a search with multiple terms
    Given I am on the Google search page
    When I enter the URL "https://www.google.com/search?q=best+movies+of+all+time"
    Then I should see search results related to "best movies of all time"
Feature: Wikipedia Article Search
  As a user
  I want to search for articles on Wikipedia
  So that I can find relevant information

  Scenario: Searching for articles on Wikipedia
    Given I am on the Wikipedia home page
    When I select the language "English"
    And I search for the term "Artificial Intelligence"
    Then I should see search results related to "Artificial Intelligence"
Feature: Wikipedia Article Links
  As a user
  I want to verify that embedded links navigate to the correct articles
  So that I can ensure accurate navigation

  Scenario: Navigating to a linked article
    Given I am on the Wikipedia article page for "Artificial Intelligence"
    When I click on the embedded link "Machine Learning"
    Then I should be redirected to the Wikipedia article page for "Machine Learning"
Feature: Wikipedia Page History
  As a user
  I want to view the history of Wikipedia articles
  So that I can track changes and revisions

  Scenario: Viewing the history of an article
    Given I am on the Wikipedia article page for "Artificial Intelligence"
    When I click on the "View history" link
    Then I should be on the history page for the article "Artificial Intelligence"
