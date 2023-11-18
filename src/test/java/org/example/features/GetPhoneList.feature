Feature: Phone Data Management
  @GetPhones
  Scenario: Get all the phones data available in the server
    Given User have all the prerequisites
    When User call "objects" using "GET" http request
    Then status code should be 200
    And phone names should be displayed
  @AddPhones
  Scenario Outline: Add new phone data to the server
    Given User add "<phoneName>" "<year>" "<price>" "<cpuModel>" "<hardDiskSize>"
    When User call "objects" using "POST" http request
    Then status code should be 200
    And I should extract "id" from response
    Examples:
    |phoneName|year|price|cpuModel|hardDiskSize|
    |Nokia|2020|16999|Qualcom |60 GB       |
  @GetPhoneUsingId
  Scenario: Get the phones data using id
    Given User have all the prerequisites with query
    When User call "objects" using "GET" http request
    Then status code should be 200
    And phone names should be displayed
