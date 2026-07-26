package com.fhg.familyhealthguardian.entity;

import jakarta.persistence.*;

@Entity
public class EmergencyContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contactName;     // e.g., Dr. Sharma / Father / Brother
    private String relation;        // e.g., Family Doctor, Father, Spouse
    private String phoneNumber;     // Phone Number
    private String note;            // Optional (e.g., Hospital Clinic address or Blood group)

    public EmergencyContact() {}

    public EmergencyContact(String contactName, String relation, String phoneNumber, String note) {
        this.contactName = contactName;
        this.relation = relation;
        this.phoneNumber = phoneNumber;
        this.note = note;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }

    public String getRelation() { return relation; }
    public void setRelation(String relation) { this.relation = relation; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
