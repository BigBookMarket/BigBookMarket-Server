package com.bigbookmarket.service;

import com.bigbookmarket.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public List<String> findCategory() {
        return bookRepository.findCategory();
    }
}
