package runners;

import org.junit.Test;
import org.junit.runner.RunWith;

import models.Datum;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.GetAllUsers;
import questions.ResponseCode;
import tasks.GetListUsers;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SerenityRunner.class)

public class FirstTest {

    private static final String restApiUrl = "https://reqres.in/";

    @Test
    public void getUsers() {

        Actor juan = Actor.named("juan")
            .whoCan(CallAnApi.at(restApiUrl));

        juan.attemptsTo(
                GetListUsers.fromPage(1)
        );

        
    
        juan.should(
            seeThat("The status code", ResponseCode.was(), equalTo(200)));

        
        Datum user = new GetAllUsers().answeredBy(juan)
            .getData().stream().filter(x -> x.getId() == 1).findFirst().orElse(null);


        juan.should(
            seeThat("The user", act-> user, notNullValue()));

        juan.should(
            seeThat("The user email", act -> user.getEmail(), equalTo("george.bluth@reqres.in")));
    
    }

    

}
