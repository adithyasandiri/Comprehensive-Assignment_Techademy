package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 	
@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\adith\\eclipse-workspace\\CucumberMakeMytrip\\Feature\\makeMyTrip.feature",
				glue = "stepDeffinations")
public class TestRunner {

}
