package edu.stevens.cs548.clinic.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import edu.stevens.cs548.clinic.util.DateUtils;

// TODO
@Entity
@Table(name = "PHYSIOTHERAPYTREATMENT")
@DiscriminatorValue("P")
public class PhysiotherapyTreatment extends Treatment {

	private static final long serialVersionUID = 5602950140629148756L;
	
	// TODO (including order by date)

	@ElementCollection
	@Temporal(TemporalType.DATE)
	protected List<Date> treatmentDates;

	public void addTreatmentDate(LocalDate date) {
		treatmentDates.add(DateUtils.toDatabaseDate(date));
	}


	@Override
	public <T> T export(ITreatmentExporter<T> visitor) {
		return visitor.exportPhysiotherapy(treatmentId,
				   patient.getPatientId(), 
				   provider.getProviderId(), 
				   diagnosis, 
				   DateUtils.fromDatabaseDates(treatmentDates),
				   exportFollowupTreatments(visitor)
				   );	}
	public PhysiotherapyTreatment() {
		super();
		this.setTreatmentType("P");
	}

}
