package step_definitions2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SignIn_api {

	static {
	       RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com/api";
	   }

	    String token;
	    Response response;
	    RequestSpecification specification;

}
