package healthCare;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Doctor extends User{
	private int doctorId;
	private String specialty;
	
	private ArrayList<Appointment> appointments;
	
	public Doctor(String firstName, String lastName, String phoneNumber, String email, String specialty) {
		super(firstName, lastName, phoneNumber, email);
		setDoctorID();
		setSpecialty(specialty);
		this.appointments = new ArrayList<Appointment>();
	}

	public void addAppoitment(Appointment a) {
		this.appointments.add(a);
	}
	
	//getters
	public int getDoctorId() {
		return doctorId;
	}
	public String getSpecialty() {
		return specialty;
	}
	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}
	
	
	//setters
	public void setDoctorID() {
		int randomtNumber = (int)((Math.random() * 99001) + 1000);
		this.doctorId = randomtNumber;
	}
	public void setSpecialty(String specialty) {
		if (!specialty.isEmpty() && !specialty.equalsIgnoreCase(null)) {
			this.specialty = specialty;
		} else {
			this.specialty = "Unknown";
		}
	}
	
	
	@Override
	public String toString() {
		return "Doctor ID : " + doctorId + "\n" +
	            "Name : " + super.getFirstName() + " " + super.getLastName() + "\n" +
				"Phone Number : " + super.getPhoneNumber() + "\n" +
	            "Email : " + super.getEmail() + "\n" +
				"Specialty : " + specialty + "\n";
	}
}
