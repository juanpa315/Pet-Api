package runners;

import org.junit.Test;
import org.junit.runner.RunWith;

import models.Datum;
import models.UserData;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.GetAllUsers;
import questions.ResponseCode;
import tasks.GetListUsers;
import tasks.RegisterUser;
import tasks.UpdateUser;

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

    @Test
    public void createUser(){

        Actor juan = Actor.named("juan")
            .whoCan(CallAnApi.at(restApiUrl));

        UserData newUser = new UserData();

        newUser.setName("morpheusJP2");
        newUser.setJob("leader");

        juan.attemptsTo(
                RegisterUser.withInfo(newUser)
        );

        juan.should(
            seeThat("The status code", ResponseCode.was(), equalTo(201)));

    }


    @Test
    public void updateClient(){

        Actor juan = Actor.named("juan")
            .whoCan(CallAnApi.at(restApiUrl));

        int idUser = 672;

        UserData newUserData = new UserData();

        newUserData.setName("morpheusJP3");
        newUserData.setJob("leader3");

        juan.attemptsTo(
                UpdateUser.withInfo(idUser, newUserData)
        );

        juan.should(
            seeThat("The status code", ResponseCode.was(), equalTo(200)));

    }

    

}
