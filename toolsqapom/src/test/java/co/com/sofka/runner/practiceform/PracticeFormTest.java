package co.com.sofka.runner.practiceform;

import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.practiceform.PracticeForm;
import co.com.sofka.stepdefinition.setup.WebUI;
import co.com.sofka.util.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends WebUI {

    private PracticeFormModel practiceFormModel;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";

    @BeforeEach
    public void setUp(){
        try{
            generalSetUp();
            practiceFormModel = new PracticeFormModel();
            practiceFormModel.setName("Iván");
            practiceFormModel.setLastName("Arroyave");
            practiceFormModel.setGender(Gender.MALE);
            practiceFormModel.setMobile("0123456789");
        } catch (Exception exception){
            quitDriver();
        }
    }

    @Test
    public void practiceFormTestMandatoryFields(){
        try{
            PracticeForm practiceForm = new PracticeForm(driver, practiceFormModel);
            practiceForm.fillStudentForm();

            Assertions.assertEquals(
                    practiceForm.isRegistrationDone(),
                    forSubmittedForm(),
                    ASSERTION_EXCEPTION_MESSAGE);
        } catch (Exception exception){
            quitDriver();
        }
    }

    @AfterEach
    public void tearDown(){
        quitDriver();
    }

    private List<String> forSubmittedForm(){
        List<String> submitedFormResult = new ArrayList<String>();
        submitedFormResult.add(practiceFormModel.getName() + " " + practiceFormModel.getLastName());
        submitedFormResult.add(practiceFormModel.getGender().getValue());
        submitedFormResult.add(practiceFormModel.getMobile());
        return submitedFormResult;
    }

}
