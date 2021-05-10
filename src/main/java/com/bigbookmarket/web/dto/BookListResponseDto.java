package com.bigbookmarket.web.dto;

import com.bigbookmarket.domain.Book;
import lombok.Getter;

@Getter
public class BookListResponseDto {

    private String bookId;
    private String title;
    private String author;
    private String category;
    private String publisher;
    private String pubDate;
    private String image;

    public BookListResponseDto(Book entity) {
        this.bookId = entity.getBookId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.category = entity.getCategory();
        this.publisher = entity.getPublisher();
        this.pubDate = entity.getPubDate();
        this.image = entity.getImage();
    }
}
