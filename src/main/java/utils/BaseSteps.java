package utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

//Class for create an actor and define the API base URL
public class BaseSteps {

    public static final String REST_API_URL = "https://reqres.in/";

    public static Actor createActor() {
        return Actor.named("juan").whoCan(CallAnApi.at(REST_API_URL));
    }

}
