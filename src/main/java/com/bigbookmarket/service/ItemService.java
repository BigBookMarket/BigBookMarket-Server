package com.bigbookmarket.service;

import com.bigbookmarket.domain.BookRepository;
import com.bigbookmarket.domain.Item;
import com.bigbookmarket.domain.ItemRepository;
import com.bigbookmarket.web.dto.ItemListResponseDto;
import com.bigbookmarket.web.dto.ItemResponseDto;
import com.bigbookmarket.web.dto.ItemSaveRequestDto;
import com.bigbookmarket.web.dto.ItemUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final BookRepository bookRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long save(ItemSaveRequestDto requestDto) {
        // TODO: 있으면 그대로, 없으면 insert 되는지 확인해보기
        bookRepository.save(requestDto.getBook());
        return itemRepository.save(requestDto.toEntity()).getItemId();
    }

    @Transactional
    public Long update(Long itemId, ItemUpdateRequestDto requestDto) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId = " + itemId));
        item.update(requestDto.getPrice(), requestDto.getMethod(), requestDto.getDetail());
        return itemId;
    }

    @Transactional
    public void delete(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId = " + itemId));
        itemRepository.delete(item);
    }

    @Transactional(readOnly = true)
    public ItemResponseDto findByItemId(Long itemId) {
        Item entity = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId = " + itemId));
        return new ItemResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ItemListResponseDto> findAll() {
        return itemRepository.findAll().stream()
                .map(ItemListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ItemListResponseDto> findByCategory(String category) {
        return itemRepository.findByCategory(category).stream()
                .map(ItemListResponseDto::new)
                .collect(Collectors.toList());
    }
}
