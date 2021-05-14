package com.bigbookmarket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {

    @Id
    @Column(columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sellerId", referencedColumnName = "userId")
    private User user;

    @Column(columnDefinition = "MEDIUMINT", nullable = false)
    private Integer price;

    @Enumerated
    @Column(columnDefinition = "TINYINT", nullable = false)
    private ItemTradingMethod method;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String detail;

    @Enumerated
    @Column(columnDefinition = "TINYINT default 0", nullable = false)
    private ItemTradingStatus status;
}
