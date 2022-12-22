package edu.stevens.cs548.clinic.service.dto;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class RadiologyDto extends TreatmentDto {

    private String radiologyName;

    private String location;

    private String attention;

    @SerializedName("start-date")
    private LocalDate startDate;

    @SerializedName("end-date")
    private LocalDate endDate;

    public RadiologyDto() {
        super(TreatmentType.RADIOLOGY);
    }

    public String getRadiologyName() {
        return radiologyName;
    }

    public void setRadiologyName(String radiologyName) {
        this.radiologyName = radiologyName;
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