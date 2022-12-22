package edu.stevens.cs548.clinic.domain;

public enum TreatmentType {

    DRUG_TREATMENT("D"),
    SURGERY("S"),
    RADIOLOGY("R"),
    Physiotherapy("P");
    private String tag;
    private TreatmentType(String tag) {
        this.tag = tag;
    }
    public String getTag() {
        return tag;
    }
    public static TreatmentType fromTag(String tag) {
        for (TreatmentType t : TreatmentType.values()) {
            if (t.getTag().equals(tag)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Unrecognized treatment type tag: "+tag);
    }

}