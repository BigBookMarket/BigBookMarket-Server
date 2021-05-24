package com.bigbookmarket.web;

import com.bigbookmarket.service.CommentService;
import com.bigbookmarket.web.dto.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class commentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity save(@RequestBody CommentSaveRequestDto requestDto) {
        return ResponseEntity.status(OK).body(commentService.save(requestDto));
    }

    @GetMapping("/list/{postId}")
    public ResponseEntity CommentListResponseDto(@PathVariable Long postId) {
        return ResponseEntity.status(OK).body(commentService.findBYPostIdComment(postId));
    }
}
