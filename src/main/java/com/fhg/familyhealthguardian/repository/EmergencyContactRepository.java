package com.fhg.familyhealthguardian.repository;

import com.fhg.familyhealthguardian.entity.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, Long> {
}