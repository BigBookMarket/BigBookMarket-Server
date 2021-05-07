package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// TODO: Native Query로 수정
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(String id);
}