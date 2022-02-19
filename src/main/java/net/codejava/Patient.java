package net.codejava;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientid;
    
   // @Column(nullable = false)
    private String name;
    private String gender;
    private String address;
    private Date dob;
    
    @OneToMany(mappedBy="patient")
    private List<Appointment> appointment;
    
    protected Patient() {
    }
 
    protected Patient(String name, String gender, String address, Date dob) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
    }
 
    @Override
    public String toString() {
        return patientid + ". " + name + " - " + gender;     
    }

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getPatientid() {
		return patientid;
	}

	public void setPatientid(long patientid) {
		this.patientid = patientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
}
