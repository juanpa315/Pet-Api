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

    @When("He consult his data by id {int} and sends his name {string} and new job {string}")
public void heConsultHisDataByIdAndSendsHisNameAndNewJob(Integer idUser, String userName, String newJob) {

        UserData newUserData = new UserData();

        newUserData.setName(userName);
        newUserData.setJob(newJob);

        actor.attemptsTo(
                UpdateUser.withInfo(idUser, newUserData));
    }

    @Then("He can see his userdata updated on the API")
    public void heCanSeeHisUserdataUpdatedOnTheAPI() {

        UserData rememberedUserData = actor.recall("newUserData");
        
        System.out.println("the name is: "+ rememberedUserData.getName());
        System.out.println("The job is: "+rememberedUserData.getJob());

        actor.should(
                seeThat("The status code", ResponseCode.was(), equalTo(200)));

    }

}
