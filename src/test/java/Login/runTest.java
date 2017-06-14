package Login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Yev on 6/13/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Login",
        glue = "Login",
        plugin = {"pretty", "html:target/cucumber"}
        )

public class runTest { }