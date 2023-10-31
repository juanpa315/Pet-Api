package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import interactions.Post;

public class RegisterUser implements Task{

    private final Object newUser;

    public RegisterUser(Object newUser){
        this.newUser = newUser;
    }

    public static RegisterUser withInfo(Object newUser){
        return instrumented(RegisterUser.class, newUser);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Post.to("api/users/672").with(
                requestSpecification -> requestSpecification.contentType(ContentType.JSON).body(newUser)

            )
        );
    }
    
}
