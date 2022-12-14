package com.example.spring_batch_0922.app.member.service;

import com.example.spring_batch_0922.app.cash.entity.CashLog;
import com.example.spring_batch_0922.app.cash.service.CashService;
import com.example.spring_batch_0922.app.member.entity.Member;
import com.example.spring_batch_0922.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final CashService cashService;
    public Member join(String username, String password, String email) {
        Member member = Member
                .builder()
                .username(username)
                .password(password)
                .email(email)
                .build();

        memberRepository.save(member);

        return member;
    }

    @Transactional
    public long addCash(Member member, long price, String eventType) {
        CashLog cashLog = cashService.addCash(member, price, eventType);
        long newRestCash = member.getRestCash() + cashLog.getPrice();
        member.setRestCash(newRestCash);
        memberRepository.save(member);

        return newRestCash;
    }

    public long getRestCash(Member member) {
        return member.getRestCash();
    }
}