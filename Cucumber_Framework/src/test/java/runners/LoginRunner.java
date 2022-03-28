package runners;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(
		features = {"classpath:features"},
		glue = "steps",
		//tags = "OtherScenario1",
		monochrome = true,
		//dryRun = false,
		plugin = {
				"pretty",
				"html:target/cucumber/report.html",
				"json:target/cucumber/report.json"
				
		}
		
		
		)


public class LoginRunner {
	

}
