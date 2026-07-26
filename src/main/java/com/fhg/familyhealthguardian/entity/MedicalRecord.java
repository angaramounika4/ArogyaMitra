package com.fhg.familyhealthguardian.entity;

import jakarta.persistence.*;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recordTitle; // User type chese custom name (Bold ga chupinchedi)
    private String fileName;    // Upload ayina original PDF file name
    private String filePath;    // Server lo file store ayina location
    private String memberName;  // Family member name (Optional tag)

    public MedicalRecord() {}

    public MedicalRecord(String recordTitle, String fileName, String filePath, String memberName) {
        this.recordTitle = recordTitle;
        this.fileName = fileName;
        this.filePath = filePath;
        this.memberName = memberName;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRecordTitle() { return recordTitle; }
    public void setRecordTitle(String recordTitle) { this.recordTitle = recordTitle; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
}