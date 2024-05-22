package questions;

import models.Inventario;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ObtenerInventario implements Question {
    @Override
    public Inventario answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Inventario.class);
    }
}
