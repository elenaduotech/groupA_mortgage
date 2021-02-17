package step_definitions2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;

public class Hooks2 {

	@Before("@loanApp")
	public void setupScenario() {

		Driver.getDriver().manage().timeouts()
				.implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitTimeout")), TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().get(ConfigReader.getProperty("db_url"));
		DBUtils.createConnection();

	}

	@After("@loanApp")
	public void tearDownScenario(Scenario scenario) {

		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

			String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

			scenario.attach(screenshot, "image/png", "Screenshot" + date);
		}

		Driver.quit();
		DBUtils.close();
	}

}
