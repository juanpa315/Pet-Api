package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Compra;
import models.Inventario;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import questions.ObtenerCompra;
import questions.ObtenerInventario;
import questions.ResponseCode;
import tasks.ConsultarCompra;
import tasks.ConsultarInventario;
import tasks.CrearCompra;
import tasks.EliminarOrden;
import utils.BaseSteps;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.ArgumentMatchers.isNotNull;
import static utils.idRandom.generarIdCompra;

public class OrdenCompraSteps {

    private Actor actor;

    @Before
    public void setUp() {
        actor = BaseSteps.createActor();
    }

    @When("El usuario consulta la orden {int} en la API")
    public void elUsuarioConsultaLaOrdenEnLaAPI(int idCompra) {
        actor.attemptsTo(
                ConsultarCompra.con(idCompra)
        );
    }

    @Then("La API responde un estatus code {int}")
    public void laAPIRespondeUnEstatusCode(int codigoEstatus) {

        actor.should(
                seeThat("The status code", ResponseCode.was(), equalTo(codigoEstatus)));
    }

    @And("El id de la compra es el mismo consultado por el usuario")
    public void elIdDeLaCompraEsElMismoConsultadoPorElUsuario() {

        int idCompraConsultada = actor.recall("idCompra");
        int idCompra = new ObtenerCompra().answeredBy(actor).getId();

        actor.should(
                seeThat("El id de la compra", act -> idCompra, equalTo(idCompraConsultada))
        );


    }

    @Given("el usuario crea una orden de compra")
    public void elUsuarioCreaUnaOrdenDeCompra(List<Map<String, String>> datosCompra) {

        int idCompraRandom = generarIdCompra();
        Compra nuevaCompra = new Compra();
        nuevaCompra.setId(idCompraRandom);
        nuevaCompra.setPetId(Integer.parseInt(datosCompra.get(0).get("petId")));
        nuevaCompra.setQuantity(Integer.parseInt(datosCompra.get(0).get("quantity")));
        nuevaCompra.setShipDate(datosCompra.get(0).get("shipDate"));
        nuevaCompra.setStatus(datosCompra.get(0).get("status"));
        nuevaCompra.setComplete(datosCompra.get(0).get("complete"));

        System.out.println(nuevaCompra);

        actor.attemptsTo(
                CrearCompra.conDatos(nuevaCompra)
        );

        actor.remember("idCompraRandom", idCompraRandom);
        actor.remember("nuevaCompra", nuevaCompra);
    }

    @When("el usuario consulta la orden creada anteriormente")
    public void elUsuarioConsultaLaOrdenCreadaAnteriormente() {
        int idCompraRandom = actor.recall("idCompraRandom");
        actor.attemptsTo(
                ConsultarCompra.con(idCompraRandom)
        );

    }

    @Then("el usuario puede ver la orden correctamente")
    public void elUsuarioPuedeVerLaOrdenCorrectamente() {
        Compra compraCreada = actor.recall("nuevaCompra");
        Compra nuevaCompra = new ObtenerCompra().answeredBy(actor);

        actor.should(
                seeThat("The status code", ResponseCode.was(), equalTo(200)),
                seeThat("El id de la compra", act -> nuevaCompra.getId(), equalTo(compraCreada.getId())),
                seeThat("El id de la mascota", act -> nuevaCompra.getPetId(), equalTo(compraCreada.getPetId())),
                seeThat("Compra completada", act -> nuevaCompra.getComplete(), equalTo(compraCreada.getComplete())),
                seeThat("La cantidad", act -> nuevaCompra.getQuantity(), equalTo(compraCreada.getQuantity())),
                seeThat("El estado", act -> nuevaCompra.getStatus(), equalTo(compraCreada.getStatus())),
                seeThat("La fecha", act -> nuevaCompra.getShipDate(), equalTo(compraCreada.getShipDate()))

        );
    }

    @When("el usuario consulta las ventas realizadas")
    public void elUsuarioConsultaLasVentasRealizadas() {
        actor.attemptsTo(
                new ConsultarInventario()
        );
    }

    @Then("el sistema le muestra todos los productos vendidos")
    public void elSistemaLeMuestraTodosLosProductosVendidos() {

        Inventario inventario = new ObtenerInventario().answeredBy(actor);

        actor.should(
                seeThat("el status code", ResponseCode.was(), equalTo(200)),
                seeThat("sold", act->inventario.getSold(), notNullValue()),
                seeThat("Funny Dog", act->inventario.getFunnyDog(), notNullValue()),
                seeThat("xyz", act->inventario.getXyz(), notNullValue())

        );
    }

    @When("el usuario elimina la orden")
    public void elUsuarioEliminaLaOrden() {
        int idOrden = actor.recall("idCompraRandom");
        actor.attemptsTo(
                new EliminarOrden(idOrden)
        );
        actor.should(
                seeThat("el estatus code", ResponseCode.was(), equalTo(200))
        );
    }

    @Then("esta no puede ser consultada")
    public void estaNoPuedeSerConsultada() {
        int idOrdenEliminada = actor.recall("idCompraRandom");
        actor.attemptsTo(ConsultarCompra.con(idOrdenEliminada));
        actor.should(seeThat(ResponseCode.was(), equalTo(404)));
    }


}

