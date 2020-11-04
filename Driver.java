// group of Koji and Miyu
package healthCare;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class Driver {
	
public static Scanner input = new Scanner(System.in);
	
	// print all doctors
	public static void printDr(ArrayList<Doctor> dList) {
		for (Doctor d : dList) {
	    	System.out.println(d.toString());
		}
	}
	
	// print all patients
	public static void printPatient(ArrayList<Patient> pList) {
		for (Patient p : pList) {
			System.out.println(p.toString());
		}
	}
	
	// asking user if they are doctor or patients
	public static String askUser() {
		System.out.print("Enter 'D' for doctor or 'P' for patient : ");
		String dOrP = input.next();

		while (!dOrP.equalsIgnoreCase("d") && !dOrP.equalsIgnoreCase("p")) {
			System.err.println("Invalid input");
			System.out.print("Enter 'D' for doctor or 'P' for patient : ");
			dOrP = input.next();
		}
		return dOrP;
	}
	
	// find dr from drid and returning dr
	public static Doctor findDr(ArrayList<Doctor> dList, int yourID) {
		for (Doctor d : dList) {
			if (yourID == d.getDoctorId()) {
				return d;
			}
		}
		return null;
	}
	
	// asking drid and returning dr
    public static Doctor askDrId(ArrayList<Doctor> dList) {
		printDr(dList);
		Doctor dr = null;
		boolean found = true;
		do {
			System.out.print("Enter your Doctor ID : ");
			int yourID = input.nextInt();
			dr = findDr(dList, yourID);
			if (dr != null) {
					found = false;
				} else {
					System.err.println("Couldn't find this Doctor ID.");
				}
		} while (found);
		return dr;
     }

    // printing doctor's appointment
    public static void printDrAppointment(Doctor doctor) {
	   for (Appointment a : doctor.getAppointments())
		   System.out.println(a.toString());
    }
    
    //asking patients id
    public static Patient findPatients(ArrayList<Patient> pList, int yourID) {
		for (Patient p : pList) {
			if (yourID == p.getPatientID()) {
				return p;
			}
		}
		return null;
	}
	
	// asking patient id and returning patient
    public static Patient askPatientId(ArrayList<Patient> pList) {
		printPatient(pList);
		Patient patient;
		boolean found = true;
		do {
			System.out.print("Enter your Patient ID : ");
			int yourID = input.nextInt();
			patient = findPatients(pList, yourID);
			if (patient != null) {
					found = false;
				} else {
					System.err.println("Couldn't find this Doctor ID.");
				}
		} while (found);
		return patient;
     }
    
    // making an appointment
    public static Appointment makeAppoitment(ArrayList<Patient> pList, Patient patient) {
		LocalDateTime apoDateTime = null;
				
				System.out.println("When would you like to make an appointment : ");
				System.out.print("Number of year : ");
				int year = input.nextInt();
				System.out.print("Number of month :");
				int month = input.nextInt();
				System.out.print("Day of month : ");
				int dayOfMonth = input.nextInt();
				System.out.print("Number of hour : ");
				int hour = input.nextInt();
				System.out.print("Number of minute : ");
				int minute = input.nextInt();
				
				apoDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
		
		
    	return new Appointment(patient, apoDateTime);	
	}
    
    // asking a patient which dr they want to make an appointment with
    public static Doctor chooseDoctor(ArrayList<Doctor> dList) {
		printDr(dList);
		System.out.print("Enter doctor's doctor Id : ");
		int choosenDrId = input.nextInt();
		Doctor returnDoctor = findDr(dList, choosenDrId);
		
		while (returnDoctor == null) {
			System.out.println("Couldn't find the doctor.");
			System.out.print("Enter doctor's doctor Id : ");
			choosenDrId = input.nextInt();
			returnDoctor = findDr(dList, choosenDrId);

		}
		return returnDoctor;		
	}
    
    // print our patient's appointment
    public static void printPatientAppointment(Doctor doctor) {
 	   for (Appointment a : doctor.getAppointments())
 		   System.out.println(a.toString() + "With Dr. " + doctor.getFirstName() + " " + doctor.getLastName());
    }

	public static void main(String[] args) {
		ArrayList<Patient> patients = new ArrayList<Patient>();
		
		Patient p1 = new Patient("Marwan", "Pace", "111-123-4567", "marwan@gmail.com", LocalDate.of(1981, 1, 2), "m");
		Patient p2 = new Patient("Farrah", "Hook", "222-123-4567", "farrah@yahoo.ca", LocalDate.of(1985, 3, 21), "f");
		Patient p3 = new Patient("Clare", "Levine", "333-123-4567", "clairelevine@gmail.com", LocalDate.of(1990, 10, 2), "f");
		Patient p4 = new Patient("Rares", "Daniels", "444-123-4567", "danielsrares@yahoo.ca", LocalDate.of(1991, 3, 1), "f");
		Patient p5 = new Patient("Youssef", "Tapia", "555-123-4567", "tapis@outlook.com", LocalDate.of(1983, 11, 12), "m");
		Patient p6 = new Patient("Odin", "Mcculloch", "666-123-4567", "odin@yahoo.ca", LocalDate.of(1999, 5, 21), "f");
		Patient p7 = new Patient("Tabatha", "Cousins", "777-123-4567", "tabatha@outlook.com", LocalDate.of(1994, 7, 24), "m");
		Patient p8 = new Patient("Hamid", "Gilmore", "888-123-4567", "hamid@yahoo.ca", LocalDate.of(1997, 8, 31), "f");
		Patient p9 = new Patient("Emmie", "Edwards", "999-123-4567", "emmie@gmail.com", LocalDate.of(1997, 12, 5), "m");
		Patient p10 = new Patient("Tylor", "Johnston", "111-111-4567", "tylorjohnston@yahoo.ca", LocalDate.of(1999, 6, 11), "f");
		
		patients.add(p1);
		patients.add(p2);
		patients.add(p3);
		patients.add(p4);
		patients.add(p5);
		patients.add(p6);
		patients.add(p7);
		patients.add(p8);
		patients.add(p9);
		patients.add(p10);
		
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		
		Doctor d1 = new Doctor("Nial", "Wynn", "101-101-1010", "nial@hospital.com", "Dentist");
		Doctor d2 = new Doctor("Alec", "Macdonald", "202-222-1010", "alec@hospital.com", "Neurosurgery");
		Doctor d3 = new Doctor("Ameena", "Curry", "303-301-3010", "ameena@hospital.com", "Surgeon");
		Doctor d4 = new Doctor("Noor", "", "14-401-4410", "noor/hospital.com", "Physician");

		doctors.add(d1);
		doctors.add(d2);
		doctors.add(d3);
		doctors.add(d4);
		
		Appointment a1 = new Appointment(p1, LocalDateTime.of(2020, 11, 3, 10, 00));
		Appointment a2 = new Appointment(p3, LocalDateTime.of(2020, 12, 20, 11, 30));
		
		d1.addAppoitment(a1);
		d2.addAppoitment(a2);
		
		// asking user if they are doctor or patient
		String dOrP = askUser();
		
		if (dOrP.equalsIgnoreCase("d")) {
			
			Doctor doctor = askDrId(doctors);
			printDrAppointment(doctor);
			
		} else if (dOrP.equalsIgnoreCase("p")){
			
			Patient patient = askPatientId(patients);
			Appointment newAppointment = makeAppoitment(patients, patient);
			Doctor choosenDoctor = chooseDoctor(doctors);
			choosenDoctor.addAppoitment(newAppointment);
			printPatientAppointment(choosenDoctor);
			
		}

	}
}


