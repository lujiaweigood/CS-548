package edu.stevens.cs548.clinic.research;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.*;

import edu.stevens.cs548.clinic.domain.UUIDConverter;
import org.eclipse.persistence.annotations.Convert;

import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Subject
 */
// TODO
@Entity
@Table(indexes = @Index(columnList="patientId"))
@org.eclipse.persistence.annotations.Converter(name="uuidConverter", converterClass= UUIDConverter.class)
public class Subject implements Serializable {

	
	private static final long serialVersionUID = 1L;

	// TODO
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	/*
	 * This will be same as patient id in Clinic database
	 */
	// TODO

	@Convert("uuidConverter")
	private UUID patientId;
		
	/*
	 * Anonymize patient (randomly generated when assigned)
	 *
	 */
	@Column(name="subjectId")
	private long subjectId;
	
	// TODO
	@OneToMany(cascade = REMOVE, mappedBy = "subject", orphanRemoval = true)
	private Collection<DrugTreatmentRecord> treatments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UUID getPatientId() {
		return patientId;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public Collection<DrugTreatmentRecord> getTreatments() {
		return treatments;
	}
	
	public void addTreatment(DrugTreatmentRecord treatment) {
		this.treatments.add(treatment);
	}
	
	public Subject() {
		treatments = new ArrayList<>();
	}
	
   
}