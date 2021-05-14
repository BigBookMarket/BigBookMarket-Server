package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM post p ORDER BY p.created_date DESC", nativeQuery = true)
    List<Post> findAllDesc();

    @Query(value = "SELECT * FROM post p WHERE p.book_id = :bookId ORDER BY p.created_date DESC", nativeQuery = true)
    List<Post> findByBookId(String bookId);
}
