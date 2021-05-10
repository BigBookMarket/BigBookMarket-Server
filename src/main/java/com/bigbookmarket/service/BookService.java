package com.bigbookmarket.service;

import com.bigbookmarket.domain.BookRepository;
import com.bigbookmarket.web.dto.BookListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<BookListResponseDto> findAll() {
        return bookRepository.findAll().stream()
                .map(BookListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<String> findCategory() {
        return bookRepository.findCategory();
    }
}
