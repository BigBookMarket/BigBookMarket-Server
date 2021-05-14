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
    public ResponseEntity findByPostId(@PathVariable Long postId) {
        return ResponseEntity.status(OK).body(postService.findById(postId));
    }

    @GetMapping("/list")
    public ResponseEntity findAllDesc() {
        return ResponseEntity.status(OK).body(postService.findAllDesc());
    }

    @GetMapping("/list/{bookId}")
    public ResponseEntity findByBookId(@PathVariable String bookId) {
        return ResponseEntity.status(OK).body(postService.findByBookId(bookId));
    }

//    TODO: 마이페이지에서 내가 작성한 post 전체 보여주기
//    TODO: 카테고리별로 책 보여주기 (기존대로 book에서 가져오는 형식이면 빼도 됨)
}

