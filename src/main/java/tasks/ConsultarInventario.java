package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static utils.BaseSteps.INVENTORY_ENDPOINT;

public class ConsultarInventario implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(INVENTORY_ENDPOINT)
        );
    }
}
