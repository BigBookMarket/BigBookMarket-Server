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
public class Item extends BaseTimeEntity {

    @Id
    @Column(columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "sellerId", referencedColumnName = "userId")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "buyerId", referencedColumnName = "userId")
    private User buyer;

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

    public void update(Integer price, ItemTradingMethod method, String detail) {
        this.price = price;
        this.method = method;
        this.detail = detail;
    }

    public void deal(User buyer) {
        this.buyer = buyer;
        this.status = ItemTradingStatus.DEAL;
    }

    public void cancel() {
        this.buyer = null;
        this.status = ItemTradingStatus.SALE;
    }

    public void sold() {
        this.status = ItemTradingStatus.SOLD;
    }

    public void delete() {
        this.status = ItemTradingStatus.DELETE;
    }
}
