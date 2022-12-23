package edu.stevens.cs548.clinic.data;

public class TreatmentFactory {
	
	public DrugTreatment createDrugTreatment() {
		return new DrugTreatment();
	}

	public PhysiotherapyTreatment createPhysiotherapyTreatment() {
		return new PhysiotherapyTreatment();
	}

	public RadiologyTreatment createRadiologyTreatment() {
		return new RadiologyTreatment();
	}

	public SurgeryTreatment createSurgeryTreatment() {
		return new SurgeryTreatment();
	}

}
