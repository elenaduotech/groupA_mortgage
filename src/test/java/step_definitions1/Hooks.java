package step_definitions1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.Driver;

public class Hooks {
	
	
	
	@Before ()
	public void setupScenario() {
		
		Driver.getDriver().manage().timeouts().
		implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitTimeout")), TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		
		
	}
	
//	@Before ()
//	public void setupDB() {
//		
//		System.out.println("Establishing connectio  to DB");
//		
//	}
	
	
	
	
	@After ()
	public void tearDownScenario(Scenario scenario) {
		
		if(scenario.isFailed()) {
			byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			
			String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			scenario.attach(screenshot, "image/png", "Screenshot"+date);
		}
		
		
		
		Driver.quit();
	}
	
	
//	@After ()
//	public void tearDownDB() {
//		
//		System.out.println("Closing the connection to DB and cleaning the db");
//		
//	}
	

}
