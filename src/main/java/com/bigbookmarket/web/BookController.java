package com.bigbookmarket.web;

import com.bigbookmarket.common.ResponseMessage;
import com.bigbookmarket.common.StatusCode;
import com.bigbookmarket.domain.ApiResponse;
import com.bigbookmarket.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/category")
    public ResponseEntity<ApiResponse> findCategory() {
        List<String> list = bookService.findCategory();
        return new ResponseEntity(ApiResponse.builder()
                .statusCode(StatusCode.OK)
                .responseMessage(ResponseMessage.READ_BOOK_CATEGORY)
                .data(list)
                .build(), HttpStatus.OK);
    }
}
