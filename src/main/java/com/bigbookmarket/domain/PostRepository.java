package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p FROM post p ORDER BY p.postId DESC", nativeQuery = true)
    List<Post> findAllDesc();

    @Query(value = "SELECT p FROM post p", nativeQuery = true)
    List<Post> findByUserId();

    @Query(value = "SELECT p FROM post p ORDER BY p.postId DESC", nativeQuery = true)
    List<Post> findByPostId();
}
