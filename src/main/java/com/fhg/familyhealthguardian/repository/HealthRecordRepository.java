package com.fhg.familyhealthguardian.repository;

import com.fhg.familyhealthguardian.entity.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {
}
