package com.bigbookmarket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @Column(columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(columnDefinition = "CHAR(10)", nullable = false)
    private String id;

    @Column(columnDefinition = "CHAR(60)", nullable = false)
    private String pwd;

    @Column(columnDefinition = "CHAR(11)", nullable = false)
    private String phone;

    @Column(columnDefinition = "CHAR(10)", nullable = false, unique = true)
    private String nickname;
}
