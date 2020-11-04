package healthCare;

import java.util.regex.Pattern;

public class User {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	
	//constructor
	public User(String firstName, String lastName, String phoneNumber, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setEmail(email);
	}

	
	//getters
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	//setters
	public void setFirstName(String firstName) {
		if (!firstName.isEmpty() && !firstName.equalsIgnoreCase(null)) {
			this.firstName = firstName;
		} else {
			this.firstName = "Unknown";
		}
	}
	public void setLastName(String lastName) {
		if (!lastName.isEmpty() && !lastName.equalsIgnoreCase(null)) {
			this.lastName = lastName;
		} else {
			this.lastName = "Unknown";
		}
	}
	public void setPhoneNumber(String phoneNumber) {
		String pattern = "^\\d{3}-\\d{3}-\\d{4}$";
		Pattern p = Pattern.compile(pattern);
		
		if (!phoneNumber.isEmpty() && !phoneNumber.equalsIgnoreCase(null)) {
			
			if (p.matcher(phoneNumber).find()) {
				this.phoneNumber = phoneNumber;
			} else {
				this.phoneNumber = "Invalid phone number";
			}
		} else {
			this.phoneNumber = "Unknown";
		}
	}
	public void setEmail(String email) {
		String pattern = "^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$";
	    Pattern p = Pattern.compile(pattern);
	    
	    if (!email.isEmpty() && !email.equalsIgnoreCase(null)) {
	    	
	    	if (p.matcher(email).find()) {
	    		this.email = email;
	    	} else {
	    		this.email = "Invalid email";
	    	}
		} else {
			this.email = "Unknown";
		}
	}
}
