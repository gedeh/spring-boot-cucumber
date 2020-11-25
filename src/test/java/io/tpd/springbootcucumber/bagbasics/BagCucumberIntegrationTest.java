package io.tpd.springbootcucumber.bagbasics;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features/bagbasics",
                "src/test/resources/features/bagextra",
        },
        plugin = {
                "pretty",
                "html:target/cucumber/bagbasics.html",
                "json:target/cucumber/bagbasics.json",
                "de.monochromata.cucumber.report.PrettyReports:target/cucumber"
        },
        extraGlue = "io.tpd.springbootcucumber.bagcommons")
public class BagCucumberIntegrationTest {
}
