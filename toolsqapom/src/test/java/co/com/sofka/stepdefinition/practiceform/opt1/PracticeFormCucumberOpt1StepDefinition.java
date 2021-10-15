package co.com.sofka.stepdefinition.practiceform.opt1;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.practiceform.PracticeForm;
import co.com.sofka.stepdefinition.setup.WebUI;
import co.com.sofka.util.Gender;
import co.com.sofka.util.Hobbies;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class PracticeFormCucumberOpt1StepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(PracticeFormCucumberOpt1StepDefinition.class);
    private PracticeFormModel practiceFormModel;
    private PracticeForm practiceForm;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    //Background:
    @Given("que el empleado administrativo se encuentra en la página web de los ingresos de estudiantes")
    public void queElEmpleadoAdministrativoSeEncuentraEnLaPaginaWebDeLosIngresosDeEstudiantes() {
        try{
            generalSetUp();
            dataConfiguration();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    //Ingresar campos obligatorios:
    @When("el empleado administrativo ingresa los campos obligatorios y confirma la acción")
    public void elEmpleadoAdministrativoIngresaLosCamposObligatoriosYConfirmaLaAccion() {
        try {
            practiceForm = new PracticeForm(driver, practiceFormModel);
            practiceForm.fillStudentForm();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema deberá mostrar por pantalla el registro del estudiante ingresado.")
    public void elSistemaDeberaMostrarPorPantallaElRegistroDelEstudianteIngresado() {
        try {
            Assertions.assertEquals(
                    expected(),
                    practiceForm.isRegistrationDone(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    //Ingresar todos los campos:
    @When("el empleado administrativo ingresa valores en todos los campos del formulario y confirma la acción")
    public void elEmpleadoAdministrativoIngresaValoresEnTodosLosCamposDelFormulario() {
        try {
            practiceForm = new PracticeForm(driver, practiceFormModel, TEN_SECONDS.getValue());
            practiceForm.fillStudentFormUsingAllFields();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema deberá mostrar por pantalla el registro del estudiante ingresado con todos los campos.")
    public void elSistemaDeberáMostrarPorPantallaElRegistroDelEstudianteIngresadoConTodosLosCampos() {
        try {
            Assertions.assertEquals(
                    expected(),
                    practiceForm.isRegistrationDone(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    //Funciones comunes:
    private void dataConfiguration(){
        practiceFormModel = new PracticeFormModel();
        practiceFormModel.setName("Iván");
        practiceFormModel.setLastName("Arroyave");
        practiceFormModel.setEmail("a@gmail.com");
        practiceFormModel.setGender(Gender.MALE);
        practiceFormModel.setMobile("3104567895");
        practiceFormModel.setDay("30");
        practiceFormModel.setMonth("September");
        practiceFormModel.setYear("1990");
        practiceFormModel.setSubjects(new ArrayList<String>(Arrays.asList("Math", "English", "Biology")));
        practiceFormModel.setHobbies(Hobbies.MUSIC);
        practiceFormModel.setPicture("src/test/resources/images/practiceform/happy.jpg");
        practiceFormModel.setCurrentAddress("Calle 123");
        practiceFormModel.setState("Haryana");
        practiceFormModel.setCity("Karnal");
    }

    private List<String> expected(){
        List<String> submitedFormResult = new ArrayList<String>();
        submitedFormResult.add(practiceFormModel.getName() + " " + practiceFormModel.getLastName());
        submitedFormResult.add(Gender.MALE.getValue());
        submitedFormResult.add(practiceFormModel.getMobile());
        return submitedFormResult;
    }
}
