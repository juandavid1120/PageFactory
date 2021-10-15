package co.com.sofka.stepdefinition.setup.webui;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/driver/windows/chrome/chromedriver.exe";

    private static final String DEMO_QA_URL = "https://demoqa.com/automation-practice-form";

    protected WebDriver driver;

    protected void setUpWebdriver(){
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
    }

    protected void setUpWebdriverUrl(){
        driver = new ChromeDriver();
        driver.get(DEMO_QA_URL);
    }

    protected void generalSetUp(){
        setUpLog4j2();
        setUpWebdriver();
        setUpWebdriverUrl();
    }

    protected void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void quitDriver(){
        driver.quit();
    }
}
