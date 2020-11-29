package io.tpd.springbootcucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/features",
        },
        plugin = {
                "pretty",
                "html:target/cucumber/bag.html",
                "json:target/cucumber/bag.json",
                "de.monochromata.cucumber.report.PrettyReports:target/cucumber"
        },
        extraGlue = {
                "io.tpd.springbootcucumber.bagcommons"
        })
public class RunCucumberTest { }
