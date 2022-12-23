package edu.stevens.cs548.clinic.service.dto;

import java.time.LocalDate;

import com.google.gson.annotations.SerializedName;

public class SurgeryDto extends TreatmentDto {

    private String surgeryName;

    private String location;

    private String attention;

    @SerializedName("start-date")
    private LocalDate startDate;

    @SerializedName("end-date")
    private LocalDate endDate;

    public SurgeryDto() {
        super(TreatmentType.SURGERY);
    }

    public String getSurgery() {
        return surgeryName;
    }

    public void setSurgery(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }
}