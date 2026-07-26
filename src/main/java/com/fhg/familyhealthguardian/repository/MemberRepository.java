package com.fhg.familyhealthguardian.repository;

import com.fhg.familyhealthguardian.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}