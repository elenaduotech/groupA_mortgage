package step_definitions1;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;


public class APISprint5Defs {
	
	
	static {
		RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
	   }
	
	
	RequestSpecification requestSpecification;
	Response response;
	String email;
	String password = "123456";
	
	@Given("First name, last name, email and password")
	public void firstNameLastNameEmailAndPassword() {
		Faker fake = new Faker();
		String firstName = fake.name().firstName();
	    String lastName = fake.name().lastName();
	    this.email = fake.internet().emailAddress();

	    
	    Map<String,Object> map = new LinkedHashMap<>();
	    map.put("first_name", firstName);
	    map.put("last_name", lastName);
	    map.put("email", email);
	    map.put("password", password);
	    
	    requestSpecification = given().log().all().body(map);

    }

	@When("User enters this information")
	public void userEntersThisInformation() {
		response = requestSpecification.when().log().all().post("/api/register.php");
		
	}
	
	


	@Then("User is registered in the system")
	public void userIsRegisteredInTheSystem() {
		Map mapNew = response.then().log().all().
                assertThat().statusCode(is(200)).extract().as(Map.class);
                
       System.out.println(mapNew);
	}



@Given("Email and password")
public void emailAndPassword() {
	
	 Map<String,Object> map = new LinkedHashMap<>();
	    map.put("first_name", ConfigReader.getProperty("first_name2"));
	    map.put("last_name", ConfigReader.getProperty("last_name2"));
	    map.put("email", ConfigReader.getProperty("email2"));
	    map.put("password", ConfigReader.getProperty("password2"));
	given().log().all().body(map).when().log().all().post("/api/register.php").then().log().all().
    assertThat().statusCode(is(200));
	
	
	
	
	
	   Map<String,String> loginBody= new LinkedHashMap<>();
	    loginBody.put("email", ConfigReader.getProperty("email2"));
	    loginBody.put("password", ConfigReader.getProperty("password2"));
	   
	requestSpecification = given().log().all().body(loginBody);
	
	}


@When("User enters email and password")
public void userEntersEmailAndPassword() {
 
	response = requestSpecification.when().log().all().post("/api/login.php");
	
	
}

@Then("User is able to successfully logged in")
public void userIsAbleToSuccessfullyLoggedIn() {
	Map mapNew = response.then().log().all().
            assertThat().statusCode(is(200)).body("success", equalTo(1)).extract().as(Map.class);
            
   System.out.println(mapNew);
   String token = (String)mapNew.get("token");
	
	
	
	
}




}
