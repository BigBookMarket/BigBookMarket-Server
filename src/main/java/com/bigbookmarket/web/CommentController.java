package com.bigbookmarket.web;

import com.bigbookmarket.service.CommentService;
import com.bigbookmarket.web.dto.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity save(@RequestBody CommentSaveRequestDto requestDto) {
        return ResponseEntity.status(OK).body(commentService.save(requestDto));
    }

    // TODO: update

    // TODO: delete
}
