Feature: Validate the endopint Update Users.
@All @Put
Scenario: As a User created in the system, Juan needs update his userinfo from the API
    When He consult his data by id 672 and sends his name "morpheusJP9" and new job "leader9"
    Then He can see his userdata updated on the API