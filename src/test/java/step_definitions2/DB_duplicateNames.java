package step_definitions2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import utilities.DBUtils;

public class DB_duplicateNames {
	List<String> actualNames;

	@When("The user retrieve duplicate {string} from the {string} table")
	public void theUserRetrieveDuplicate(String columnName, String table) {

		String query = "Select " + columnName + "," + "count(" + columnName + ")from " + table + " " + "group by "
				+ columnName + " Having count(" + columnName + ")>2 limit 6";

		List<List<Object>> listBD = DBUtils.getQueryResultList(query);

		actualNames = new ArrayList<>();
		for (List<Object> list : listBD) {
			actualNames.add((String) (list.get(0)));
		}
	}

	@Then("The names should be as follows")
	public void theNamesOverShouldBeAsFollows(List<String> expectedNames) {

		assertEquals(expectedNames, actualNames);
	}
}
