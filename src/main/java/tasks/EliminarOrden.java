package tasks;

import interactions.Post;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static utils.BaseSteps.PURCHASE_ENDPOINT;

public class EliminarOrden implements Task {

    private final int idOren;

    public EliminarOrden(int idOren) {
        this.idOren = idOren;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(PURCHASE_ENDPOINT+idOren).with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );
    }
}
