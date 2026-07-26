package com.fhg.familyhealthguardian.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String patientPhone;
    private String medicineName;
    private String medicineTime;
    private String dosage;

    public Medicine() {}

    public Medicine(String patientName, String patientPhone, String medicineName, String medicineTime, String dosage) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.medicineName = medicineName;
        this.medicineTime = medicineTime;
        this.dosage = dosage;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getPatientPhone() { return patientPhone; }
    public void setPatientPhone(String patientPhone) { this.patientPhone = patientPhone; }

    public String getMedicineName() { return medicineName; }
    public void setMedicineName(String medicineName) { this.medicineName = medicineName; }

    public String getMedicineTime() { return medicineTime; }
    public void setMedicineTime(String medicineTime) { this.medicineTime = medicineTime; }

    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }
}