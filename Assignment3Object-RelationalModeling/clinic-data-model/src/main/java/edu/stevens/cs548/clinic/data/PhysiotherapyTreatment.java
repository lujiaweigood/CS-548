package edu.stevens.cs548.clinic.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

// TODO
@Entity
@Table(name = "PHYSIOTHERAPYTREATMENT")
@DiscriminatorValue("P")
public class PhysiotherapyTreatment extends Treatment {
	private static final long serialVersionUID = 5602950140629148756L;
	
	// TODO

	@ElementCollection
	@Temporal(TemporalType.DATE)
	@CollectionTable(name="Physiotherapy_date")
	protected Collection<Date> treatmentDates;
	public Collection<Date> getTreatmentDates() {
		return treatmentDates;
	}

	public void setTreatmentDates(Collection<Date> treatmentDates) {
		this.treatmentDates = treatmentDates;
	}
	
	public PhysiotherapyTreatment() {
		// TODO
		super();
	}

}
