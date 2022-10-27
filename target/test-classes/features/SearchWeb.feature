Feature: verify the search page

  Scenario Outline: validating the search results count
    Given the user opens the browser and launches the web application
    Then the user enters the filter values as Make - <Make> Model - <Model> BodyType - <BodyStyle>
    Then the user verifies the count of search results
    @search
    Examples:
      | Make  | Model | BodyStyle |
      | Audi  | A6    | Sedan     |
      | BMW   | 135i  | Coupe     |


  Scenario Outline: validate the results with the input search criteria
    Given the user opens the browser and launches the web application
    Then the user enters the filter values as Make - <Make> Search Text - <SearchText> BodyType - <BodyStyle>
    Then the user navigates to the car details page
    And the user verifies the displayed car details
    Then the user validate the car details <KiloMeters> <NumberPlate> <BodyStyle>
    @search
    Examples:
      | Make | BodyStyle | SearchText | KiloMeters | NumberPlate |
      | BMW  | Sedan     | NKT493     | 115,000km  | NKT493      |

  Scenario Outline: validate the results with the input search criteria
    Given the user opens the browser and launches the web application
    Then the user enters the filter values as Make - <Make> Search Text - <SearchText> BodyType - <BodyStyle>
    Then the user navigates to the car details page
    And the user verifies the displayed car details
    Then the user validate the car details <KiloMeters> <NumberPlate> <Seats>
    @search
    Examples:
      | Make         | BodyStyle | SearchText | KiloMeters | NumberPlate | Seats |
      | Aston Martin | Coupe     | RPDV12     | 31,000km   | RPDV12      | 4     |