package step_definitions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.json.Json;

import com.github.javafaker.Faker;

import io.cucumber.java.lu.a.as;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class FurkanSprint5ApiTest {
	
	static {
		RestAssured.baseURI="http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
	}
	
	private static String token;
	private static String id;
	
//	@Test
//	public void demoTest() {
//		Faker faker = new Faker();
//		String e=faker.internet().emailAddress();
//		
//RestAssured.baseURI="http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
//		
//RequestSpecification requestSpecification = RestAssured.given().body("{\"first_name\" : \"seli\" , \"last_name\" : \"veli\" , \"email\" : \""+e+"\" , \"password\" : \"1\"  }");
//	
//Response response = requestSpecification.post("/api/register.php");
//
//String str=response.asString();
//int code=response.getStatusCode();
//
//System.out.println(str);
//System.out.println(code);
//System.out.println(e);
//
//assertTrue(code==200);
//assertTrue(str.contains("1"));
//
//		
//	}
//
//	@Test
//	public void easySyntax() {
//		
//		Faker faker = new Faker();
//		String e=faker.internet().emailAddress();
//		
//RestAssured.baseURI="http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
//
//given().body("{\"first_name\" : \"seli\" , \"last_name\" : \"veli\" , \"email\" : \""+e+"\" , \"password\" : \"1\"}").
//
//when().log().all().post("/api/register.php").
//
//then().log().all().assertThat().statusCode(is(200)).body("success", equalTo(1));
//	
//	}
	
	
	
	@Test
	public void registerTest() {
		
		Faker faker = new Faker();
		String firstName=faker.name().firstName();
		String lastName=faker.name().lastName();
		String email= faker.internet().emailAddress();
		String password="" + faker.number().numberBetween(1, 100);
		
RestAssured.baseURI="http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";

		Map<String,Object>map = new LinkedHashMap<>();
		map.put("first_name", firstName);
		map.put("last_name", lastName);
		map.put("email", email);
		map.put("password", password);
		
Map mapExample = given().log().all().body(map).
		
when().log().all().post("/api/register.php").
	
then().log().all().assertThat().statusCode(is(200)).body("success", equalTo(1)).extract().as(Map.class);
	
	System.out.println(mapExample);
	
	}
	
	@Test
	public void loginTest() {
		
		RestAssured.baseURI="http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
		
		Map<String,String>loginBody=new LinkedHashMap<>();
		loginBody.put("email", ConfigReader.getProperty("email"));
		loginBody.put("password", ConfigReader.getProperty("password"));
		
		
		
		Map login = given().log().all().body(loginBody).
		when().log().all().post("/api/login.php").
		then().log().all().assertThat().statusCode(is(200)).body("success", equalTo(1)).extract().as(Map.class);
		
		token=(String)login.get("token");
		

	}
	
	@Test
	public void receiveId() {
		
		RestAssured.baseURI="http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
		Header header1=new Header("Authorization" , token);
		
		
		
		Map<String,Object>response = given().log().all().header(header1).
		when().log().all().get("/api/getmortagage.php").
		then().log().all().extract().as(Map.class);
		
		List<Map<String,Object>>list=new ArrayList<>();
		list=(List<Map<String, Object>>) response.get("mortagage_applications");
	Map<String,Object>eachApp=new LinkedHashMap<>();
	eachApp = list.get(2);
	id=(String)eachApp.get("id");
	System.out.println(id);
	
	}
	
//	@Test
//	public void receiveApplication() {
//		
//		RestAssured.baseURI="http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
//		Header header1=new Header("Authorization" , token);
//		
//		Map<String,String>id1=new HashMap<>();
//		id1.put("id",id);
//		
//		given().log().all().header(header1).body(id1).
//		when().log().all().post("/api/ mortagagedetails.php").
//		then().log().all().assertThat().statusCode(is(200)).body("success", equalTo(1));
//		
//		
//	}
	
	
}
