package com.bigbookmarket.web;

import com.bigbookmarket.service.ItemService;
import com.bigbookmarket.web.dto.ItemResponseDto;
import com.bigbookmarket.web.dto.ItemSaveRequestDto;
import com.bigbookmarket.web.dto.ItemUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{itemId}")
    public ResponseEntity update(@PathVariable Long itemId, @RequestBody ItemUpdateRequestDto requestDto) {
        return ResponseEntity.status(OK).body(itemService.update(itemId, requestDto));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity delete(@PathVariable Long itemId) {
        itemService.delete(itemId);
        return ResponseEntity.status(OK).body(itemId);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity findByItemId(@PathVariable Long itemId) {
        ItemResponseDto item = itemService.findByItemId(itemId);
        return ResponseEntity.status(OK).body(item);
    }

    @GetMapping("/list")
    public ResponseEntity findAll() {
        return ResponseEntity.status(OK).body(itemService.findAll());
    }

}
