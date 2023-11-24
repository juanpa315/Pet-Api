package questions;

import models.Users;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetAllUsers implements Question{

    @Override
    public Users answeredBy(Actor actor) {

        /*String responseBody = SerenityRest.lastResponse().getBody().asString();
        System.out.println("Response Body: " + responseBody);*/

        //Retornar el response con el formato de la clase Users
        return SerenityRest.lastResponse().as(Users.class);
        
    }
    
}
