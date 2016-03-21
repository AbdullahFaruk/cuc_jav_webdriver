@rest
Feature: Demonstrate rest-assured

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
    Then the result is "success"
    