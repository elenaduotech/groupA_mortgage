package step_definitions1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignInPage;
import utilities.DBUtils;

public class DBPhoneNumberVerifDefs {
	
	String phoneNumber;
    String id;
    String down_payment_percent;
    
    
    @When("I update user phone number with {string} for a user with id {string}")
    public void iUpdateUserPhoneNumberWithForAUserWithId(String phoneNumber, String id) {
    	  String myQuery = "update tbl_user set phone='" + phoneNumber + "' where id='" + id +"'";
    	  this.phoneNumber = phoneNumber;
    	  this.id = id;
    	  DBUtils.updateQuery(myQuery);
    	  
    	  
    	  
    }

    @Then("Verify that user has updated phone number")
    public void verifyThatUserHasUpdatedPhoneNumber() {
    	
	
    	
    	String myQuery = "select phone from tbl_user where id='" + id +"'";
    	List<List<Object>> listDb = DBUtils.getQueryResultList(myQuery);
    	
    	ArrayList actualList = new ArrayList<>();

        for (List<Object> i: listDb){
           actualList.add((String)(i.get(0)));
        }
            String actualNumber = (String) actualList.get(0);	
    	
    	assertEquals(phoneNumber, actualNumber);
    	
    	
    	    }
    @When("I update the following information for the users with the following ids")
    public void iUpdateTheFollowingInformationForTheUsersWithTheFollowingIds(List<Map<String,String>> dataTable) {
//    	  for(int i=0; i<dataTable.size(); i++) {
    	Map<String, String> map = dataTable.get(0);
    	     	    	
    	 this.down_payment_percent = map.get("down_payment_percent");
    	 this.id = map.get("id");
    	 
    	 String myQuery = "update tbl_mortagage set down_payment_percent='" + down_payment_percent +"' where id='" + id +"'";

   	     DBUtils.updateQuery(myQuery);
//    }
    }
    	
 

    @Then("Verify that user has updated information")
    public void verifyThatUserHasUpdatedInformation() {
    	 String request = "select down_payment_percent from tbl_mortagage where id='" + id +"'";
    	 List<Map<String, Object>> list = DBUtils.getQueryResultMap(request);
    	 
    	 Map<String, Object> map = list.get(0);

         String actualPercent = (String) map.get("down_payment_percent");
         System.out.println(actualPercent + id);
         
         assertEquals(down_payment_percent, actualPercent);
    	 
    }
  
}