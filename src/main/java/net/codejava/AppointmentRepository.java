package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	//Search Query for Appointment.
    @Query("SELECT a FROM Appointment a WHERE CONCAT(a.apptid, ' ', a.doctor, ' ', a.slot) LIKE %?1%")
    public List<Appointment> search(String keyword);
}
