package stepDefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserData;
import net.serenitybdd.screenplay.Actor;
import questions.ResponseCode;
import tasks.UpdateUser;
import utils.BaseSteps;

public class UpdateUserSteps {

    private Actor actor;

    @Before
    public void setUp() {
        actor = BaseSteps.createActor();
    }

    @When("He consult his data by id and sends his name and new job")
    public void heConsultHisDataByIdAndSendsHisNameAndNewJob() {
        int idUser = 672;

        UserData newUserData = new UserData();

        newUserData.setName("morpheusJP3");
        newUserData.setJob("leader3");

        actor.attemptsTo(
                UpdateUser.withInfo(idUser, newUserData));
    }

    @Then("He can see his userdata updated on the API")
    public void heCanSeeHisUserdataUpdatedOnTheAPI() {
        actor.should(
                seeThat("The status code", ResponseCode.was(), equalTo(200)));

    }

}
