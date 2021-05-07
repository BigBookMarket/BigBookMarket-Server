package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// TODO: Native Query로 수정
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    Optional<VerificationToken> findByToken(String token);
}
