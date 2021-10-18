package co.com.sofka.page.practiceform;

import co.com.sofka.model.practiceform.PageLoginModel;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PageLogin extends CommonActionsOnPages {
    private static final Logger LOGGER = Logger.getLogger(PageLogin.class);
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    PageLoginModel pageLoginModel;

    private By userName=By.id("txtUsername");
    private By password=By.id("txtPassword");
    private By btnLogin=By.id("btnLogin");
    // private By messageError=By.xpath("//*[@id=\"spanMessage\"]");

    public PageLogin(WebDriver driver, PageLoginModel pageLogin) {
        super(driver);
        this.pageLoginModel = pageLogin;
    }

    public PageLogin(WebDriver driver, PageLoginModel pageLogin, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);

        if(pageLogin == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.pageLoginModel = pageLogin;

    }

    public void fillLogin() throws IOException {
        clear(userName);
        typeInto(userName, pageLoginModel.getUsername());

        clear(password);
        typeInto(password, pageLoginModel.getPassword());

        doSubmit(btnLogin);
    }

    public String obtenerMensajeBienvenida(){
        final By asseretionWelcomeMessage = By.id("welcome");
        return getText(asseretionWelcomeMessage);
    }
    public String obtenerMensajeLoginFallido(){
        final By asseretionWelcomeMessage = By.id("spanMessage");
        return getText(asseretionWelcomeMessage);
    }


}