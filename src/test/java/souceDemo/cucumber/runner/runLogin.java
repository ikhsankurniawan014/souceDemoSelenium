import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/souceDemo/cucumber/features",
        glue = "souceDemo/cucumber/stepDef",
        plugin = {"html:target/HTML_report.html"},
        tags = "@Functional"
)
public class runLogin {
}