package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p FROM post p ORDER BY p.postId DESC", nativeQuery = true)
    List<Post> findAllDesc();

    @Query(value = "SELECT * FROM post", nativeQuery = true)
    List<Post> findAll();

    /*List<Post> findById2(Long id); 오류*/

    @Query(value = "SELECT DISTINCT p.id FROM post p ORDER BY p.postId", nativeQuery = true)
    List<String> findId();
}
