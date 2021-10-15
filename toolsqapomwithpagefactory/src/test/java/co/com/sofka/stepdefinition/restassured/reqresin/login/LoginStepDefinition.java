package co.com.sofka.stepdefinition.restassured.reqresin.login;

import co.com.sofka.stepdefinition.setup.services.Reqresin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class LoginStepDefinition extends Reqresin {

    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class);
    private Response response;
    private RequestSpecification request;

    @Given("el usuario está en l apágina de inicio de sesión con el correo de usuario {string} y la contraseña {string}")
    public void elUsuarioEstaEnLApaginaDeInicioDeSesionConElCorreoDeUsuarioYLaContrasena(String email, String password) {
        try{
            generalSetUp();
            request = given()
                    .log()
                    .all(true)
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "    \"email\": \"" + email + "\",\n" +
                            "    \"password\": \"" + password + "\"\n" +
                            "}");
        } catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }

    @When("cuando el usuario hace una petición de inicio")
    public void cuandoElUsuarioHaceUnaPeticionDeInicio() {
        try{
            response = request.when()
                    .post(RESOURCE);
        } catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }

    @Then("el usuario deberá ver un código de respuesta exitoso y un token de respuesta")
    public void elUsuarioDeberaVerUnCodigoDeAccesoAdecuado() {
        try{
            response
                    .then()
                    .log()
                    .all(true)
                    .statusCode(HttpStatus.SC_OK)
                    .body("token", notNullValue());
        } catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }

}
