package com.fhg.familyhealthguardian.repository;

import com.fhg.familyhealthguardian.entity.HealthTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthTrackerRepository extends JpaRepository<HealthTracker, Long> {}