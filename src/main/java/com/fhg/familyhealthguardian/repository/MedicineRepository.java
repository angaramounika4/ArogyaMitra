package com.fhg.familyhealthguardian.repository;

import com.fhg.familyhealthguardian.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}
