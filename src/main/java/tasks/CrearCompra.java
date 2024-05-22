package tasks;

import interactions.Post;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.BaseSteps.PURCHASE_ENDPOINT;

public class CrearCompra implements Task {

    private final Object nuevaCompra;

    public CrearCompra(Object nuevaCompra) {
        this.nuevaCompra = nuevaCompra;
    }

    public static CrearCompra conDatos(Object nuevaCompra) {
        return instrumented(CrearCompra.class, nuevaCompra);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(PURCHASE_ENDPOINT).with(
                        requestSpecification -> requestSpecification.contentType(ContentType.JSON).body(nuevaCompra)
                )
        );
    }
}
