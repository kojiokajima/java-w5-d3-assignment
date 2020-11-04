package healthCare;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Appointment {

	private Patient patients;
	private LocalDateTime appointmentDateTime;
	
	public Appointment(Patient patients, LocalDateTime appointmentDateTime) {
		setPatients(patients);
		setAppointmentDateTime(appointmentDateTime);
	}
	
	
	public Patient getPatients() {
		return patients;
	}
	
	public void setPatients(Patient patients) {
		this.patients = patients;
	}
	
	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}
	
	public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}
	
	public String toString() {
		return "\nAppointment : " + appointmentDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + "\n" +
				"Patient : " + patients.getFirstName() + " " + patients.getLastName() + "\n";
	}
}
