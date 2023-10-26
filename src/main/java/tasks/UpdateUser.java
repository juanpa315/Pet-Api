package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class UpdateUser implements Task{

    private final Object newUserData;
    private final Object idUser;

    public UpdateUser(int idUser, Object newUserData){
        this.newUserData = newUserData;
        this.idUser = idUser;
    }

    public static UpdateUser withInfo(int idUser, Object newUserData){
        return instrumented(UpdateUser.class, idUser, newUserData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Put.to("api/users/"+idUser).with(
                requestSpecification -> requestSpecification.contentType(ContentType.JSON).body(newUserData)

            )
        );
    }
    
}
