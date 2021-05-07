package com.bigbookmarket.web;

import com.bigbookmarket.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/category")
    public ResponseEntity<List<String>> findCategory() {
        List<String> list = bookService.findCategory();
        return ResponseEntity.status(OK).body(list);
    }
}
