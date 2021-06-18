package com.bigbookmarket.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "SELECT * FROM item i WHERE i.status != :delete ORDER BY i.created_date DESC", nativeQuery = true)
    List<Item> findAll(ItemTradingStatus delete);

    @Query(value = "SELECT * FROM item i, book b WHERE i.book_id = b.book_id AND i.status != :delete AND b.category = :category ORDER BY i.created_date DESC", nativeQuery = true)
    List<Item> findByCategory(String category, ItemTradingStatus delete);

    @Query(value = "SELECT * FROM item i WHERE i.seller_id = :sellerId AND i.status != :delete ORDER BY i.created_date DESC", nativeQuery = true)
    List<Item> findBySellerId(Long sellerId, ItemTradingStatus delete);

    @Query(value = "SELECT * FROM item i WHERE i.buyer_id = :buyerId AND i.status != :delete ORDER BY i.created_date DESC", nativeQuery = true)
    List<Item> findByBuyerId(Long buyerId, ItemTradingStatus delete);

}