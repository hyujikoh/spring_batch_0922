package com.example.spring_batch_0922.app.member.repository;

import com.example.spring_batch_0922.app.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}