package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM post p WHERE p.user_id = :userId ORDER BY p.created_date DESC", nativeQuery = true)
    List<Post> findByUserId(Long userId);

    @Query(value = "SELECT b.book_id, b.author, b.category, convert(b.image, CHAR(70)) as image, b.price_standard, b.pub_date, b.publisher, b.title,\n" +
            "p.post_id, p.created_date, p.category as post_category, p.content, p.title as post_title,\n" +
            "(SELECT count(*) FROM comment c WHERE p.post_id = c.post_id) as comment_count\n" +
            "FROM post p\n" +
            "LEFT JOIN book b ON p.book_id = b.book_id\n" +
            "WHERE p.user_id = :userId\n" +
            "ORDER BY created_date", nativeQuery = true)
    List<Map<String, Object>> findByUser_userIdOrderByCreatedDateDesc(Long userId);

    @Query(value = "SELECT p.*, u.nickname, (SELECT count(*) FROM comment c WHERE p.post_id = c.post_id) as comment_count\n" +
            "FROM post p\n" +
            "LEFT JOIN user u ON p.user_id = u.user_id\n" +
            "WHERE p.book_id = :bookId\n" +
            "ORDER BY created_date DESC", nativeQuery = true)
    List<Map<String, Object>> findByBook_BookIdOrderByCreatedDateDesc(String bookId);
}
