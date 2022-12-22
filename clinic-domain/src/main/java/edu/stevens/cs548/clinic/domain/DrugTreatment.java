package edu.stevens.cs548.clinic.domain;

import java.io.Serializable;
import java.time.LocalDate;
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


import edu.stevens.cs548.clinic.util.DateUtils;

/**
 * Entity implementation class for Entity: DrugTreatment
 * 
 */
// TODO JPA annotations
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

	public LocalDate getStartDate() {
		return DateUtils.fromDatabaseDate(startDate);
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = DateUtils.toDatabaseDate(startDate);
	}

	public LocalDate getEndDate() {
		return DateUtils.fromDatabaseDate(endDate);
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.startDate = DateUtils.toDatabaseDate(endDate);
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	

	public <T> T export(ITreatmentExporter<T> visitor) {
		// TODO
		return visitor.exportDrugTreatment(treatmentId, 
				patient.getPatientId(), 
				provider.getProviderId(), 
				diagnosis, 
				drug, 
				dosage, 
				DateUtils.fromDatabaseDate(startDate), 
				DateUtils.fromDatabaseDate(endDate), 
				frequency, 
				exportFollowupTreatments(visitor));
	}

	public DrugTreatment() {
		super();
		this.setTreatmentType("D");
	}

}
