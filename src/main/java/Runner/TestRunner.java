package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/resources/features/PVHKTScenario.feature" }, glue = "steps",dryRun = false, monochrome = true )
public class TestRunner {

}
