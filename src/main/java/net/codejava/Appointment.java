package net.codejava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long apptid;
    
    @Column(nullable = false)
    
    private String doctor;
    private String slot;
    
    @ManyToOne
    @JoinColumn(name = "patientid")
    private Patient patient;
    
    public long getApptid() {
		return apptid;
	}

	public void setApptid(long apptid) {
		this.apptid = apptid;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	protected Appointment() {
    }
 
    protected Appointment(String doctor, String slot,Patient patient) {
        //this.patientid = patientid;
        this.doctor = doctor;
        this.slot = slot;
        this.patient = patient;
    }
 
    @Override
    public String toString() {
        return apptid + ". " + doctor + " - " + patient;     
    }  
}
