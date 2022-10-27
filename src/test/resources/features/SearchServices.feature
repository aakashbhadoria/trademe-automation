Feature: verify the charity search result

  Scenario Outline: validating the charity search result
    Given the user launches the charity API end point and gets the response
    Then the user verifies the response list contains the charity name in the list <charityName>

    Examples:
      | charityName     |
      | St John         |
      | invalid Charity |

  Scenario Outline: Adding a new listing by user
    Given the user launches the add listing API end point and gets the response
    Then the user verifies the new listing has been created successfully <statusCode>
    Examples:
      | statusCode |
      | 201        |
