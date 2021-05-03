package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {

    @Query("SELECT DISTINCT b.category FROM Book b ORDER BY b.category")
    List<String> findCategory();
}
