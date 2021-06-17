package com.bigbookmarket.web;

import com.bigbookmarket.service.CommentService;
import com.bigbookmarket.web.dto.CommentSaveRequestDto;
import com.bigbookmarket.web.dto.CommentUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{commentId}")
    public ResponseEntity update(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDto requestDto) {
        return ResponseEntity.status(OK).body(commentService.update(commentId, requestDto));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity delete(@PathVariable Long commentId) {
        return ResponseEntity.status(OK).body(commentService.delete(commentId));
    }
}