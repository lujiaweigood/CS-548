package edu.stevens.cs548.clinic.data;

import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import static javax.persistence.CascadeType.REMOVE;

// TODO
@Entity
@Table(name = "RADIOLOGYTREATMENT")
@DiscriminatorValue("R")
public class RadiologyTreatment extends Treatment {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3656673416179492428L;

	// TODO

//@ElementCollection

//@CollectionTable(name="Radiology_date")
@ElementCollection
@Temporal(TemporalType.DATE)
@CollectionTable(name="Date", joinColumns = @JoinColumn(name = "RadiologyTreatmentid_fk"))
protected Collection<Date> treatmentDates;
	
	// TODO
//	@OneToMany
//	@JoinTable(name = "TREATMENT")
//	@JoinColumn(name = "TREATMENT_ID")

//	@ElementCollection
//	@CollectionTable(name="FELLOW_TREATMENT")
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "radiologyTreatment")
	@OneToMany(cascade = CascadeType.ALL)
	protected Collection<Treatment> followupTreatments;

	public Collection<Date> getTreatmentDates() {
		return treatmentDates;
	}

	public void setTreatmentDates(Collection<Date> treatmentDates) {
		this.treatmentDates = treatmentDates;
	}

	public Collection<Treatment> getFollowupTreatments() {
		return followupTreatments;
	}

	public void setFollowupTreatments(Collection<Treatment> followupTreatments) {
		this.followupTreatments = followupTreatments;
	}
	
	public RadiologyTreatment() {
		// TODO
		super();
	}
	
}
