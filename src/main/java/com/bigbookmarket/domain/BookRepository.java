package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    @Query(value = "SELECT DISTINCT b.* FROM post p LEFT JOIN book b on p.book_id = b.book_id", nativeQuery = true)
    List<Book> findAll();

    @Query(value = "SELECT DISTINCT b.* FROM post p LEFT JOIN book b on p.book_id = b.book_id WHERE b.category = :category", nativeQuery = true)
    List<Book> findByCategory(String category);

    @Query(value = "SELECT DISTINCT b.category FROM book b ORDER BY b.category", nativeQuery = true)
    List<String> findCategory();
}
