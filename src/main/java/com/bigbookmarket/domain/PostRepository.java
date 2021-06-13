package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM post p WHERE p.user_id = :userId ORDER BY p.created_date DESC", nativeQuery = true)
    List<Post> findByUserId(Long userId);

    List<Post> findByUser_userIdOrderByCreatedDateDesc(Long userId);

    List<Post> findByBook_BookIdOrderByCreatedDateDesc(String BookId);
}
