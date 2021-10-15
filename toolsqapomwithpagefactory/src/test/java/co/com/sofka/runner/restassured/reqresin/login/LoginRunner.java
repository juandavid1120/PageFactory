package co.com.sofka.runner.restassured.reqresin.login;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        features = {"src/test/resources/features/restassured/reqresin/login/login.feature"},
        glue = {"co.com.sofka.stepdefinition.restassured.reqresin.login"},
        tags = "not @ignore"
)
public class LoginRunner {
}
