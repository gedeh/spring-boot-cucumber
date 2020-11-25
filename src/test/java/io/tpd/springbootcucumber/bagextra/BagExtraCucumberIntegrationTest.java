package io.tpd.springbootcucumber.bagextra;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/bagextra",
        plugin = {
                "pretty",
                "html:target/cucumber/bagextra.html",
                "json:target/cucumber/bagextra.json",
                "de.monochromata.cucumber.report.PrettyReports:target/cucumber"
        },
        extraGlue = "io.tpd.springbootcucumber.bagcommons")
public class BagExtraCucumberIntegrationTest {
}
