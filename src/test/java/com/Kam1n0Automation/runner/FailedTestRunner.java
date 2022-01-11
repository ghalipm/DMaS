package com.Kam1n0Automation.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "@target/rerun.txt",
        glue = "com/Kam1n0Automation/stepDefinitions"

)
public class FailedTestRunner {

}
