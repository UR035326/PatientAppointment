package net.codejava;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	public List<Appointment> findAllAppointments() {
		return (List<Appointment>) appointmentRepository.findAll();
	}

	public Appointment updateAppointment(Appointment appointment, Long apptid)
	{
		Appointment p = appointmentRepository.findById(apptid).get();

		if (Objects.nonNull(appointment.getDoctor()) && !"".equalsIgnoreCase(appointment.getDoctor())) 
		{
		   p.setDoctor(appointment.getDoctor());
		}
		
		if (Objects.nonNull(appointment.getSlot()) && !"".equalsIgnoreCase(appointment.getSlot())) {
		   p.setSlot(appointment.getSlot());
		}
		
		p.setPatient(appointment.getPatient());
		
		return appointmentRepository.save(p);
	}

	public void deleteAppointment(long apptid) {
		appointmentRepository.deleteById(apptid);
	}
	
	public List<Appointment> searchAppointment(String keyword){
		return appointmentRepository.search(keyword);
	}
}