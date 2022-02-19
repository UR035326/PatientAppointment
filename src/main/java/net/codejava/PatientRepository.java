package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
public interface PatientRepository extends JpaRepository<Patient, Long> {
     
	/*public Patient findByPatientid(long patientid);
    
    public List<Patient> findByName(String name);
    
    public List<Patient> findByGender(String gender);
    
    public List<Patient> findByDob(Date dob);
    
    public List<Patient> findByaddressContaining(String address);*/
    
	//Search Query for Patient.
    @Query("SELECT p FROM Patient p WHERE CONCAT(p.name, ' ', p.patientid, ' ', p.gender, ' ', p.address) LIKE %?1%")
    public List<Patient> search(String keyword);
}
