package com.bigbookmarket.web;

import com.bigbookmarket.service.PostService;
import com.bigbookmarket.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Long Create(@RequestBody PostCreateRequest requestDto) {
        return postService.Create(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequest requestDto) {
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        postService.delete(id);
        return id;
    }

    @GetMapping("/{id}")
    public PostResponse read(@PathVariable Long id) {
        return postService.read(id);
    }

    @GetMapping("/list")
    public List<PostListResponse> listRead() {
        return postService.listRead();
    }
}

