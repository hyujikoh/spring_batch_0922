package com.example.spring_batch_0922.app.cash.repository;

import com.example.spring_batch_0922.app.cash.entity.CashLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashLogRepository extends JpaRepository<CashLog, Long> {
}