Feature: Yandex search

  Scenario Outline: Search for Test Automation
    Given I am on yandex.by page
    When I type <search> into search input
    And Press Enter
    Then there are <count> search results present
    And first search result contains <search> in title

    Examples:
      | search                       | count |
      | Xiaomi Redmi Note            | 36    |
      | Велосипед GreenLand Scorpion | 8     |
      | планшет Samsung Galaxy Tab A | 24    |

