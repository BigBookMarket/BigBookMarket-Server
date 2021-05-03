package com.bigbookmarket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @Column(columnDefinition = "CHAR(10)")
    private String bookId;

    @Column(columnDefinition = "VARCHAR(1024)", nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(512)", nullable = false)
    private String author;

    @Column(columnDefinition = "CHAR(20)", nullable = false)
    private String category;

    @Column(columnDefinition = "VARCHAR(256)", nullable = false)
    private String publisher;

    @Column(columnDefinition = "CHAR(10)", nullable = false)
    private String pubDate;

    @Column(columnDefinition = "MEDIUMINT", nullable = false)
    private Integer priceStandard;

    @Column(columnDefinition = "CHAR(70)", nullable = false)
    private String image;
}
