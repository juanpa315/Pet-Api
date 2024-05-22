package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.BaseSteps.PURCHASE_ENDPOINT;

public class ConsultarCompra implements Task {

    private final int idCompra;

    public ConsultarCompra(int idCompra){
        this.idCompra = idCompra;
    }

    public static ConsultarCompra con(int idCompra){
        return instrumented (ConsultarCompra.class, idCompra);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PURCHASE_ENDPOINT +idCompra)
        );
        actor.remember("idCompra", idCompra);

    }
}
