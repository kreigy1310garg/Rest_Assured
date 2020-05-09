package Spring.Rest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "html:target/cucumber-reports" }, features = { "src/test/resources/" }, glue = { "Spring","Rest" }, tags = { "" }, monochrome = true, dryRun =false)
public class ExecutorTestSuite {

}
