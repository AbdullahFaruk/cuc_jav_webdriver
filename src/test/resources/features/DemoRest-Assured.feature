@rest
Feature: Demonstrate rest-assured

@api
Scenario: Validate a JSON array
  Given I set the JSON validation string to:
    """
    {"employees":[
        {"firstName":"John", "lastName":"Doe"},
        {"firstName":"Anna", "lastName":"Smith"},
        {"firstName":"Peter","lastName":"Jones"} 
    ]}
    """
    When I validate the string by invoking end point:
    """
    http://validate.jsontest.com/
    """
    Then the HTTP status code is "200", object is "object", empty is "false" and validate is "true"
    
@api
@weather
Scenario: Get local weather
  Given I create a request for URL "https://weather.com"
  When I send that request
  Then the response status is "200"