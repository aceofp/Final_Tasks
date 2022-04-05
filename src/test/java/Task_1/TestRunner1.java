package Task_1;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/Task_1.feature", plugin = {"pretty", "html:out"})

public class TestRunner1 {

}
