package step_definitions;

import java.util.Map;

import io.cucumber.java.DataTableType;
import pojos.User;

public class PojoConverter {
	
	
	@DataTableType
	public User getUser(Map<String,String>map) {
		
		String firstName=map.get("name");
		String lastName=map.get("lastName");
		String ssn=map.get("ssn");
		String dateOfBirth=map.get("dob");
		String cellPhoneNumber=map.get("cellPhoneNo");
		String email=map.get("email");
		String monthlyIncome=map.get("monthlyIncome");
		String maritalStatus=map.get("maritalStatus");
		
return new User(firstName,lastName,ssn,dateOfBirth,cellPhoneNumber,email,monthlyIncome,maritalStatus);
		
		
		
	}

}
