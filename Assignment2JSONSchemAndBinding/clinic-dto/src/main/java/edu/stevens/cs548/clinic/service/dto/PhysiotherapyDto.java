package edu.stevens.cs548.clinic.service.dto;

import java.time.LocalDate;

import com.google.gson.annotations.SerializedName;

public class PhysiotherapyDto extends TreatmentDto {

    private String physiotherapyName;

    private String location;

    private String attention;

    @SerializedName("start-date")
    private LocalDate startDate;

    @SerializedName("end-date")
    private LocalDate endDate;

    public PhysiotherapyDto() {
        super(TreatmentType.PHYSIOTHERAPY);
    }

    public String getPhysiotherapy() {
        return physiotherapyName;
    }

    public void setPhysiotherapy(String physiotherapyName) {
        this.physiotherapyName = physiotherapyName;
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