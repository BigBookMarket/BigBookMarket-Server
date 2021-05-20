package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    /*@Query(value = "SELECT * FROM comment c WHERE c.comment_id = :commentId ORDER BY c.created_date DESC", nativeQuery = true)
    List<Comment> CommentListResponseDto2(Long CommentId);
*/
    @Query(value = "SELECT * FROM comment p WHERE p.post_id = :postId ORDER BY p.created_date DESC", nativeQuery = true)
    List<Comment> findBYPostIdComment(Long postId);
}