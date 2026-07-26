package com.fhg.familyhealthguardian.entity;

import jakarta.persistence.*;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hospitalName;       // Hospital Name
    private String hospitalPhone;      // Hospital Phone Number
    private String timeToReach;        // Time to reach hospital (e.g., 10:30 AM)
    private String doctorName;         // Doctor Name (Optional)
    private String memberName;         // Family Member Name

    public Appointment() {}

    public Appointment(String hospitalName, String hospitalPhone, String timeToReach, String doctorName, String memberName) {
        this.hospitalName = hospitalName;
        this.hospitalPhone = hospitalPhone;
        this.timeToReach = timeToReach;
        this.doctorName = doctorName;
        this.memberName = memberName;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }

    public String getHospitalPhone() { return hospitalPhone; }
    public void setHospitalPhone(String hospitalPhone) { this.hospitalPhone = hospitalPhone; }

    public String getTimeToReach() { return timeToReach; }
    public void setTimeToReach(String timeToReach) { this.timeToReach = timeToReach; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
}