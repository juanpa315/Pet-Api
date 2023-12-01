package questions;

import models.UserData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetLastResponse implements Question{

    @Override
    public UserData answeredBy(Actor actor) {

        //Retornar el response con el formato de la clase Users
        return SerenityRest.lastResponse().as(UserData.class);
    }
    
}
