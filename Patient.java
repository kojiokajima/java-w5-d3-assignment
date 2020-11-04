package healthCare;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Patient extends User{
	private int patientID;
	private LocalDate dateOfBirth;
	private String gender;
	
	private final String DEFAULT_UNKNOWN = "Unknown";

	public Patient(String firstName, String lastName, String phoneNumber, String email,
			LocalDate dateOfBirth, String gender) {
		super(firstName, lastName, phoneNumber, email);
		setPatientID();
		setDateOfBirth(dateOfBirth);
		setGender(gender);
	}


	public int getPatientID() {
		return patientID;
	}


	public void setPatientID() {
		int randomNum = (int)(Math.random() * 10000 * 1000 + 1) + 1000;
		this.patientID = randomNum;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		if (!gender.isEmpty() && !gender.equalsIgnoreCase(null)) {
			
			if (gender.equalsIgnoreCase("m")) {
				this.gender = "Male";
			} else if (gender.equalsIgnoreCase("f")){
				this.gender = "Female";
			}
			
		} else {
			this.gender = DEFAULT_UNKNOWN;
		}
	}
	
	public String toString() {
		return "Patient ID : " + patientID + "\n" +
	           "Name : " + super.getFirstName() + " " + super.getLastName() + "\n" +
	           "Phone Number : " + super.getPhoneNumber() + "\n" +
			   "Email : " + super.getEmail() + "\n" +
	           "Date of Birth : " + dateOfBirth + "\n" +
			   "Gender : " + gender  + "\n";
	}
	
}
