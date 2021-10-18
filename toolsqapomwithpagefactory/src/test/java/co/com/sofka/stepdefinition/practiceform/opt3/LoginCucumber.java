package co.com.sofka.stepdefinition.practiceform.opt3;

import co.com.sofka.model.practiceform.PageLoginModel;
import co.com.sofka.model.practiceform.PracticeFormModel;
import co.com.sofka.page.practiceform.PageLogin;
import co.com.sofka.page.practiceform.PracticeForm;
import co.com.sofka.stepdefinition.setup.webui.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class LoginCucumber extends WebUI {
    private static final Logger LOGGER = Logger.getLogger(LoginCucumber.class);
    private PageLoginModel pageLoginModel;
    private PageLogin pageLogin;
    private PracticeForm practiceForm;
    private PracticeFormModel practiceFormModel;
    private WebElement btnRecruitment;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";
    private static final String MENSAJE_BIENVENIDA = "Welcome Paul";
    private static final String MENSAJE_LOGIN_INVALIDO = "Invalid credentials";
    private static final String MENSAJE_CAMPOS_VACIOS = "Username cannot be empty";

    //background
    @Given("que el usuario final se encuentra en la página del login")
    public void que_el_usuario_final_se_encuentra_en_la_pagina_del_login() {
        try
        {
            generalSetUp();
            dataConfigurationLogin();

        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el usuario final ingresa user y password validos")
    public void el_usuario_final_ingresa_user_y_password_validos() {
        try {
            pageLogin = new PageLogin(driver, pageLoginModel);
            pageLogin.fillLogin();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }

    }

    @Then("el sistema deberá mostrar por pantalla el mensaje de bienvenida")
    public void el_sistema_debera_mostrar_por_pantalla_el_mensaje_de_bienvenida() {
        try {
            Assertions.assertEquals(
                    MENSAJE_BIENVENIDA,
                    pageLogin.obtenerMensajeBienvenida(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception) {
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }




    //Funciones comunes:
    private void dataConfigurationLogin() {
        pageLoginModel = new PageLoginModel();
        pageLoginModel.setUsername("Admin");
        pageLoginModel.setPassword("admin123");

    }

}

