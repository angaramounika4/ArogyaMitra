package com.fhg.familyhealthguardian.repository;

import com.fhg.familyhealthguardian.entity.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
}
