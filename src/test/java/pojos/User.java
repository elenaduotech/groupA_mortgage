package pojos;

public class User {
	
	
	private String firstName;
	private String lastName;
	private String ssn;
	private String dateOfBirth;
	private String cellPhoneNumber;
	private String email;
	private String monthlyIncome;
	private String maritalStatus;
	
	
	public User() {}
	public User(String firstName, String lastName, String ssn, String dateOfBirth, String cellPhoneNumber, String email,
			String monthlyIncome,String maritalStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.dateOfBirth = dateOfBirth;
		this.cellPhoneNumber = cellPhoneNumber;
		this.email = email;
		this.monthlyIncome = monthlyIncome;
		this.maritalStatus = maritalStatus;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	


}
