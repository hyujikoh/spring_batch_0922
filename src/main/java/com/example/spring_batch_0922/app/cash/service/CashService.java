package com.example.spring_batch_0922.app.cash.service;

import com.example.spring_batch_0922.app.cash.entity.CashLog;
import com.example.spring_batch_0922.app.cash.repository.CashLogRepository;
import com.example.spring_batch_0922.app.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashService {
    private final CashLogRepository cashLogRepository;

    public CashLog addCash(Member member, long price) {
        CashLog cashLog = CashLog.builder()
                .member(member)
                .price(price)
                .build();

        cashLogRepository.save(cashLog);

        return cashLog;
    }
}