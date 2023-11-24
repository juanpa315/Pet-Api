Feature: Validate the endopoint get List Users
     in the service.

    @All @Get
    Scenario: As a user, Juan needs to get the list of all users from de users API 
        When He consult the list of the users on the API
        Then He can see that the API returns a status code 200
        And He can see the user list has the correct structure
        And He can see the user with id 1 is not null