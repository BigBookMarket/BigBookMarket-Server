package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "SELECT * FROM item i ORDER BY i.created_date DESC", nativeQuery = true)
    List<Item> findAll();

    @Query(value = "SELECT * FROM item i, book b WHERE i.book_id = b.book_id AND b.category = :category ORDER BY i.created_date DESC", nativeQuery = true)
    List<Item> findByCategory(String category);

    @Query(value = "SELECT * FROM item i WHERE i.seller_id = :userId ORDER BY i.created_date DESC", nativeQuery = true)
    List<Item> findItem(Long userId);
}