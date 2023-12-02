Feature: Validate endopoint create User.
@All @Post
Scenario: As a client, Juan needs to able to create his user in the API

When He sends the username and job 
Then The API create his user with the data send by Juan