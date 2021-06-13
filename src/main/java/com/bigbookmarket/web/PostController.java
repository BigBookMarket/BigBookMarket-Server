package com.bigbookmarket.web;

import com.bigbookmarket.service.PostService;
import com.bigbookmarket.web.dto.PostSaveRequestDto;
import com.bigbookmarket.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity save(@RequestBody PostSaveRequestDto requestDto) {
        return ResponseEntity.status(OK).body(postService.save(requestDto));
    }

    @PutMapping("/{postId}")
    public ResponseEntity update(@PathVariable Long postId, @RequestBody PostUpdateRequestDto requestDto) {
        return ResponseEntity.status(OK).body(postService.update(postId, requestDto));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity delete(@PathVariable Long postId) {
        postService.delete(postId);
        return ResponseEntity.status(OK).body(postId);
    }

    @GetMapping("/{postId}")
    public ResponseEntity findById(@PathVariable Long postId) {
        return ResponseEntity.status(OK).body(postService.findById(postId));
    }

    @GetMapping("/list/{bookId}")
    public ResponseEntity findByBookId(@PathVariable String bookId) {
        return ResponseEntity.status(OK).body(postService.findByBookId(bookId));
    }
}

