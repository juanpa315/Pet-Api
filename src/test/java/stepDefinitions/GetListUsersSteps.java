package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Datum;
import net.serenitybdd.screenplay.Actor;
import questions.GetAllUsers;
import questions.ResponseCode;
import tasks.GetListUsers;
import utils.BaseSteps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.List;

public class GetListUsersSteps {

        private Actor actor;

        @Before
        public void setUp() {
                actor = BaseSteps.createActor();
        }

        @When("He consult the list of the users on the API")
        public void juanConsultTheListOfTheUsersOnTheAPI() {
                actor.attemptsTo(
                                GetListUsers.fromPage(1));

        }

        @Then("He can see that the API returns a status code {int}")
        public void heCanSeeThatTheAPIReturnsAStatusCode(Integer statusCode) {
                actor.should(
                                seeThat("The status code", ResponseCode.was(), equalTo(statusCode)));
        }

        @And("He can see the user list has the correct structure")
        public void heCanSeeTheUserListHasTheCorrectStructure() {

                //get a list with all user on the API
                List<Datum> listUsers = new GetAllUsers().answeredBy(actor).getData();

                for (int i = 0; i < listUsers.size(); i++) {

                        Datum user1 = listUsers.get(i);

                        actor.should(
                                        seeThat("The id", act -> user1.getId(), notNullValue()),
                                        seeThat("The email", act -> user1.getEmail(), notNullValue()),
                                        seeThat("The first_name", act -> user1.getFirstName(), notNullValue()),
                                        seeThat("The last_name", act -> user1.getLastName(), notNullValue()),
                                        seeThat("The avatar", act -> user1.getAvatar(), notNullValue()));

                }

        }

        @And("He can see the user with id {int} is not null")
        public void heCanSeeTheUserWithIdIsNotNull(Integer id) {
                Datum user = new GetAllUsers().answeredBy(actor)
                                .getData().stream().filter(x -> x.getId() == id).findFirst().orElse(null);

                actor.should(
                                seeThat("The user", act -> user, notNullValue()));

                actor.should(
                                seeThat("The user email", act -> user.getEmail(), equalTo("george.bluth@reqres.in")));

        }
}
