package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetListUsers implements Task {

    private final int page;

    public GetListUsers(int page) {
        this.page = page;
    }

    public static Performable fromPage(int page) {
        return instrumented(GetListUsers.class, page);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
            Get.resource("api/users?page=" + page)
            );
        
    }

}
