package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

//    @Query(value = "SELECT * FROM post p WHERE p.user_id = :userId ORDER BY p.created_date DESC", nativeQuery = true)
//    List<Post> findByUserId(Long userId);
}
