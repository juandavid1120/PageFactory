package co.com.sofka.stepdefinition.practiceform.opt1;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.practiceform.PracticeForm;
import co.com.sofka.stepdefinition.setup.webui.WebUI;
import co.com.sofka.util.JobVacancy;
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


    @Given("que el Administrador se encuentra en la formulario de ingreso de  candidatos")
    public void que_el_administrador_se_encuentra_en_la_formulario_de_ingreso_de_candidatos() {
        try {
            generalSetUp();
            dataConfiguration();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el Administrador ingresa todos los campos y confirma la acción")
    public void el_administrador_ingresa_todos_los_campos_y_confirma_la_accion() {
        try {
            practiceForm = new PracticeForm(driver, practiceFormModel, TEN_SECONDS.getValue());
            practiceForm.fillStudentFormUsingAllFields();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema deberá mostrar por pantalla el registro del candidato ingresado.")
    public void el_sistema_debera_mostrar_por_pantalla_el_registro_del_candidato_ingresado() {
        try {
            Assertions.assertEquals(
                    expected(),
                    practiceForm.isRegistrationDone(),
                    ASSERTION_EXCEPTION_MESSAGE
            );

            //Assertions.assertEquals(practiceFormModel.getName() + " " + practiceFormModel.getLastName(), practiceForm.isNoneInseted());

            //Assertions.assertTrue((practiceFormModel.getName() + " " + practiceFormModel.getLastName()).equals(practiceForm.isNoneInseted()));

            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }



  /*  //Funciones comunes:
    private void dataConfiguration(){
        practiceFormModel = new PracticeFormModel();
        practiceFormModel.setName("Iván");
        practiceFormModel.setLastName("Arroyave");
        practiceFormModel.setEmail("a@gmail.com");
        practiceFormModel.setGender(JobVacancy.MALE);
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
        submitedFormResult.add(JobVacancy.MALE.getValue());
        submitedFormResult.add(practiceFormModel.getMobile());
        return submitedFormResult;
    }*/
}
