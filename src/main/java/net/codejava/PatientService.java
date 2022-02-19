package net.codejava;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public List<Patient> findAllPatients() {
		return (List<Patient>) patientRepository.findAll();
	}

	public Patient updatePatient(Patient patient,Long patientid)
	{
		Patient p = patientRepository.findById(patientid).get();
	
		if (Objects.nonNull(patient.getName()) && !"".equalsIgnoreCase(patient.getName())) {
		   p.setName(patient.getName());
		}
		
		if (Objects.nonNull(patient.getAddress()) && !"".equalsIgnoreCase(patient.getAddress())) {
		   p.setAddress(patient.getAddress());
		}
		
		if (Objects.nonNull(patient.getDob())) {
		   p.setDob(patient.getDob());
		}
		
		return patientRepository.save(p);
	}

	public void deletePatient(long patientid) {
		patientRepository.deleteById(patientid);
	}
	
	public List<Patient> searchPatient(String keyword){
		return patientRepository.search(keyword);
	}
}