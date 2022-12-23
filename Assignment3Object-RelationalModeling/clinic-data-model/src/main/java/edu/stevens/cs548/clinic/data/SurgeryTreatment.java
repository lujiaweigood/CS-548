package edu.stevens.cs548.clinic.data;

import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import static javax.persistence.CascadeType.REMOVE;

// TODO
@Entity
@Table(name = "SURGERYTREATMENT")
@DiscriminatorValue("S")
public class SurgeryTreatment extends Treatment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4173146640306267418L;
	
	// TODO
	@Temporal(TemporalType.DATE)
	@Column(name = "surgeryDate")
	private Date surgeryDate;

	@Column(name = "dischargeInstructions")
	private String dischargeInstructions;

	
	// TODO
//	@OneToMany
//	@JoinTable(name = "TREATMENT")
//	@JoinColumn(name = "TREATMENT_ID")

//	@ElementCollection
//	@CollectionTable(name="FELLOW_TREATMENT")
//	@JoinColumn(name = "TREATMENT_ID")
//	@OneToMany(cascade = CascadeType.ALL,  mappedBy = "surgeryTreatment")
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Treatment> followupTreatments;

	public Date getSurgeryDate() {
		return surgeryDate;
	}

	public void setSurgeryDate(Date surgeryDate) {
		this.surgeryDate = surgeryDate;
	}

	public String getDischargeInstructions() {
		return dischargeInstructions;
	}

	public void setDischargeInstructions(String dischargeInstructions) {
		this.dischargeInstructions = dischargeInstructions;
	}

	public Collection<Treatment> getFollowupTreatments() {
		return followupTreatments;
	}

	public void setFollowupTreatments(Collection<Treatment> followupTreatments) {
		this.followupTreatments = followupTreatments;
	}
	
	public SurgeryTreatment() {
		// TODO
		super();
	}

}
