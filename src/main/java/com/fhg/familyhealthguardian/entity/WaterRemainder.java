package com.fhg.familyhealthguardian.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "water_remainder")
public class WaterRemainder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;
    private int amountMl;
    private int glasses;
    private String date;

    public WaterRemainder() {
    }

    public WaterRemainder(String memberName, int amountMl, int glasses, String date) {
        this.memberName = memberName;
        this.amountMl = amountMl;
        this.glasses = glasses;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getAmountMl() {
        return amountMl;
    }

    public void setAmountMl(int amountMl) {
        this.amountMl = amountMl;
    }

    public int getGlasses() {
        return glasses;
    }

    public void setGlasses(int glasses) {
        this.glasses = glasses;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
