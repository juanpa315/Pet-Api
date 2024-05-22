package questions;

import models.Compra;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ObtenerCompra implements Question<Compra> {


    @Override
    public Compra answeredBy(Actor actor) {

       return SerenityRest.lastResponse().as(Compra.class);
    }
}
