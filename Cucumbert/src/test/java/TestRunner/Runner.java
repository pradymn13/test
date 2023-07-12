package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features = "C:\\Users\\pradyumna.mishra\\eclipse-workspace\\Cucumbert\\src\\test\\java\\Features\\Login.feature",
		features="C:\\Users\\pradyumna.mishra\\eclipse-workspace\\Cucumbert\\src\\test\\java\\Features\\practicelogin.feature",
		glue={"StepDefinitions"},
		tags = "@Regressionp",
		dryRun=false,		
		plugin= {"pretty"},
		monochrome = true
		//tags = {'@Regression'}
		
		)

public class Runner {

}
