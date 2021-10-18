package co.com.sofka.runner.practiceform;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        features = {"src/test/resources/features/webui/practiceform/Login.feature"},
        glue = {"co.com.sofka.stepdefinition.practiceform.opt3"},
        tags = "not @ignore"
)
public class LoginCucumberOpc3 {

}
