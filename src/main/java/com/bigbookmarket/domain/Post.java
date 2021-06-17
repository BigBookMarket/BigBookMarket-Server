package com.bigbookmarket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @Column(columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    private Book book;

    @Enumerated
    @Column(columnDefinition = "TINYINT", nullable = false)
    private PostCategory category;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> comment = new ArrayList<>();

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

