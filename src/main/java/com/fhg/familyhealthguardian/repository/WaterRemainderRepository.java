package com.fhg.familyhealthguardian.repository;

import com.fhg.familyhealthguardian.entity.WaterRemainder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterRemainderRepository extends JpaRepository<WaterRemainder, Long> {
    List<WaterRemainder> findByMemberName(String memberName);
}