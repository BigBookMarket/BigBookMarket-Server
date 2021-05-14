package com.bigbookmarket.web;

import com.bigbookmarket.service.ItemService;
import com.bigbookmarket.web.dto.ItemSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity save(@RequestBody ItemSaveRequestDto requestDto) {
        return ResponseEntity.status(OK).body(itemService.save(requestDto));
    }

}
