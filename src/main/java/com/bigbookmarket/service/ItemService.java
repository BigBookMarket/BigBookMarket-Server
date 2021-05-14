package com.bigbookmarket.service;

import com.bigbookmarket.domain.BookRepository;
import com.bigbookmarket.domain.Item;
import com.bigbookmarket.domain.ItemRepository;
import com.bigbookmarket.web.dto.ItemResponseDto;
import com.bigbookmarket.web.dto.ItemSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public ItemResponseDto findByItemId(Long itemId) {
        Item entity = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Item이 없습니다. itemId = " + itemId));
        ItemResponseDto test = new ItemResponseDto(entity);
        return test;
    }
}
