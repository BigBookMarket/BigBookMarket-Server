package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// TODO: Native Query로 수정
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}
