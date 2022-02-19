package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PatientController {
	 	@Autowired 
	 	private PatientService patientService;
	 	
	 	// Create operation - Patient
	    @PostMapping("/savePatient")
	    public Patient savePatient(@RequestBody Patient patient)
	    {
	        return patientService.savePatient(patient);
	    }
	    
	    // Retrieve operation - Patient
	    @GetMapping("/getPatients")
	    public List<Patient> findAllPatients() {
			return (List<Patient>) patientService.findAllPatients();
		}

	    // Update operation - Patient
	    @PutMapping("/updatePatient")
		public Patient updatePatient(@RequestBody Patient patient, @RequestParam Long patientid) {
			return patientService.updatePatient(patient,patientid);
		}

	    // Delete operation - Patient
	    @DeleteMapping("/deletePatient")
		public String deletePatient(@RequestParam Long patientid) {
			patientService.deletePatient(patientid);
			return "Patient is deleted";
		}
	    
	    // Search Operation - Patient
	    @GetMapping("/searchPatient")
	    public List<Patient> searchPatient(@RequestBody String keyword) {
			return (List<Patient>) patientService.searchPatient(keyword);
		}
	    
	    @Autowired 
	 	private AppointmentService appointmentService;
	    
	    // Create operation - Appointment
	    @PostMapping("/saveAppointment")
	    public Appointment saveAppointment(@RequestBody Appointment appointment)
	    {
	        return appointmentService.saveAppointment(appointment);
	    }
	    
	    // Retrieve operation - Appointment
	    @GetMapping("/getAppointments")
	    public List<Appointment> findAllAppointments() {
			return (List<Appointment>) appointmentService.findAllAppointments();
		}

	    // Update operation - Appointment
	    @PutMapping("/updateAppointment")
		public Appointment updateAppointment(@RequestBody Appointment appointment, @RequestParam Long apptid) {
			return appointmentService.updateAppointment(appointment,apptid);
		}

	    // Delete operation - Appointment
	    @DeleteMapping("/deleteAppointment")
		public String deleteAppt(@RequestParam Long apptid) {
	    	appointmentService.deleteAppointment(apptid);
			return "Appointment is deleted";
		}
	    
	    // Search Operation - Appointment
	    @GetMapping("/searchAppointment")
	    public List<Appointment> searchAppointment(@RequestBody String keyword) {
	    	List<Appointment> li = (List<Appointment>) appointmentService.searchAppointment(keyword);
	    	return li;
		}
}
