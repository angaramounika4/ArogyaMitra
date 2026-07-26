package com.fhg.familyhealthguardian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fhg.familyhealthguardian")
public class FamilyHealthGuardianApplication {

    public static void main(String[] args) {
        SpringApplication.run(FamilyHealthGuardianApplication.class, args);
    }
}