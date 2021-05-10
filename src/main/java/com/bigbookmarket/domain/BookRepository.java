package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    @Query(value = "SELECT * FROM book", nativeQuery = true)
    List<Book> findAll();

    List<Book> findByCategory(String category);

    @Query(value = "SELECT DISTINCT b.category FROM book b ORDER BY b.category", nativeQuery = true)
    List<String> findCategory();
}
