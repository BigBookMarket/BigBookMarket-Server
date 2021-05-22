package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "SELECT * FROM message p WHERE p.receiver_id = :id ORDER BY p.created_date DESC", nativeQuery = true)
    List<Message> findByInboxId(Long id);

    @Query(value = "SELECT * FROM message p WHERE p.sender_id = :id ORDER BY p.created_date DESC", nativeQuery = true)
    List<Message> findByOutboxId(Long id);
}
