package step_definitions2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtils;

public class DB_ColumnNames {
	List<String> actualColumnNames;

	@When("The user retrieves column names from the {string} table")
	public void theUserRetrievesColumns(String table) {
		String query = "Select * from " + table + "";

		actualColumnNames = DBUtils.getColumnNames(query);
		System.out.println(actualColumnNames);
	}

	@Then("The names of the column should be the following")
	public void theNamesOfTheColumnShouldBe(List<String> expectedColumnNames) {
		System.out.println(expectedColumnNames);
		assertEquals(expectedColumnNames, actualColumnNames);
	}

}
