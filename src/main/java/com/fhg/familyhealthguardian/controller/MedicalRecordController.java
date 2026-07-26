package com.fhg.familyhealthguardian.controller;

import com.fhg.familyhealthguardian.entity.MedicalRecord;
import com.fhg.familyhealthguardian.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

@Controller
public class MedicalRecordController {

    @Autowired
    private MedicalRecordRepository repository;

    private static final String UPLOAD_DIR = "uploads/";

    @GetMapping("/records")
    public String listRecords(Model model) {
        model.addAttribute("records", repository.findAll());
        return "records";
    }

    @PostMapping("/records/upload")
    public String uploadRecord(@RequestParam("recordTitle") String recordTitle,
                               @RequestParam("memberName") String memberName,
                               @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Ensure uploads directory exists
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                // Generate unique filename to avoid duplicates
                String storedFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                Path filePath = Paths.get(UPLOAD_DIR + storedFileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // Save to Database
                MedicalRecord record = new MedicalRecord(recordTitle, storedFileName, "/uploads/" + storedFileName, memberName);
                repository.save(record);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/records";
    }

    @GetMapping("/records/delete/{id}")
    public String deleteRecord(@PathVariable("id") Long id) {
        repository.findById(id).ifPresent(record -> {
            // Delete actual file from storage
            try {
                Path filePath = Paths.get(UPLOAD_DIR + record.getFileName());
                Files.deleteIfExists(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Delete record from DB
            repository.deleteById(id);
        });
        return "redirect:/records";
    }
}