package com.bigbookmarket.web;

import com.bigbookmarket.service.MessageService;
import com.bigbookmarket.web.dto.MessageSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity save(@RequestBody MessageSaveRequestDto requestDto) {
        return ResponseEntity.status(OK).body(messageService.save(requestDto));
    }

//    @GetMapping("/list/post/{userId}")
//    public ResponseEntity findByUserId(@PathVariable Long userId) {
//        return ResponseEntity.status(OK).body(postService.findByUserId(userId));
//    }

}