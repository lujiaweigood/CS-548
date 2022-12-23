package edu.stevens.cs548.clinic.data;

import java.io.Serializable;
import java.util.Date;
//import javax.persistence.DiscriminatorValue;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.Table;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DrugTreatment
 */
//TODO
@Entity
@Table(name = "DRUGTREATMENT")
@DiscriminatorValue("D")
public class DrugTreatment extends Treatment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "drug")
	private String drug;
	@Column(name = "dosage")
	private float dosage;
	
	// TODO
	@Temporal(TemporalType.DATE)
	@Column(name = "startDate")
	private Date startDate;
	
	// TODO
	@Temporal(TemporalType.DATE)
	@Column(name = "endDate")
	private Date endDate;

	@Column(name = "frequency")
	private int frequency;

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public float getDosage() {
		return dosage;
	}

	public void setDosage(float dosage) {
		this.dosage = dosage;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DrugTreatment() {
		super();
	}

}
