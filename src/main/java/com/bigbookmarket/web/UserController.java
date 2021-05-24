package com.bigbookmarket.web;

import com.bigbookmarket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/sale/{id}")
    public ResponseEntity findBySellerId(@PathVariable String id) {
        return ResponseEntity.status(OK).body(userService.findBySellerId(id));
    }

    @GetMapping("/buy/{id}")
    public ResponseEntity findByBuyerId(@PathVariable String id) {
        return ResponseEntity.status(OK).body(userService.findByBuyerId(id));
    }

    @GetMapping("/inbox/{id}")
    public ResponseEntity findByInboxId(@PathVariable String id) {
        return ResponseEntity.status(OK).body(userService.findByInboxId(id));
    }

    @GetMapping("/outbox/{id}")
    public ResponseEntity findByOutboxId(@PathVariable String id) {
        return ResponseEntity.status(OK).body(userService.findByOutboxId(id));
    }
}
