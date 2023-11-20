Feature: Validate the endopint Update Users.
@All
Scenario: As a User created in the system, Juan needs update his userinfo from the API
    When He consult his data by id and sends his name and new job
    Then He can see his userdata updated on the API