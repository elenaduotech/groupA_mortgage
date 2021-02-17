package step_definitions;

import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DBUtils;

public class FurkanSprint5OnlyDb {
	
	Map<String,Object>map;
//	Map<String,Object>map2;
	
	@Given("Get connected to db and receive information about the user")
	public void getConnectedToDbAndReceiveInformationAboutTheUser() {
	    
		
String query="select b_firstName , b_lastName , b_email from tbl_mortagage where b_email='jbiden@gmail.com';";
	
	List<Map<String,Object>>list=DBUtils.getQueryResultMap(query);

	map=list.get(0);
//	map2=list.get(1);
	
	
	}

	@Then("verify if firstname lastname and email is as expected")
	public void verifyIfFirstnameLastnameAndEmailIsAsExpected(List<List<String>> dataTable) {
	    
		List<String>pipe = dataTable.get(0);
		
		String actualName=pipe.get(0);
		String actualLastName=pipe.get(1);
		String actualEmail=pipe.get(2);
		
		assertEquals(map.get("b_firstName") , actualName);
		assertEquals(map.get("b_lastName") , actualLastName);
		assertEquals(map.get("b_email") , actualEmail);
//		assertEquals(map2.get("b_firstName") , actualName);
//		assertEquals(map2.get("b_lastName") , actualLastName);
//		assertEquals(map2.get("b_email") , actualEmail);
		
		
		
		
		
		
		
		
		
		
		
	}

}
