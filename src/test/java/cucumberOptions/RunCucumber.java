package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
                        features = "src/test/java/features",
                        glue = "stepDenfinitions",
                        monochrome = true,
                        strict = true,
                        plugin = { "pretty","html:target/cucumber", "junit:target/cucumber/cucumber.xml"},
                        snippets = SnippetType.UNDERSCORE,
                        tags = { "@payment" }
                        )

public class RunCucumber {

}